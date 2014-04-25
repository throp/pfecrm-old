package com.pfe.crm.core.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.ActionLog;
import com.pfe.crm.domain.entity.Employee;

/**
 * BaseAction.java
 * 
 * This is a base action (i.e. front controller) to handle exception handling,
 * logging, etc. consistently.
 * 
 * Provides services for transactions, hibernate session initialization, request
 * form mapping.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Mar 22, 2006
 */
public abstract class BaseAction extends Action
{
    // DATA MEMBERS
    protected Category LOG = Category.getInstance(BaseAction.class);

    private Employee employee = null;

    private Session session;

    private boolean isSessionClosed = false;

    private Transaction transaction;

    private RequestParameterMap map;

    protected final static int MAX_RECORDS_TO_SHOW = 50;

    // ABSTRACT METHODS
    /**
     * Abstract method called by main execute().
     */
    abstract protected ActionForward subExecute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response);

    // PUBLIC METHODS
    /**
     * Core execute method, which then calls the sub-execute method. Uses the
     * Template pattern (GoF).
     */
    final public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        setEmployee(request);
        map = RequestParameterMap.getInstance(request);
        logEntry(map);

        try {
            session = HibernateUtilities.getSession();
            transaction = session.beginTransaction();

            ActionForward forward = subExecute(mapping, form, request, response);

            if (!isSessionClosed) {
                transaction.commit();
            }

            logExit(forward);

            return forward;
        } catch (Exception e) {
            logError(e);
            rollbackTransaction();
            throw e;
        } finally {
            if (!isSessionClosed) {
                HibernateUtilities.closeSession(session);
            }
        }
    }

    // PRIVATE METHODS
    /**
     * @throws HibernateException
     */
    private void rollbackTransaction() throws HibernateException
    {
        if (transaction != null) {
            LOG.info("  Rolling back transaction!");
            transaction.rollback();
        } else {
            LOG
                    .warn("  transaction null when trying to roll back!  Could indicate error.");
        }
    }

    /**
     * Check to see if the user is in the session, and if not, retrieve it from
     * the database and put it there.
     */
    private void setEmployee(HttpServletRequest request)
    {
        String principalUsername = request.getUserPrincipal().getName();

        HttpSession httpSession = request.getSession();
        this.employee = (Employee) httpSession.getAttribute("employee");

        if (this.employee == null
                || !this.employee.getName().equals(principalUsername)) {
            this.employee = retrieveEmployee(principalUsername);
            httpSession.setAttribute("employee", this.employee);
        }
    }

    /**
     * Retrieve the user from the database.
     */
    private Employee retrieveEmployee(String username)
    {
        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtilities.getSession();
            Query query = session
                    .createQuery("from Employee where userName = :uname");
            query.setString("uname", username);
            List list = query.list();
            if (list == null || list.isEmpty()) {
                throw new IllegalStateException("No employee with username: "
                        + username);
            }
            if (list.size() > 1) {
                throw new IllegalStateException(
                        "More than one employee with username: " + username);
            }
            employee = (Employee) list.get(0);
            logEmployee(employee);
        } finally {
            HibernateUtilities.closeSession(session);
        }
        return employee;
    }

    /**
     * Log the user that is set.
     */
    private void logEmployee(Employee employee)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("  Employee retrieved: ");
        sb.append(employee.getUserName());
        sb.append(", employee: ");
        sb.append(employee.getFirstName());
        sb.append(" ");
        sb.append(employee.getLastName());
        LOG.debug(sb.toString());
    }

    /**
     * Log the entry of the action.
     */
    private void logEntry(RequestParameterMap map)
    {
        StringBuffer sb = new StringBuffer(100);
        sb.append(">> [");
        sb.append(getEmployee().getName());
        sb.append("] ");
        sb.append(this.getClass().getName());
        sb.append("\n");
        sb.append(map.toString());
        LOG.debug(sb.toString());
    }

    /**
     * Log the exit of the action
     */
    private void logExit(ActionForward forward)
    {
        StringBuffer sb = new StringBuffer(100);
        sb.append("<< [");
        sb.append(getEmployee().getName());
        sb.append("] ");
        sb.append(this.getClass().getName());
        sb.append(" - ");
        sb.append(forward.getPath());
        LOG.debug(sb.toString());
    }

    /**
     * Log the details of the error from an action.
     */
    private void logError(Exception e)
    {
        StringBuffer sb = new StringBuffer(100);
        sb.append("EXCEPTION [");
        sb.append(getEmployee().getName());
        sb.append("] ");
        sb.append(this.getClass().getName());
        LOG.error(sb.toString());
        LOG.error(e.getMessage(), e);
    }

    /**
     * @return Returns the map.
     */
    public RequestParameterMap getMap()
    {
        if (this.map == null) {
            throw new IllegalStateException("Map should not be null in: "
                    + this.getClass().getName());
        }
        return map;
    }

    /**
     * @return Returns the session.
     */
    public Session getSession()
    {
        if (isSessionClosed) {
            session = HibernateUtilities.getSession();
            transaction = session.beginTransaction();
        }
        if (this.session == null) {
            throw new IllegalStateException("Session should not be null in: "
                    + this.getClass().getName());
        }
        return session;
    }

    /**
     * Get the user that is associated with this session.
     */
    public Employee getEmployee()
    {
        if (this.employee == null) {
            throw new IllegalStateException("Employee should not be null in: "
                    + this.getClass().getName());
        }
        return this.employee;
    }

    /**
     * Write an action log to record this action by this employee.
     */
    protected void saveActionLog(String description)
    {
        ActionLog actionLog = new ActionLog(description);
        actionLog.setEmployee(employee);
        actionLog.setDate(new Date());
        actionLog.setTime(new Date());
        session.save(actionLog);
    }
}

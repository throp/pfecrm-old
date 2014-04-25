package com.pfe.crm.action.admin;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.ListManager;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.dao.admin.EmployeeDAO;
import com.pfe.crm.dao.scheduling.JobDAO;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Job;

/**
 * DeleteEmployeeAction.java
 * 
 * Delete the employee, given the id.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 29, 2006
 */
public class DeleteEmployeeAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        Integer employeeId = new Integer(getMap().getInt("employeeId"));

        JobDAO jobDAO = new JobDAO(getSession());
        EmployeeDAO employeeDAO = new EmployeeDAO(getSession());

        Employee employee = employeeDAO.get(employeeId);
        Collection<Job> jobs = jobDAO.retrieveJobsForEmployee(employee);
        if (jobs == null || jobs.isEmpty()) {
            employeeDAO.delete(employee);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deleted " + employee.getName() + ".");
            saveActionLog("Deleted employee: " + employee.getName());
        } else {
            employee.setIsActive(Boolean.FALSE);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully inactived " + employee.getName() + ".");
            saveActionLog("Deactivated employee: " + employee.getName());
        }

        ListManager.getInstance().refreshEmployees();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }
}

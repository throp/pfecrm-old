package com.pfe.crm.report.admin;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Employee;

/**
 * ActionLogLoader.java
 * 
 * Load the action logs for an employee.
 * 
 * @author Ben Northrop Dec 8, 2006
 * 
 */
public class ActionLogLoader extends LoadableAdaptor
{
    // DATA MEMBERS
    private int employeeId;

    /**
     * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
     */
    @Override
    public void init(ReportParameterMap map) throws ReportValidationException
    {
        employeeId = map.getInt("employeeId");
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadHeader()
     */
    @Override
    public Object loadHeader() throws ReportException
    {
        Session session = HibernateUtilities.getSession();
        Employee employee = (Employee) session.get(Employee.class, new Integer(
                employeeId));
        return employee;
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadBody()
     */
    @Override
    public ArrayList loadBody() throws ReportException
    {
        Session session = HibernateUtilities.getSession();
        StringBuffer hql = new StringBuffer();
        hql.append(" select al ");
        hql.append(" from ActionLog al ");
        hql.append(" join al.employee e ");
        hql.append(" where e.id = :employeeId ");

        Query query = session.createQuery(hql.toString());
        query.setParameter("employeeId", new Integer(employeeId));
        return new ArrayList(query.list());
    }

}

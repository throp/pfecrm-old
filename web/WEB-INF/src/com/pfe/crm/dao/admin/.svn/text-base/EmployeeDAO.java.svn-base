package com.pfe.crm.dao.admin;

import org.hibernate.Session;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Employee;

/**
 * EmployeeDAO.java
 * 
 * All data access logic for employees.
 * 
 * @author Ben Northrop
 * Jun 4, 2007
 *
 */
public class EmployeeDAO extends BaseDAO<Employee>
{
    /**
     * Default constructor - passing hibernate session.
     */
    public EmployeeDAO(Session session)
    {
        super(session);
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Employee.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Employee";
    }
    

}

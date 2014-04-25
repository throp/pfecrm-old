package com.pfe.crm.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.ListManager;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Role;
import com.pfe.crm.domain.type.EmployeeType;
import com.pfe.crm.domain.type.RoleType;

/**
 * AddEmployeeAction.java
 * 
 * Add an employee.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jul 17, 2006
 */
public class AddEmployeeAction extends BaseAction
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
        RequestParameterMap map = getMap();
        Employee employee = new Employee();
        employee.setFirstName(map.getString("firstName"));
        employee.setLastName(map.getString("lastName"));
        employee.setIsActive(Boolean.TRUE);
        EmployeeType employeeType = EmployeeType.getInstance(map
                .getInt("employeeType"));
        employee.setEmployeeType(employeeType);

        addRole(map, employee);

        Session session = getSession();

        session.save(employee);
        saveActionLog("Added employee: " + employee.getFirstName() + " "
                + employee.getLastName());

        ListManager.getInstance().refreshEmployees();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

    /**
     * Add the user to the employee, if the username and password were entered.
     * 
     * @param map
     * @param employee
     */
    private void addRole(RequestParameterMap map, Employee employee)
    {
        String userName = map.getString("userName", "");
        String password = map.getString("password", "");
        if (!"".equals(userName) && !"".equals(password)) {
            employee.setUserName(userName);
            employee.setPassword(password);

            Role role = new Role();
            role.setRoleType(RoleType.PFE_USER);
            role.setUserName(map.getString("userName"));
            employee.addRole(role);
        }
    }

}

package com.pfe.crm.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Role;
import com.pfe.crm.domain.type.EmployeeType;
import com.pfe.crm.domain.type.RoleType;

/**
 * EditEmployeeAction.java
 * 
 * Edit the employee, given the id.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 29, 2006
 */
public class EditEmployeeAction extends BaseAction
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
		int employeeId = map.getInt("employeeId");
		String firstName = map.getString("firstName");
		String lastName = map.getString("lastName");
		String username = map.getString("userName", "");
		String password = map.getString("password", "");
		Session session = getSession();
		Employee employee = null;

		employee = (Employee) session.get(Employee.class, new Integer(employeeId));
        System.out.println(employee.getFirstName());
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmployeeType(EmployeeType.getInstance(map.getInt("employeeType")));
		if (!"".equals(username) && !"".equals(password)) {
				Role role = new Role();
				role.setRoleType(RoleType.PFE_USER);
				role.setUserName(map.getString("userName"));
				employee.addRole(role);

			employee.setUserName(username);
			employee.setPassword(password);
		}
        

		MessageUtilities.addConfirmationMessage(request, "The employee information for "
				+ firstName + " " + lastName + " has been successfully updated");

		request.setAttribute("employee", employee);
		return mapping.findForward("Success");
	}

}

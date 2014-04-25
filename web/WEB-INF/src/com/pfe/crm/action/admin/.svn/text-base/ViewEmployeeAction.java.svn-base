package com.pfe.crm.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Employee;

/**
 * GoToEditEmployeeAction.java
 * 
 * Go to the edit employee screen.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 29, 2006
 */
public class ViewEmployeeAction extends BaseAction
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
		Session session = getSession();
		Employee employee = (Employee) session.get(Employee.class, new Integer(employeeId));
		Employee currentEmployee = getEmployee();
        if(currentEmployee.getId() == employee.getId()) { 
            request.setAttribute("isCurrentUser", "yes");
        }
        else { 
            request.setAttribute("isCurrentUser", "no");
        }
		request.setAttribute("employee", employee);
		return mapping.findForward("Success");
	}
}

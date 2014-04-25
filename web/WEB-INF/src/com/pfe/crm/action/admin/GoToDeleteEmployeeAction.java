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
 * GoToDeleteEmployeeAction.java
 * 
 * 
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 29, 2006
 */
public class GoToDeleteEmployeeAction extends BaseAction
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
		Employee employee = null;

		employee = (Employee) session.get(Employee.class, new Integer(employeeId));

		request.setAttribute("employee", employee);
		return mapping.findForward("Success");
	}

}

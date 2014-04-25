package com.pfe.crm.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.ListManager;

/**
 * ViewEmployeesAction.java
 * 
 * View all employees for USI.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jul 17, 2006
 */
public class ViewAllEmployeesAction extends BaseAction
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
		Session session = getSession();
		List employees = null;

		Query query = session.createQuery("from Employee");
		employees = query.list();

        ListManager.getInstance().refreshEmployees();
		request.setAttribute("employees", employees);
		return mapping.findForward("Success");
	}

}

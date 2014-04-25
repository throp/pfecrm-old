package com.pfe.crm.action.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;

/**
 * SearchCustomersAction.java
 * 
 * Search for all customers and return a list.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 20, 2006
 */
public class SearchCustomersAction extends BaseAction
{
	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward subExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		Session session = getSession();

		Query query = session.createQuery("from Customer");
		List customers = query.list();

		request.setAttribute("customers", customers);
		return mapping.findForward("Success");
	}
}

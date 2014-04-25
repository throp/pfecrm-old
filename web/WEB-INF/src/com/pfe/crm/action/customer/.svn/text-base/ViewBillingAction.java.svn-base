package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Customer;

/**
 * ViewBillingAction.java
 * 
 * For a given customer ID, find the customer contact info.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 20, 2006
 */
public class ViewBillingAction extends BaseAction
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
		RequestParameterMap map = getMap();
		int customerId = map.getInt("id");
		Session session = getSession();
		Customer customer = (Customer) session.get(Customer.class, new Integer(customerId));

		request.getSession().setAttribute("customer", customer);
		return mapping.findForward("Success");
	}

}

package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.type.CustomerStatus;

/**
 * UpdateCustomerStatusAction.java
 * 
 * Update the status of a customer. Note: this may involve more complicated
 * logic later.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 5, 2006
 */
public class UpdateCustomerStatusAction extends BaseAction
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
		int customerId = map.getInt("customerId");
		CustomerStatus status = CustomerStatus.getInstance(map.getInt("customerStatusId"));
		Session session = getSession();

		Customer customer = (Customer) session.load(Customer.class, new Integer(customerId));
		customer.setStatus(status);
		session.save(customer);

		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		redirect.addParameter("id", "" + customerId);
		return redirect;
	}

}

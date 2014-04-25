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
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Customer;

/**
 * DeleteCustomerAction.java
 * 
 * Delete a customer given the id.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 21, 2006
 */
public class DeleteCustomerAction extends BaseAction
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
		String name = map.getString("name");
		Session session = getSession();
		Customer customer = null;

		customer = (Customer) session.load(Customer.class, new Integer(map.getInt("id")));
		session.delete(customer);

        saveActionLog("Deleted customer: " + customer.getName());
        
		MessageUtilities.addConfirmationMessage(request, "'" + name + "' has been deleted.");

		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		return redirect;
	}

}

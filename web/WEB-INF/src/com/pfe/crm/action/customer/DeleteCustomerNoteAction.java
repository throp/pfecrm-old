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
import com.pfe.crm.domain.entity.CustomerNote;

/**
 * DeleteCustomerNoteAction.java
 * 
 * Delete a note for a customer.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 5, 2006
 */
public class DeleteCustomerNoteAction extends BaseAction
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
		MessageUtilities.addConfirmationMessage(request, "The customer note has been deleted.");

		RequestParameterMap map = getMap();
		int customerNoteId = map.getInt("id");
		int customerId = map.getInt("customerId");
		Session session = getSession();

		CustomerNote customerNote = (CustomerNote) session.load(CustomerNote.class, new Integer(
				customerNoteId));
		session.delete(customerNote);

        saveActionLog("Deleted customer note for customer: " + customerId);
        
		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		redirect.addParameter("id", customerId + "");
		return redirect;
	}

}

package com.pfe.crm.action.customer;

import java.util.Date;

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
import com.pfe.crm.domain.entity.CustomerNote;
import com.pfe.crm.domain.entity.Employee;

/**
 * AddCustomerNoteAction.java
 * 
 * Add the note for a given customer.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 5, 2006
 */
public class AddCustomerNoteAction extends BaseAction
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
		int employeeId = getEmployee().getId();
		String note = map.getString("note");
		Date date = new Date();
		Session session = getSession();
		Employee employee = null;
		Customer customer = null;
		CustomerNote customerNote = new CustomerNote();
		customerNote.setEnteredDate(date);
		customerNote.setNote(note);

		employee = (Employee) session.get(Employee.class, new Integer(employeeId));
		customer = (Customer) session.get(Customer.class, new Integer(customerId));
		employee.addCustomerNote(customerNote);
		customer.addNote(customerNote);
		session.save(customerNote);

		MessageUtilities.addConfirmationMessage(request, "Added note successfully");

		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		redirect.addParameter("id", "" + customerId);
		return redirect;
	}

}

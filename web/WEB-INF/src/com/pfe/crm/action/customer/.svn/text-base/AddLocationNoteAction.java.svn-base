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
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.LocationNote;

/**
 * AddLocationNoteAction.java
 * 
 * Add a note that is associated with a location.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 2, 2006
 */
public class AddLocationNoteAction extends BaseAction
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
		int locationId = map.getInt("locationId");
		int employeeId = getEmployee().getId();
		String note = map.getString("note");
		Date date = new Date();
		Session session = getSession();
		Employee employee = null;
		Location location = null;
		LocationNote locationNote = new LocationNote();
		locationNote.setEnteredDate(date);
		locationNote.setNote(note);

		employee = (Employee) session.get(Employee.class, new Integer(employeeId));
		location = (Location) session.get(Location.class, new Integer(locationId));
		employee.addLocationNote(locationNote);
		location.addNote(locationNote);
		session.save(locationNote);

		MessageUtilities.addConfirmationMessage(request, "Added note successfully");

		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		redirect.addParameter("locationId", "" + locationId);
		return redirect;
	}

}

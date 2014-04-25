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
import com.pfe.crm.domain.entity.LocationNote;

/**
 * DeleteLocationNoteAction.java
 * 
 * Delete a location note.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 4, 2006
 */
public class DeleteLocationNoteAction extends BaseAction
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
		int locationNoteId = map.getInt("id");
		int locationId = map.getInt("locationId");
		Session session = getSession();

		LocationNote locationNote = (LocationNote) session.load(LocationNote.class, new Integer(
				locationNoteId));
		session.delete(locationNote);

		MessageUtilities.addConfirmationMessage(request, "The location note has been deleted.");

		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		redirect.addParameter("locationId", locationId + "");
		return redirect;
	}

}

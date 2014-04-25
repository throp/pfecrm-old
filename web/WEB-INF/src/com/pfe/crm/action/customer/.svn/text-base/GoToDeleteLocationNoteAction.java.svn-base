package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Location;

/**
 * GoToDeleteLocationNoteAction.java
 * 
 * Go to the confirmation screen for deleting a location note.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 4, 2006
 */
public class GoToDeleteLocationNoteAction extends BaseAction
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
		request.setAttribute("id", map.getString("id"));

		Session session = getSession();
		Location location = (Location) session.get(Location.class, new Integer(locationId));

		request.setAttribute("location", location);
		return mapping.findForward("Success");
	}

}

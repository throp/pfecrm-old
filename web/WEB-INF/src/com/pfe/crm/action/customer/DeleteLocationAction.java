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
import com.pfe.crm.domain.entity.Location;

/**
 * DeleteLocationAction.java
 * 
 * Delete a location given the id.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 21, 2006
 */
public class DeleteLocationAction extends BaseAction
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
		RequestParameterMap map = RequestParameterMap.getInstance(request);
		String name = map.getString("name");
		int customerId = 0;
		Session session = getSession();
		Location location = null;

		location = (Location) session.load(Location.class, new Integer(map.getInt("id")));
		customerId = location.getCustomer().getId();
		session.delete(location);

        saveActionLog("Deleted location: " + location.getName());
        
		MessageUtilities.addConfirmationMessage(request, "'" + name
				+ "' location has been deleted.");

		ActionRedirect redirect = new ActionRedirect(mapping.findForward("Success"));
		redirect.addParameter("id", customerId + "");
		return redirect;
	}

}

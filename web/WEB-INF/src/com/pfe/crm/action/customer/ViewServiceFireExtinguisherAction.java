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
import com.pfe.crm.domain.entity.Service;

/**
 * ViewServiceFireExtinguisherAction.java
 * 
 * Get the Fire Extinguisher info for a location.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 3, 2006
 */
public class ViewServiceFireExtinguisherAction extends BaseAction
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
		int serviceId = map.getInt("serviceId");
		Session session = getSession();
		Service service = (Service) session.get(Service.class, new Integer(serviceId));
        Location location = service.getLocation();
		request.setAttribute("location", location);
        request.setAttribute("service", service);
		return mapping.findForward("Success");
	}

}

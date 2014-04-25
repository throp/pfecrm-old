package com.pfe.crm.action.customer;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Office;
import com.pfe.crm.domain.entity.Service;

/**
 * ViewLocationAction.java
 * 
 * View the Location information for a given customer/location id.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jul 13, 2006
 */
public class ViewLocationAction extends BaseAction
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
		Session session = getSession();
		Customer customer = null;
		Office office = null;

		Location location = (Location) session.get(Location.class, new Integer(locationId));
		customer = location.getCustomer();
        Set services = location.getServices();
        Iterator iter = services.iterator();
        System.out.println("services: " + services);
        while(iter.hasNext()) { 
            System.out.println(((Service) iter.next()).getId() + "");
        }
		customer.getName();
		office = customer.getOffice();
		office.getName();

		request.setAttribute("location", location);
		request.setAttribute("customer", customer);
        request.getSession().setAttribute("customer", customer);
		return mapping.findForward("Success");
	}

}

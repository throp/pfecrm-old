package com.pfe.crm.action.customer;

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

/**
 * GoToDeleteFireExtinguisherAction.java
 * 
 * Go to the confirmation screen.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 21, 2006
 */
public class GoToDeleteFireExtinguisherAction extends BaseAction
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
        int id = map.getInt("inventoryItemId");
        String locationId = map.getString("locationId");
        request.setAttribute("inventoryItemId", id + "");
        Session session = getSession();
        Location location = (Location) session.get(Location.class, new Integer(
                locationId));
        Customer customer = location.getCustomer();
        customer.getName();
        request.setAttribute("location", location);
        request.setAttribute("locationId", locationId);
        request.setAttribute("customer", customer);
        return mapping.findForward("Success");
    }

}
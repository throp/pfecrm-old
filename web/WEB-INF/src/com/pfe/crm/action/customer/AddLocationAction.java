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
import com.pfe.crm.domain.entity.Location;

/**
 * AddLocationAction.java
 * 
 * Add a location to a given customer.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 27, 2006
 */
public class AddLocationAction extends BaseAction
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

        Integer customerId = new Integer(map.getInt("customerId"));
        Session session = getSession();
        Customer customer = (Customer) session.get(Customer.class, customerId);

        Location location = null;
        if (map.getBoolean("isUseCustomerAddress", false)) {
            location = initLocationFromCustomer(customer, map);
        } else {
            location = initLocation(map);
        }

        if (map.getBoolean("isUseCustomerContact", false)) {
            initLocationContactFromCustomer(customer, location);
        } else {
            initLocationContact(map, location);
        }

        initPO(map, location, customer);
        customer.addLocation(location);

        saveActionLog("Added location: " + location.getName());
        
        MessageUtilities.addConfirmationMessage(request, "The location '"
                + location.getName() + "' for customer '" + customer.getName()
                + "' has been added successfully");
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("id", "" + customer.getId());
        return redirect;
    }

    /**
     * @param map
     * @param location
     */
    private void initLocationContact(RequestParameterMap map, Location location)
    {
        location.setContactFirstName(map.getString("contactFirstName", ""));
        location.setContactLastName(map.getString("contactLastName", ""));
        location.setContactPhoneNumber(map.getString("contactPhoneNumber", ""));
        location.setContactPhoneExtension(map.getString("contactPhoneExtension", ""));
        location.setContactTitle(map.getString("contactTitle", ""));
        location.setContactEmailAddress(map
                .getString("contactEmailAddress", ""));
        location.setIsUseCustomerContact(false);
    }

    /**
     * @param customer
     * @param location
     */
    private void initLocationContactFromCustomer(Customer customer,
            Location location)
    {
        location.setContactFirstName(customer.getPrimaryContactFirstName());
        location.setContactLastName(customer.getPrimaryContactLastName());
        location.setContactPhoneNumber(customer.getPrimaryContactPhoneNumber());
        location.setContactPhoneExtension(customer.getPrimaryContactPhoneExtension());
        location.setContactTitle(customer.getPrimaryContactTitle());
        location.setContactEmailAddress(customer
                .getPrimaryContactEmailAddress());
        location.setIsUseCustomerContact(true);
    }

    /**
     * @param customer
     * @return
     */
    private Location initLocationFromCustomer(Customer customer,
            RequestParameterMap map)
    {
        Location location = new Location();
        location.setName(map.getString("name"));
        location.setAddress1(customer.getAddress1());
        location.setAddress2(customer.getAddress2());
        location.setAddress3(customer.getAddress3());
        location.setCity(customer.getCity());
        location.setState(customer.getState());
        location.setZip(customer.getZip());
        location.setIsUseCustomerAddress(true);
        return location;
    }

    /**
     * @param map
     * @param location
     * @param customer
     */
    private void initPO(RequestParameterMap map, Location location,
            Customer customer)
    {
        boolean isBlanketPO = map.getBoolean("isBlanketPO", false);
        if (isBlanketPO) {
            location.setPo(customer.getBlanketPO());
            location.setIsBlanketPO(true);
        } else {
            location.setPo(map.getString("po", ""));
        }
    }

    /**
     * @param map
     * @return
     */
    private Location initLocation(RequestParameterMap map)
    {
        Location location = new Location();
        location.setName(map.getString("name"));
        location.setAddress1(map.getString("address1"));
        location.setAddress2(map.getString("address2", ""));
        location.setAddress3(map.getString("address3", ""));
        location.setCity(map.getString("city"));
        location.setState(map.getString("state"));
        location.setZip(map.getString("zip"));
        location.setIsUseCustomerAddress(false);
        return location;
    }
}

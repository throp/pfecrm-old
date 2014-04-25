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
 * EditLocationAction.java
 * 
 * Edit the location.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jul 13, 2006
 */
public class EditLocationAction extends BaseAction
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

        Session session = getSession();
        Location location = (Location) session.load(Location.class,
                new Integer(map.getInt("id")));
        Customer customer = location.getCustomer();
        if (map.getBoolean("isUseCustomerAddress", false)) {
            populateLocationFromCustomer(map, location, customer);
        } else {
            populateLocation(map, location);
        }

        if (map.getBoolean("isUseCustomerContact", false)) {
            populateLocationContactFromCustomer(customer, location);
        } else {
            populateLocationContact(map, location);
        }

        location.setPo(map.getString("po", ""));
        boolean isBlanketPO = map.getBoolean("isBlanketPO", false);
        if (isBlanketPO) {
            location.setPo(customer.getBlanketPO());
            location.setIsBlanketPO(true);
        } else {
            location.setIsBlanketPO(false);
        }

        session.update(location);

        saveActionLog("Updated location information for location: "
                + location.getName());

        MessageUtilities.addConfirmationMessage(request,
                "The location information for '" + location.getName()
                        + "' has been successfully updated.");
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("locationId", "" + location.getId());
        return redirect;
    }

    /**
     * @param map
     * @param location
     * @param customer
     */
    private void populateLocationFromCustomer(RequestParameterMap map,
            Location location, Customer customer)
    {
        location.setName(map.getString("name"));
        location.setIsUseCustomerAddress(true);
        location.setAddress1(customer.getAddress1());
        location.setAddress2(customer.getAddress2());
        location.setAddress3(customer.getAddress3());
        location.setCity(customer.getCity());
        location.setState(customer.getState());
        location.setZip(customer.getZip());
    }

    /**
     * @param map
     * @param location
     */
    private void populateLocation(RequestParameterMap map, Location location)
    {
        location.setName(map.getString("name"));
        location.setIsUseCustomerAddress(false);
        location.setAddress1(map.getString("address1"));
        location.setAddress2(map.getString("address2", ""));
        location.setAddress3(map.getString("address3", ""));
        location.setCity(map.getString("city"));
        location.setState(map.getString("state"));
        location.setZip(map.getString("zip"));
    }

    /**
     * @param map
     * @param location
     */
    private void populateLocationContact(RequestParameterMap map,
            Location location)
    {
        location.setContactFirstName(map.getString("contactFirstName", ""));
        location.setContactLastName(map.getString("contactLastName", ""));
        location.setContactPhoneNumber(map.getString("contactPhoneNumber", ""));
        location.setContactPhoneExtension(map.getString(
                "contactPhoneExtension", ""));
        location.setContactTitle(map.getString("contactTitle", ""));
        location.setContactEmailAddress(map
                .getString("contactEmailAddress", ""));
        location.setIsUseCustomerContact(false);
    }

    /**
     * @param customer
     * @param location
     */
    private void populateLocationContactFromCustomer(Customer customer,
            Location location)
    {
        location.setContactFirstName(customer.getPrimaryContactFirstName());
        location.setContactLastName(customer.getPrimaryContactLastName());
        location.setContactPhoneNumber(customer.getPrimaryContactPhoneNumber());
        location.setContactPhoneExtension(customer
                .getPrimaryContactPhoneExtension());
        location.setContactTitle(customer.getPrimaryContactTitle());
        location.setContactEmailAddress(customer
                .getPrimaryContactEmailAddress());
        location.setIsUseCustomerContact(true);
    }
}

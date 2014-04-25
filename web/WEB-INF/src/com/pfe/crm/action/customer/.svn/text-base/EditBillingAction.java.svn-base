package com.pfe.crm.action.customer;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.dao.customer.CustomerDAO;
import com.pfe.crm.dao.customer.OfficeDAO;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Office;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

/**
 * EditBillingAction.java
 * 
 * Edit contact information for a customer.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 22, 2006
 */
public class EditBillingAction extends BaseAction
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

        CustomerDAO customerDAO = new CustomerDAO(getSession());
        OfficeDAO officeDAO = new OfficeDAO(getSession());
        Customer customer = customerDAO.get(map.getInt("id"));
        Office office = officeDAO.get(map.getInt("officeId"));
        if (!office.equals(customer.getOffice())) {
            customer.setOffice(office);
        }
        customer.setName(map.getString("name"));
        customer.setAddress1(map.getString("address1"));
        customer.setAddress2(map.getString("address2", ""));
        customer.setAddress3(map.getString("address3", ""));
        customer.setCity(map.getString("city"));
        customer.setState(map.getString("state"));
        customer.setZip(map.getString("zip"));
        customer.setFaxNumber(map.getString("faxNumber", ""));
        customer.setBlanketPO(map.getString("blanketPO", ""));
        customer.setPrimaryContactFirstName(map.getString(
                "primaryContactFirstName", ""));
        customer.setPrimaryContactLastName(map.getString(
                "primaryContactLastName", ""));
        customer.setPrimaryContactPhoneNumber(map.getString(
                "primaryContactPhoneNumber", ""));
        customer.setPrimaryContactPhoneExtension(map.getString(
                "primaryContactPhoneExtension", ""));
        customer.setPrimaryContactTitle(map
                .getString("primaryContactTitle", ""));
        customer.setPrimaryContactEmailAddress(map.getString(
                "primaryContactEmailAddress", ""));
        customer.setSecondaryContactFirstName(map.getString(
                "secondaryContactFirstName", ""));
        customer.setSecondaryContactLastName(map.getString(
                "secondaryContactLastName", ""));
        customer.setSecondaryContactPhoneNumber(map.getString(
                "secondaryContactPhoneNumber", ""));
        customer.setSecondaryContactPhoneExtension(map.getString(
                "secondaryContactPhoneExtension", ""));
        customer.setSecondaryContactTitle(map.getString(
                "secondaryContactTitle", ""));
        customer.setSecondaryContactEmailAddress(map.getString(
                "secondaryContactEmailAddress", ""));

        updateLocations(customer);

        getSession().update(customer);

        saveActionLog("Updated billing information for customer: "
                + customer.getName());

        MessageUtilities.addConfirmationMessage(request,
                "The billing information for" + "customer '"
                        + customer.getName() + "' has been updated.");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("id", "" + customer.getId());
        return redirect;
    }

    /**
     * @param customer
     */
    private void updateLocations(Customer customer)
    {
        Collection locations = customer.getLocations();
        if (locations != null && !locations.isEmpty()) {
            Iterator iter = locations.iterator();
            while (iter.hasNext()) {
                Location location = (Location) iter.next();
                if (location.isBlanketPO()) {
                    location.setPo(customer.getBlanketPO());
                }
                if (location.isUseCustomerAddress()) {
                    location.setAddress1(customer.getAddress1());
                    location.setAddress2(customer.getAddress2());
                    location.setAddress3(customer.getAddress3());
                    location.setCity(customer.getCity());
                    location.setState(customer.getState());
                    location.setZip(customer.getZip());
                }
                if (location.isUseCustomerContact()) {
                    location.setContactFirstName(customer
                            .getPrimaryContactFirstName());
                    location.setContactLastName(customer
                            .getPrimaryContactLastName());
                    location.setContactTitle(customer.getPrimaryContactTitle());
                    location.setContactPhoneNumber(customer
                            .getPrimaryContactPhoneNumber());
                    location.setContactEmailAddress(customer
                            .getPrimaryContactEmailAddress());
                }
            }
        }
    }

}

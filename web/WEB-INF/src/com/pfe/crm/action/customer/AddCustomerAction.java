package com.pfe.crm.action.customer;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Office;
import com.pfe.crm.domain.type.CustomerStatus;

/**
 * AddCustomerAction.java
 * 
 * Add a customer (contact information).
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 12, 2006
 */
public class AddCustomerAction extends BaseAction
{

    /**
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        RequestParameterMap map = getMap();
        Customer customer = initCustomer(map);

        Session session = getSession();

        Query query = session
                .createQuery("from Customer where name = :customer_name");
        query.setString("customer_name", customer.getName());
        Collection customers = query.list();
        if (customers != null && !customers.isEmpty()) {
            StringBuffer strCustomers = null;
            Iterator iter = customers.iterator();
            while (iter.hasNext()) {
                if (strCustomers == null) {
                    strCustomers = new StringBuffer();
                } else {
                    strCustomers.append(", ");
                }
                strCustomers.append(((Customer) iter.next()).getName());
            }

            MessageUtilities
                    .addErrorMessage(
                            request,
                            "Sorry.  There is already a customer with that name ("
                                    + strCustomers
                                    + ").  Please click the back button to try again. ");
            ActionRedirect redirect = new ActionRedirect(mapping
                    .findForward("Duplicate"));
            return redirect;
        }

        Office office = (Office) session.get(Office.class, new Integer(map
                .getInt("officeId")));
        office.addCustomer(customer);

        session.save(office);
        session.save(customer);
        saveActionLog("Added customer with name: " + customer.getName());

        MessageUtilities.addConfirmationMessage(request, "The customer '"
                + customer.getName() + "' has been successfully added.");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("id", "" + customer.getId());
        return redirect;
    }

    /**
     * @param map
     * @return
     */
    private Customer initCustomer(RequestParameterMap map)
    {
        Customer customer = new Customer();
        customer.setName(map.getString("name"));
        customer.setAddress1(map.getString("address1"));
        customer.setAddress2(map.getString("address2", ""));
        customer.setAddress3(map.getString("address3", ""));
        customer.setCity(map.getString("city"));
        customer.setState(map.getString("state"));
        customer.setZip(map.getString("zip"));
        customer.setBlanketPO(map.getString("blanketPO", ""));
        customer.setFaxNumber(map.getString("faxNumber", ""));
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
        CustomerStatus cs = CustomerStatus.getInstance(map.getInt("status"));
        customer.setStatus(cs);
        return customer;
    }
}

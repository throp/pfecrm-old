package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.business.customer.ServiceManager;
import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.InventoryItem;
import com.pfe.crm.domain.entity.Service;

/**
 * DeleteFireExtinguisherAction.java
 * 
 * Delete a fire extinguisher given the id.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 21, 2006
 */
public class DeleteFireExtinguisherAction extends BaseAction
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
        int inventoryItemId = map.getInt("inventoryItemId");
        int locationId = map.getInt("locationId");
        Session session = getSession();
        InventoryItem fireExtinguisher = null;

        fireExtinguisher = (InventoryItem) session.load(InventoryItem.class,
                new Integer(inventoryItemId));
        Service service = fireExtinguisher.getService();
        session.delete(fireExtinguisher);

        ServiceManager serviceManager = new ServiceManager(service, session);
        serviceManager.updateNumberInventoryItems();

        saveActionLog("Deleted fire extinguisher for location: "
                + service.getLocation().getName());

        MessageUtilities.addConfirmationMessage(request,
                "The fire extinguisher has been deleted.");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("serviceId", service.getId() + "");
        return redirect;
    }

}
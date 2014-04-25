/*
 * Copyright (c) 2007 Vocollect, Inc.
 * Pittsburgh, PA 15235
 * All rights reserved.
 *
 * This source code contains confidential information that is owned by
 * Vocollect, Inc. and may not be copied, disclosed or otherwise used without
 * the express written consent of Vocollect, Inc.
 */

package com.pfe.crm.action.customer;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.dao.customer.ServiceDAO;
import com.pfe.crm.domain.entity.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

/**
 * Delete a service and everything underneath it.
 * 
 * @author bnorthrop
 */
public class DeleteServiceAction extends BaseAction
{

    /**
     * {@inheritDoc}
     * 
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        Integer serviceId = getMap().getInt("serviceId");
        ServiceDAO serviceDAO = new ServiceDAO(getSession());
        Service service = serviceDAO.get(serviceId);
        int locationId = service.getLocation().getId();
        serviceDAO.delete(service);
        saveActionLog("Deleted service: " + service.getServiceType().getName());

        MessageUtilities.addConfirmationMessage(request, "'"
                + service.getServiceType().getName()
                + "' service has been deleted.");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("locationId", locationId + "");
        return redirect;
    }

}

package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Service;

/**
 * GoToEditFireExtinguisherAction.java
 * 
 * Go to the edit for the fire extinguisher.
 * 
 * @author Ben Northrop Jan 6, 2007
 * 
 */
public class ViewFireExtinguisherAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        int fireExtinguisherId = getMap().getInt("fireExtinguisherId");
        FireExtinguisher fireExtinguisher = (FireExtinguisher) getSession()
                .get(FireExtinguisher.class, new Integer(fireExtinguisherId));
        Service service = fireExtinguisher.getService();
        Location location = service.getLocation();
        Customer customer = location.getCustomer();
        customer.getName();
        
        request.setAttribute("fireExtinguisher", fireExtinguisher);
        request.setAttribute("service", service);
        request.setAttribute("location", location);
        request.setAttribute("customer", customer);
        
        return mapping.findForward("Success");
    }

}

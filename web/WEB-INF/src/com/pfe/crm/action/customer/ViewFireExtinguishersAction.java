package com.pfe.crm.action.customer;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.dao.customer.FireExtinguisherDAO;
import com.pfe.crm.dao.customer.ServiceDAO;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.InventoryItem;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Service;

/**
 * ViewFireExtinguishersAction.java
 * 
 * View all the fire extinguishers for a given service.
 * 
 * @author Ben Northrop Jan 2, 2007
 * 
 */
public class ViewFireExtinguishersAction extends BaseAction
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
        int serviceId = getMap().getInt("serviceId");
        String isAdd = getMap().getString("isAdd", "");
        String sortBy = getMap().getString("sortBy", "");
        Session session = getSession();
        ServiceDAO serviceDAO = new ServiceDAO(session);
        FireExtinguisherDAO feDAO = new FireExtinguisherDAO(session);

        Service service = serviceDAO.get(serviceId);
        if (service == null) {
            throw new IllegalStateException("Service empty for id: "
                    + serviceId);
        }

        Location location = service.getLocation();
        Customer customer = location.getCustomer();
        customer.getName();
        Collection<FireExtinguisher> items = feDAO
                .retrieveFireExtinguishersForService(service, sortBy);
        Collection fireExtinguishers = new ArrayList<InventoryItem>(items);
        request.setAttribute("customer", customer);
        request.setAttribute("location", location);
        request.setAttribute("fireExtinguishers", fireExtinguishers);
        request.setAttribute("service", service);
        request.setAttribute("isAdd", isAdd);

        return mapping.findForward("Success");
    }

}

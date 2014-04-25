package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Office;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.type.ServiceType;

/**
 * ViewServiceAction
 * 
 * Redirect to view a given service.
 * 
 * @author Ben Northrop
 */
public class ViewServiceAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        RequestParameterMap map = getMap();
        int serviceId = map.getInt("serviceId");
        Service service = (Service) getSession().get(Service.class, new Integer(serviceId));
        Location location = service.getLocation();
        Customer customer = location.getCustomer();
        Office office = customer.getOffice();
        String name = office.getName();
        request.setAttribute("service", service);
        request.setAttribute("location", location);
        request.setAttribute("customer", customer);
        return mapping.findForward(service.getServiceType().getName());
    }

}

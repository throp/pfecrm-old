package com.pfe.crm.action.customer;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.dao.customer.LocationDAO;
import com.pfe.crm.domain.entity.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

/**
 * ViewLocationsAction.java
 * 
 * View all locations for a given customer.
 * 
 * @author Ben Northrop May 19, 2007
 * 
 */
public class ViewLocationsAction extends BaseAction
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
        RequestParameterMap map = getMap();
        int customerId = map.getInt("id");
        String name = map.getString("name", "");
        String address1 = map.getString("address1", "");

        Session session = getSession();

        Customer customer = (Customer) session.load(Customer.class,
                new Integer(customerId));
        customer.getName();
        LocationDAO locationDAO = new LocationDAO(session);
        List locations = locationDAO.retrieveLocations(customerId, name,
                address1);
        request.getSession().setAttribute("customer", customer);

        request.setAttribute("ndg.report", new ArrayList(locations));
        request.setAttribute("reportParameters", map);
        return mapping.findForward("Success");
    }

}

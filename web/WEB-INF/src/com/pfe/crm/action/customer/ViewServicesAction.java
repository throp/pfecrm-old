package com.pfe.crm.action.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Location;

/**
 * ViewServicesAction.java
 * 
 * View all the services for a given location.
 * 
 * @author Ben Northrop Dec 6, 2006
 * 
 */
public class ViewServicesAction extends BaseAction
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
        int locationId = getMap().getInt("locationId");
        Session session = getSession();
        Location location = (Location) session.get(Location.class,
                new Integer(locationId));
        Customer customer = location.getCustomer();
        customer.getOffice();
        String hql = " from Service s where s.location.id = :locationId ";
        Query query = session.createQuery(hql);
        query.setInteger("locationId", locationId);
        List services = query.list();
        request.setAttribute("services", services);
        request.setAttribute("location", location);
        request.setAttribute("customer", customer);
        request.getSession().setAttribute("customer", customer);
        return mapping.findForward("Success");
    }

}

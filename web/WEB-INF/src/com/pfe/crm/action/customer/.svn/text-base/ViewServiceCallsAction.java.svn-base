package com.pfe.crm.action.customer;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Location;

/**
 * GoToServiceCallsAction.java
 * 
 * Go to the service calls screen.
 * 
 * @author Ben Northrop
 * Oct 26, 2006
 *
 */
public class ViewServiceCallsAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        RequestParameterMap map = getMap();
        Session session = getSession();
        
        int locationId = map.getInt("locationId");
        Location location = (Location) session.get(Location.class, new Integer(locationId));
        Query query = session.createQuery("from Service where location = :location ");
        query.setParameter("location", location);
        Collection services = query.list();
        request.setAttribute("location", location);
        request.setAttribute("services", services);
        return mapping.findForward("Success");
    }

}

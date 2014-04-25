package com.pfe.crm.action.customer;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Job;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.entity.ServiceCall;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.Year;

/**
 * AddServiceCallAction.java
 * 
 * Add a service call to a location.
 * 
 * @author Ben Northrop Oct 26, 2006
 * 
 */
public class AddServiceCallAction extends BaseAction
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
        int serviceId = map.getInt("serviceId");
        String note = map.getString("note");
        Session session = getSession();
        Service service = (Service) session.get(Service.class, new Integer(
                serviceId));
        Location location = service.getLocation();
        ServiceCall serviceCall = new ServiceCall();
        serviceCall.setNotes(note);
        serviceCall.setDatePlaced(new Date());
        Employee employee = getEmployee();
        serviceCall.setEmployee(employee);
        service.addServiceCall(serviceCall);
        session.save(serviceCall);
        
        Job job = new Job(Month.thisMonth(), Year.thisYear(), service);
        job.setServiceCall(serviceCall);
        session.save(job);
        
        MessageUtilities.addConfirmationMessage(request,
                "The service call for location '" + location.getName()
                        + "' has been successfully added.");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("locationId", "" + location.getId());
        return mapping.findForward("Success");
    }

}

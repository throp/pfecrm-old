package com.pfe.crm.action.customer;

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
import com.pfe.crm.domain.entity.Job;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.MonthlyFrequency;
import com.pfe.crm.domain.type.ServiceType;
import com.pfe.crm.domain.type.Year;

/**
 * AddServiceAction.java
 * 
 * Add a service to a location.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 1, 2006
 */
public class AddServiceAction extends BaseAction
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
        int locationId = map.getInt("locationId");
        ServiceType serviceType = ServiceType.getInstance(map
                .getInt("serviceTypeId"));
        Session session = getSession();

        Service service = new Service();
        service.setServiceType(serviceType);
        Month serviceMonth = Month.getInstance(map.getInt("serviceMonth"));
        MonthlyFrequency serviceFrequency = MonthlyFrequency.getInstance(map
                .getInt("serviceFrequency"));
        service.setServiceFrequency(serviceFrequency);
        service.setServiceMonth(serviceMonth);
        service.setNotes(map.getString("notes", ""));

        Location location = (Location) session.get(Location.class, new Integer(
                locationId));
        location.addService(service);
        session.save(location);
        session.save(service);

        Job job = null;
        for (Month month : serviceFrequency.getEquivalentMonths(serviceMonth)) {
            if (month.getNumber() >= Month.thisMonth().getNumber()) {
                job = new Job(month, Year.thisYear(), service);
                service.addJob(job);
                session.save(job);
                LOG.debug("added job: " + month + ", " + Year.thisYear());
            }
            job = new Job(month, Year.nextYear(), service);
            service.addJob(job);
            session.save(job);
            LOG.debug("added job: " + month + ", " + Year.nextYear());
        }

        saveActionLog("Added service (" + service.getServiceType().getName()
                + ") for location: " + location.getName());

        MessageUtilities.addConfirmationMessage(request,
                "Added Fire Extinguisher service to location '"
                        + location.getName() + "' successfully.");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("locationId", "" + locationId);
        return redirect;
    }

    // Add upcoming jobs
    /**
     * @param session
     * @param year
     * @param service
     */
    private void saveJob(Session session, Year year, Month month,
            Service service)
    {
        Job job = new Job();
        job.setYearDue(year);
        job.setMonthDue(month);
        service.addJob(job);
        session.save(service);
        session.save(job);
    }
}

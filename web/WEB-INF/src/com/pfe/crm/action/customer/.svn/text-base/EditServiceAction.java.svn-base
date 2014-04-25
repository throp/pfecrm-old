package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Query;
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
 * EditServiceAction.java
 * 
 * Edit the fire extinguisher service.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 2, 2006
 */
public class EditServiceAction extends BaseAction
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
        int serviceTypeId = map.getInt("serviceTypeId");
        String notes = map.getString("notes", "");
        ServiceType serviceType = ServiceType.getInstance(serviceTypeId);

        Month serviceMonth = Month.getInstance(map.getInt("serviceMonth"));
        MonthlyFrequency serviceFrequency = MonthlyFrequency.getInstance(map
                .getInt("serviceFrequency"));

        Session session = getSession();
        Service service = (Service) session.get(Service.class, new Integer(
                serviceId));
        service.setServiceFrequency(serviceFrequency);
        service.setServiceMonth(serviceMonth);
        service.setNotes(notes);
        session.save(service);

        deleteUnstartedJobs(session, service);
        addNewJobs(serviceMonth, serviceFrequency, session, service);

        saveActionLog("Updated service information ("
                + service.getServiceType().getName() + ") for location: "
                + service.getLocation().getName());

        MessageUtilities.addConfirmationMessage(request, "Updated "
                + serviceType.getName() + " service successfully");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("serviceId", "" + serviceId);
        redirect.addParameter("serviceTypeId", "" + serviceTypeId);
        return redirect;
    }

    /**
     * @param serviceMonth
     * @param serviceFrequency
     * @param session
     * @param service
     */
    private void addNewJobs(Month serviceMonth,
            MonthlyFrequency serviceFrequency, Session session, Service service)
    {
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
    }

    /**
     * @param session
     * @param service
     */
    private void deleteUnstartedJobs(Session session, Service service)
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" delete from Job j ");
        hql.append(" where j.roadTechnician = null ");
        hql.append(" and j.service = :service ");
        Query deleteQuery = session.createQuery(hql.toString());
        deleteQuery.setParameter("service", service);

        int jobsDeleted = deleteQuery.executeUpdate();
        LOG.debug(jobsDeleted + " empty jobs were deleted for service: "
                + service.getServiceType().getName() + ".");
    }
}

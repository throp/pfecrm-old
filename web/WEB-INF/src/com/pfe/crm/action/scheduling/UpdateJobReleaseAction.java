package com.pfe.crm.action.scheduling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Job;

/**
 * UpdateJobReleaseAction.java
 * 
 * Delete the job!
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 13, 2006
 */
public class UpdateJobReleaseAction extends BaseAction
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
        int jobId = getMap().getInt("jobId");
        Session session = getSession();
        Job job = (Job) session.get(Job.class, new Integer(jobId));
        Employee roadTechnician = job.getRoadTechnician();
        roadTechnician.removeRoadTechnicianJob(job);
        job.setDateInRoadTechQueue(null);
        session.save(job);

        saveActionLog("Released job: "
                + job.getService().getLocation().getName() + "->"
                + job.getService().getServiceType().getName());

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}

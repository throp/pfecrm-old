package com.pfe.crm.action.scheduling;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Job;

/**
 * UpdateJobAssignShopTechAction.java
 * 
 * Assign a shop tech!
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 13, 2006
 */
public class UpdateJobAssignShopTechAction extends BaseAction
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
        int jobId = map.getInt("jobId");
        int employeeId = map.getInt("employeeId");

        Session session = getSession();
        Job job = (Job) session.get(Job.class, new Integer(jobId));
        job.setDateInShopTechQueue(new Date());
        Employee shopTech = (Employee) session.get(Employee.class, new Integer(
                employeeId));
        shopTech.addShopTechnicianJob(job);

        saveActionLog("Assigned shop tech (" + shopTech.getName()
                + ") to job: " + job.getService().getLocation().getName()
                + "->" + job.getService().getServiceType().getName());

        return mapping.findForward("Success");
    }

}

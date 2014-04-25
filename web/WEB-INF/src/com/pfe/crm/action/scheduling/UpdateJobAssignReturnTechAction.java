package com.pfe.crm.action.scheduling;

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

/**
 * UpdateJobAssignReturnTechAction.java
 * 
 * Assign a return tech to this job.
 * 
 * @author Ben Northrop Nov 19, 2006
 * 
 */
public class UpdateJobAssignReturnTechAction extends BaseAction
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
        Employee returnTech = (Employee) session.get(Employee.class,
                new Integer(employeeId));
        Job job = (Job) session.get(Job.class, new Integer(jobId));
        job.setReturnTechnician(returnTech);
        job.setDateInReturnTechQueue(new Date());
        session.save(returnTech);

        saveActionLog("Assigned return tech (" + returnTech.getName()
                + ") to job: " + job.getService().getLocation().getName()
                + "->" + job.getService().getServiceType().getName());

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}

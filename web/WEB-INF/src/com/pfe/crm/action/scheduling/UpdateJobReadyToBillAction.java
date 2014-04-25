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
import com.pfe.crm.domain.entity.Job;

/**
 * UpdateJobReadyToBillAction.java
 * 
 * Set the job as ready to bill.
 * 
 * @author Ben Northrop Dec 2, 2006
 * 
 */
public class UpdateJobReadyToBillAction extends BaseAction
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
        int jobId = map.getInt("jobId");

        Session session = getSession();
        Job job = (Job) session.get(Job.class, new Integer(jobId));
        job.setDateCompleted(new Date());
        session.save(job);

        saveActionLog("Marked job ready to bill: "
                + job.getService().getLocation().getName() + "->"
                + job.getService().getServiceType().getName());

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}

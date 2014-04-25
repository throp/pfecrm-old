package com.pfe.crm.action.scheduling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.entity.Job;

/**
 * @author Ben Northrop
 *
 */
public class GoToBillJobAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        int jobId = getMap().getInt("jobId");
        Job job = (Job) getSession().get(Job.class, new Integer(jobId));    
        request.setAttribute("job", job);
        return mapping.findForward("Success");
    }

}

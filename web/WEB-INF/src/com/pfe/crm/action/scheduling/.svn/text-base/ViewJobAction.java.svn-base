package com.pfe.crm.action.scheduling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.entity.Job;

/**
 * ViewJobAction.java
 * 
 * View a single job and it's properties.
 * 
 * @author Ben Northrop
 * Dec 2, 2006
 *
 */
public class ViewJobAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        int jobId = getMap().getInt("jobId");        
        Session session = getSession();
        StringBuffer hql = new StringBuffer();
        hql.append(" select j ");        
        hql.append(" from Job j ");
        hql.append(" join fetch j.service s ");
        hql.append(" join fetch s.location l ");
        hql.append(" join fetch l.customer c ");
        hql.append(" join fetch j.roadTechnician rt ");
        hql.append(" left join fetch j.shopTechnician ");
        hql.append(" left join fetch j.returnTechnician ");
        hql.append(" left join fetch j.creditedTechnician ");
        hql.append(" where j.id = :jobId ");
        Query query = session.createQuery(hql.toString());
        query.setInteger("jobId", jobId);
        Job job = (Job) query.uniqueResult();
        request.setAttribute("job", job);
        return mapping.findForward("Success");
    }

}

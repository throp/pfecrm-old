package com.pfe.crm.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.type.Year;

/**
 * CalculateNumberUnstartedJobsAction.java
 * 
 * Determine how many jobs are undone for this year and next year.
 * 
 * @author Ben Northrop Dec 8, 2006
 * 
 */
public class CalculateNumberUnstartedJobsAction extends BaseAction
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
        StringBuffer hql = new StringBuffer();
        hql.append(" select count(j) ");
        hql.append(" from Job j ");
        hql.append(" where j.yearDue = :year ");
        hql.append(" and j.roadTechnician = null ");

        Query queryThisYear = getSession().createQuery(hql.toString());
        queryThisYear.setParameter("year", Year.thisYear());
        Integer thisYearNumJobs = (Integer) queryThisYear.uniqueResult();
        LOG.debug(thisYearNumJobs + " num jobs for " + Year.thisYear());

        Query queryNextYear = getSession().createQuery(hql.toString());
        queryNextYear.setParameter("year", Year.nextYear());
        Integer nextYearNumJobs = (Integer) queryNextYear.uniqueResult();
        LOG.debug(nextYearNumJobs + " num jobs for " + Year.nextYear());

        saveActionLog("Recalculated jobs for next year: " + nextYearNumJobs
                + " num jobs for " + Year.nextYear());

        request.setAttribute("thisYearNumJobs", thisYearNumJobs);
        request.setAttribute("nextYearNumJobs", nextYearNumJobs);
        request.setAttribute("thisYear", Year.thisYear());
        request.setAttribute("nextYear", Year.nextYear());
        return mapping.findForward("Success");
    }

}

package com.pfe.crm.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Job;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.Year;

/**
 * CalculateJobScheduleAction.java
 * 
 * Delete all empty jobs, then recalculate the jobs that need to be done in the
 * given year.
 * 
 * @author Ben Northrop Dec 7, 2006
 * 
 */
public class CalculateJobScheduleAction extends BaseAction
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
        Session session = getSession();
        Year year = Year.getInstance(getMap().getInt("year"));
        StringBuffer hql = new StringBuffer();
        hql.append(" delete from Job j ");
        hql.append(" where j.roadTechnician = null ");
        hql.append(" and j.yearDue = :year ");

        Query deleteQuery = session.createQuery(hql.toString());
        deleteQuery.setParameter("year", year);

        int jobsDeleted = deleteQuery.executeUpdate();
        LOG.debug(jobsDeleted + " empty jobs were deleted for year: " + year);

        Query servicesQuery = session.createQuery("select s from Service s");
        List<Service> services = (List<Service>) servicesQuery.list();
        LOG.debug(services.size() + " services to calculate jobs for.");
        // int count = 0;
        for (Service service : services) {
            for (Month month : service.getServiceFrequency()
                    .getEquivalentMonths(service.getServiceMonth())) {
                if (year.equals(Year.thisYear())) {
                    if (month.getNumber() >= Month.thisMonth().getNumber()) {
                        saveJob(session, year, month, service);
                    }
                } else if (year.getYear() > Year.thisYear().getYear()) {
                    saveJob(session, Year.nextYear(), month, service);
                } else {
                    LOG.warn("invalid year (should not be in past): " + year);
                }
            }

            session.evict(service);
            // clear objects from memory, for performance.
            // count++;
            // if (count % 10 == 0) {
            // LOG.debug("session cleared after " + count + " services");
            // session.clear();
            // }
        }

        MessageUtilities.addConfirmationMessage(request,
                "Jobs were calculated for year: " + year);
        return mapping.findForward("Success");
    }

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

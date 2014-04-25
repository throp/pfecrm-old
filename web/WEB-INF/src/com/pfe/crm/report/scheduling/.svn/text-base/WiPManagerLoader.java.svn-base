package com.pfe.crm.report.scheduling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.exception.CRMException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Job;
import com.pfe.crm.domain.type.ServiceType;

/**
 * QueueManagerLoader.java
 * 
 * Queries the queue.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 9, 2006
 */
public class WiPManagerLoader extends LoadableAdaptor
{
    // DATA MEMBERS
    private static final long serialVersionUID = 6726178506891282452L;

    private int roadTechEmployeeId;

    private int shopTechEmployeeId;

    private ServiceType serviceType;

    private int daysInProgress;

    private String jobState;

    private final static int UNDEFINED = -1;

    /**
     * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
     */
    public void init(ReportParameterMap map) throws ReportValidationException
    {
        roadTechEmployeeId = map.getInt("roadTechEmployeeId", UNDEFINED);
        shopTechEmployeeId = map.getInt("shopTechEmployeeId", UNDEFINED);

        int serviceTypeId = map.getInt("serviceTypeId", UNDEFINED);
        if (serviceTypeId != UNDEFINED) {
            serviceType = ServiceType.getInstance(serviceTypeId);
        } else {
            serviceType = null;
        }

        daysInProgress = map.getInt("daysInProgress", UNDEFINED);

        jobState = map.getString("jobState", "");
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadBody()
     */
    public ArrayList loadBody() throws ReportException
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" select j ");
        hql.append(" from Job j ");
        hql.append(" join fetch j.service s ");
        hql.append(" join fetch s.location l ");
        hql.append(" join fetch l.customer c ");
        hql.append(" join fetch j.roadTechnician rt ");
        hql.append(" left join fetch j.shopTechnician st ");
        hql.append(" left join fetch j.returnTechnician ret ");
        hql.append(" where j.dateInRoadTechQueue != null ");
        hql.append(" and j.dateCompleted = null ");
        hql
                .append(" and (j.dateReadyForReturn = null or j.returnTechnician != null) ");
        if (roadTechEmployeeId != UNDEFINED) {
            hql.append(" and (rt.id = :roadTechEmployeeId ");
            hql.append(" or ret.id = :returnTechEmployeeId) ");
        }
        if (shopTechEmployeeId != UNDEFINED) {
            hql.append(" and st.id = :shopTechEmployeeId ");
        }
        if (serviceType != null) {
            hql.append(" and j.service.serviceType = :serviceType ");
        }

        Session session = HibernateUtilities.getSession();
        Query query = session.createQuery(hql.toString());
        if (roadTechEmployeeId != UNDEFINED) {
            query.setInteger("roadTechEmployeeId", roadTechEmployeeId);
            query.setInteger("returnTechEmployeeId", roadTechEmployeeId);
        }
        if (shopTechEmployeeId != UNDEFINED) {
            query.setInteger("shopTechEmployeeId", shopTechEmployeeId);
        }
        if (serviceType != null) {
            query.setParameter("serviceType", serviceType);
        }

        ArrayList<Job> jobs = new ArrayList<Job>((ArrayList<Job>) query.list());

        jobs = filterByDaysInProgress(jobs);
        jobs = filterByRoadTech(jobs);
        jobs = filterByShopTech(jobs);
        jobs = filterByJobState(jobs);

        return jobs;
    }

    /**
     * Filter by days in progress.
     */
    private ArrayList<Job> filterByDaysInProgress(ArrayList<Job> jobs)
    {
        if (daysInProgress != UNDEFINED) {
            ArrayList<Job> filteredJobs = new ArrayList<Job>();
            for (Job job : jobs) {
                if (daysInProgress != UNDEFINED
                        && job.getDaysInProgress() >= daysInProgress) {
                    filteredJobs.add(job);
                }
            }
            return filteredJobs;
        }
        return jobs;
    }

    /**
     * Filter by road tech.
     */
    private ArrayList<Job> filterByRoadTech(ArrayList<Job> jobs)
    {
        if (roadTechEmployeeId != UNDEFINED) {

            ArrayList<Job> filteredJobs = new ArrayList<Job>();
            for (Job job : jobs) {
                if (job.getIsBeingReturned()
                        && job.getReturnTechnician().getId() == roadTechEmployeeId) {
                    filteredJobs.add(job);
                } else if (job.getIsBeingServiced()
                        && job.getRoadTechnician().getId() == roadTechEmployeeId) {
                    filteredJobs.add(job);
                }
            }
            return filteredJobs;
        }
        return jobs;
    }

    /**
     * Filter by days shop tech.
     */
    private ArrayList<Job> filterByShopTech(ArrayList<Job> jobs)
    {
        if (shopTechEmployeeId != UNDEFINED) {

            ArrayList<Job> filteredJobs = new ArrayList<Job>();
            for (Job job : jobs) {
                if (shopTechEmployeeId != UNDEFINED) {
                    if (job.getIsInShop()
                            && job.getShopTechnician().getId() == shopTechEmployeeId) {
                        filteredJobs.add(job);
                    }
                }
            }
            return filteredJobs;
        }
        return jobs;
    }

    /**
     * Filter by job state.
     */
    private ArrayList<Job> filterByJobState(ArrayList<Job> jobs)
    {
        if (!"".equals(jobState)) {

            ArrayList<Job> filteredJobs = new ArrayList<Job>();
            for (Job job : jobs) {
                if ("beingServiced".equals(jobState)
                        && job.getIsBeingServiced()) {
                    filteredJobs.add(job);
                } else if ("beingReturned".equals(jobState)
                        && job.getIsBeingReturned()) {
                    filteredJobs.add(job);
                } else if ("inShop".equals(jobState) && job.getIsInShop()) {
                    filteredJobs.add(job);
                }
            }
            return filteredJobs;
        }
        return jobs;
    }
}

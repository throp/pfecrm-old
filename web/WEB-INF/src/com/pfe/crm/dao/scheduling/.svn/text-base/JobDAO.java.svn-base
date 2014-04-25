package com.pfe.crm.dao.scheduling;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Job;

/**
 * JobDAO.java
 * 
 * All data access logic regarding Jobs.
 * 
 * @author Ben Northrop Jun 4, 2007
 * 
 */
public class JobDAO extends BaseDAO<Job>
{
    /**
     * Default constructor.
     */
    public JobDAO(Session session)
    {
        super(session);
    }

    /**
     * Return a list of all jobs that an employee is related to, in any way.
     */
    public Collection<Job> retrieveJobsForEmployee(Employee employee)
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" from Job j ");
        hql.append(" where (j.shopTechnician = :employee ");
        hql.append(" or j.roadTechnician = :employee ");
        hql.append(" or j.creditedTechnician = :employee ");
        hql.append(" or j.returnTechnician = :employee )");

        Query query = getSession().createQuery(hql.toString());
        query.setParameter("employee", employee);
        Collection<Job> jobs = query.list();
        return jobs;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Job.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Job";
    }

}

package com.pfe.crm.report.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.pfe.crm.core.util.HibernateUtilities;

/**
 * InvoiceManagerLoader.java
 * 
 * A report to show all the jobs billed.
 * 
 * @author Ben Northrop Nov 24, 2006
 * 
 */
public class InvoiceManagerLoader extends LoadableAdaptor
{

    /**
     * @see com.ndg.report.LoadableAdaptor#loadBody()
     */
    @Override
    public ArrayList loadBody() throws ReportException
    {
        Session session = HibernateUtilities.getSession();
        StringBuffer hql = new StringBuffer();
        hql.append(" select j ");
        hql.append(" from Job j ");
        hql.append(" left join fetch j.service s ");
        hql.append(" left join fetch s.location l ");
        hql.append(" left join fetch l.customer c ");
        hql.append(" where j.dateCompleted != null ");
        hql.append(" and j.dateBilled = null ");
        Query query = session.createQuery(hql.toString());

        List jobs = query.list();
        return new ArrayList(jobs);
    }

}

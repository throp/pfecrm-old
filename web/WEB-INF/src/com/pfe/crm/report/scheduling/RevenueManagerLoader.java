package com.pfe.crm.report.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.type.ServiceType;

/**
 * RevenueManagerLoader.java
 * 
 * Shows the revenue for different services.
 * 
 * @author Ben Northrop
 * Nov 30, 2006
 *
 */
public class RevenueManagerLoader extends LoadableAdaptor
{
    
    // DATA MEMBERS
    private ServiceType serviceType = null;
    
    /**
     * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
     */
    @Override
    public void init(ReportParameterMap map) throws ReportValidationException
    {
        int serviceTypeId = map.getInt("serviceTypeId", 0);
        if(serviceTypeId > 0) { 
            serviceType = ServiceType.getInstance(serviceTypeId);
        }
        else { 
            serviceType = null;
        }
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadHeader()
     */
    @Override
    public Object loadHeader() throws ReportException
    {
        Session session = HibernateUtilities.getSession();
        StringBuffer hql = new StringBuffer();
        hql.append(" select sum(j.invoiceAmount) ");
        hql.append(" from Job j ");
        hql.append(" where j.dateBilled != null ");
        if(serviceType != null) { 
            hql.append(" and j.service.serviceType = :serviceType ");
        }
        Query query = session.createQuery(hql.toString());
        if(serviceType != null) { 
            query.setParameter("serviceType", serviceType);
        }
        Float total = (Float) query.uniqueResult();
        return total;
    }

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
        hql.append(" left join fetch j.creditedTechnician ct ");
        hql.append(" where j.dateBilled != null ");
        if(serviceType != null) { 
            hql.append(" and j.service.serviceType = :serviceType ");
        }        
        Query query = session.createQuery(hql.toString());
        if(serviceType != null) { 
            query.setParameter("serviceType", serviceType);
        }        
        List jobs = query.list();
        return new ArrayList(jobs);
    }
}

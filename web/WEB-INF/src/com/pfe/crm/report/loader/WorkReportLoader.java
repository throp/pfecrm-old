package com.pfe.crm.report.loader;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.type.Month;

/**
 * WorkReportLoader.java
 * 
 * 
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Jul 13, 2006
 */
public class WorkReportLoader extends LoadableAdaptor
{
	// DATA MEMBERS
	private static final long serialVersionUID = 235488709111606565L;
	private transient Category LOG = Category.getInstance(WorkReportLoader.class);	
	private Month serviceMonth = null;
	
	/**
	 * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
	 */
	public void init(ReportParameterMap map) throws ReportValidationException
	{
		LOG = Category.getInstance(WorkReportLoader.class);
		int monthNum = map.getInt("serviceMonth", 0);
		if(monthNum != 0) { 
			serviceMonth = Month.getInstance(monthNum);
		} else { 
			serviceMonth = null;
		}
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadBody()
	 */
	public ArrayList loadBody() throws ReportException
	{		
		Session session = null; 
		List locations = null;
		
		try {
			session = HibernateUtilities.getSession();
			String hql = "select l from Location l left join fetch l.customer ";
			if(serviceMonth != null) { 
				System.out.println("serviceMonth: " + serviceMonth + " " + hql);
				hql += " where l.serviceMonth = :serviceMonth ";
			}
			Query query = session.createQuery(hql);
			if(serviceMonth != null) {
				query.setParameter("serviceMonth", serviceMonth);
			}
			locations = query.list();
		} 
		finally {
			HibernateUtilities.closeSession(session);
		}	
		LOG.debug("Returning " + locations.size() + " locations");
		return new ArrayList(locations);
	}
}

package com.pfe.crm.report.customer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.core.util.StringUtilities;
import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Customer;

/**
 * LocationLoader.java
 * 
 * Load all locations
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 27, 2006
 */
public class LocationLoader extends LoadableAdaptor
{
	// DATA MEMBERS
	private static final long serialVersionUID = 235488709111606565L;

	private transient Category LOG = Category.getInstance(LocationLoader.class);

	private int customerId;

	private String name;

	private String address1;

	/**
	 * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
	 */
	public void init(ReportParameterMap map) throws ReportValidationException
	{
		LOG = Category.getInstance(CustomerLoader.class);
		LOG.debug("init() map: " + map);
		customerId = map.getInt("id");
		name = map.getString("name");
		address1 = map.getString("address1"); 
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadHeader()
	 */
	public Object loadHeader() throws ReportException
	{
		Session session = null;

		try {
			session = HibernateUtilities.getSession();
			return (Customer) session.load(Customer.class, new Integer(customerId));

		} finally {
			HibernateUtilities.closeSession(session);
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
			StringBuffer hql = new StringBuffer();
			hql.append("from Location l where l.customer = :customerId");
			if (!StringUtilities.isEmpty(name)) {
				hql.append(" and l.name LIKE :name");
			}
			if (!StringUtilities.isEmpty(address1)) {
				hql.append(" and l.address1 like :address1");
			}			
			Query query = session.createQuery(hql.toString());
			query.setInteger("customerId", customerId);
			if (!StringUtilities.isEmpty(name)) {
				query.setString("name", "%" + name + "%");
			}
			if (!StringUtilities.isEmpty(address1)) {
				query.setString("address1", "%" + address1 + "%");
			}			
			locations = query.list();
		} finally {
			HibernateUtilities.closeSession(session);
		}
		LOG.debug("Returning " + locations.size() + " locations");
		return new ArrayList(locations);
	}

}

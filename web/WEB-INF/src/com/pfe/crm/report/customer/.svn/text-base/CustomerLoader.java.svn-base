package com.pfe.crm.report.customer;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.type.CustomerStatus;

/**
 * CustomerLoader.java
 * 
 * Load all customers from the database.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 26, 2006
 */
public class CustomerLoader extends LoadableAdaptor
{
	// DATA MEMBERS
	private transient Category LOG = Category.getInstance(CustomerLoader.class);

	private static final long serialVersionUID = 1L;

	private String customerName;

	private String customerAddress;

	private CustomerStatus status;

	private String locationName;

	private String locationAddress;
    
    private String customerZip;
    
    private int officeId;


	// METHODS
	/**
	 * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
	 */
	public void init(ReportParameterMap map) throws ReportValidationException
	{
		LOG = Category.getInstance(CustomerLoader.class);
		LOG.debug("ReportParameterMap: " + map);
		customerName = map.getString("customerName");
		customerAddress = map.getString("customerAddress");
        customerZip = map.getString("customerZip");
		locationName = map.getString("locationName");
		locationAddress = map.getString("locationAddress");
        officeId = map.getInt("officeId", 0);
		int statusId = map.getInt("status", 0);
		if (statusId == 0) {
			status = null;
		} else {
			status = CustomerStatus.getInstance(statusId);
		}
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadBody()
	 */
	public ArrayList loadBody() throws ReportException
	{
		LOG.debug("ReportParameterMap.loadBody() ");
		Session session = null;
		List customers = null;

		try {
			session = HibernateUtilities.getSession();
			StringBuffer hql = new StringBuffer();
			if (!StringUtilities.isEmpty(locationName) || !StringUtilities.isEmpty(locationAddress)) {
				hql.append(" select l ");
			} else {
				hql.append(" select c");
			}
			hql.append(" from Customer c ");
			if (!StringUtilities.isEmpty(locationName) || !StringUtilities.isEmpty(locationAddress)) {
				hql.append(" join c.locations l ");
			}
			hql.append(" where 1 = 1 ");
			if (!StringUtilities.isEmpty(customerName)) {
				hql.append(" and c.name LIKE :customerName");
			}
			if (!StringUtilities.isEmpty(customerAddress)) {
				hql.append(" and c.address1 like :customerAddress");
			}
            if(!StringUtilities.isEmpty(customerZip)) { 
                hql.append(" and c.zip like :customerZip");
            }
			if (!StringUtilities.isEmpty(locationName)) {
				hql.append(" and l.name LIKE :locationName");
			}
			if (!StringUtilities.isEmpty(locationAddress)) {
				hql.append(" and l.address1 like :locationAddress");
			}
			if (status != null) {
				hql.append(" and c.status = :status ");
			}
			hql.append(" order by c.name ");
			Query query = session.createQuery(hql.toString());

			if (!StringUtilities.isEmpty(customerName)) {
				query.setString("customerName", "%" + customerName + "%");
			}
			if (!StringUtilities.isEmpty(customerAddress)) {
				query.setString("customerAddress", "%" + customerAddress + "%");
			}
            if(!StringUtilities.isEmpty(customerZip)) { 
                query.setString("customerZip", customerZip);
            }
			if (!StringUtilities.isEmpty(locationName)) {
				query.setString("locationName", "%" + locationName + "%");
			}
			if (!StringUtilities.isEmpty(locationAddress)) {
				query.setString("locationAddress", "%" + locationAddress + "%");
			}
			if (status != null) {
				query.setParameter("status", status);
			}
			customers = query.list();
			LOG.debug("customers: " + customers.size());
			if (!StringUtilities.isEmpty(locationName) || !StringUtilities.isEmpty(locationAddress)) {
				Iterator iter = customers.iterator();
				while (iter.hasNext()) {
					Location location = (Location) iter.next();
					Customer customer = location.getCustomer();
					customer.getName();
				}
			}
		} finally {
			HibernateUtilities.closeSession(session);
		}
		return new ArrayList(customers);
	}

}

package com.pfe.crm.report.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.type.ServiceType;

/**
 * FireExtinguisherLoader.java
 * 
 * Load all fire extinguishers for a location.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 3, 2006
 */
public class FireExtinguisherLoader extends LoadableAdaptor
{

	// DATA MEMBERS
	private Location location;
    
    private Service service;

	private ArrayList fireExtinguishers;

	private static final long serialVersionUID = 218681856720145333L;

	// METHODS
	/**
	 * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
	 */
	public void init(ReportParameterMap map) throws ReportValidationException
	{
		int serviceId = map.getInt("serviceId");
		Session session = null;
		location = null;

		try {
			session = HibernateUtilities.getSession();
			service = (Service) session.get(Service.class, new Integer(serviceId));
			if (service == null) {
				throw new IllegalStateException("Service empty for id: " + serviceId);
			}

			location = service.getLocation();
			Customer customer = location.getCustomer();
            customer.getName();
			Collection items = service.getInventoryItems();
			if (items == null) {
				fireExtinguishers = null;
			} else {
				fireExtinguishers = new ArrayList(items);
			}
		} finally {
			HibernateUtilities.closeSession(session);
		}
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadHeader()
	 */
	public Object loadHeader() throws ReportException
	{
		return service;
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadBody()
	 */
	public ArrayList loadBody() throws ReportException
	{
		return fireExtinguishers;
	}

}

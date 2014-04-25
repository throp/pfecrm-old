package com.pfe.crm.report.customer;

import java.util.ArrayList;

import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Customer;

/**
 * CustomerNotesLoader.java
 * 
 * Loads the customer notes to be displayed in a report.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 31, 2006
 */
public class CustomerNotesLoader extends LoadableAdaptor
{
	// DATA MEMBERS
	private static final long serialVersionUID = 2642616502708119364L;

	private int customerId;

	// METHODS
	/**
	 * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
	 */
	public void init(ReportParameterMap map) throws ReportValidationException
	{
		customerId = map.getInt("id");
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadBody()
	 */
	public ArrayList loadBody() throws ReportException
	{
		Session session = null;

		try {
			session = HibernateUtilities.getSession();
			Customer customer = (Customer) session.get(Customer.class, new Integer(customerId));
			return new ArrayList(customer.getNotes());
		} finally {
			HibernateUtilities.closeSession(session);
		}
	}

}

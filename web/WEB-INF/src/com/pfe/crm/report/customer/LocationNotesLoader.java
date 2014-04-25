package com.pfe.crm.report.customer;

import java.util.ArrayList;

import org.hibernate.Session;

import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Location;

/**
 * LocationNotesLoader.java
 * 
 * Load all the location notes given a locationId.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 11, 2006
 */
public class LocationNotesLoader extends LoadableAdaptor
{
	// DATA MEMBERS
	private int locationId;

	ArrayList locationNotes = new ArrayList();

	private static final long serialVersionUID = 1L;

	// METHODS
	/**
	 * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
	 */
	public void init(ReportParameterMap map) throws ReportValidationException
	{
		locationId = map.getInt("locationId");
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadHeader()
	 */
	public Object loadHeader() throws ReportException
	{
		Location location = null;
		Session session = null;
		try {
			session = HibernateUtilities.getSession();
			location = (Location) session.get(Location.class, new Integer(locationId));
			if (location == null) {
				throw new IllegalStateException("Location empty for id: " + locationId);
			}

		} finally {
			HibernateUtilities.closeSession(session);
		}
		return location;
	}

	/**
	 * @see com.ndg.report.LoadableAdaptor#loadBody()
	 */
	public ArrayList loadBody() throws ReportException
	{
		Session session = null;

		try {
			session = HibernateUtilities.getSession();
			Location location = (Location) session.get(Location.class, new Integer(locationId));
			return new ArrayList(location.getNotes());
		} finally {
			HibernateUtilities.closeSession(session);
		}
	}

}

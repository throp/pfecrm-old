package com.pfe.crm.core.web;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.type.CustomerStatus;
import com.pfe.crm.domain.type.EmployeeType;
import com.pfe.crm.domain.type.FireExtinguisherServiceType;
import com.pfe.crm.domain.type.FireExtinguisherTestType;
import com.pfe.crm.domain.type.Floor;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.MonthlyFrequency;
import com.pfe.crm.domain.type.ServiceType;
import com.pfe.crm.domain.type.Year;

/**
 * ListManager.java
 * 
 * A singleton that manages all lists of "type table" data that is stored in the
 * context and available in the presentation tier.
 * 
 * Rather than create a generic component for handling list data, it was decided
 * to create a class that knows intimately what data needs to be stored in the
 * context for this application - a reusable component would probably serve no
 * benefit and would complicate the design.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 7, 2006
 */
public class ListManager
{
	// DATA MEMBERS
	private static ListManager instance;

	private ServletContext context;

	private static Category LOG = Category.getInstance(ListManager.class);

	// CONSTRUCTOR
	private ListManager(ServletContext context)
	{
		LOG.debug(">ListManager()");
		this.context = context;
	}

	// FACTORY METHOD
	/**
	 * Create the instance of this ListManager.
	 */
	public synchronized static ListManager init(ServletContext context)
	{
		if (instance == null) {
			instance = new ListManager(context);
		}
		else { 
			LOG.info("ListManager is being re-initialized.");
		}
		return instance;
	}
	
	/**
	 * Get an instance of the ListManager, if there is one.
	 */
	public static ListManager getInstance()
	{
		if(instance == null) { 
			throw new IllegalStateException("ListManager has not been initialized");
		}
		return instance;
	}

	// METHODS
	/**
	 * Retrieve the lists, and store them in the context.
	 */
	public void refreshAllLists()
	{
		LOG.debug(">refreshAllLists()");

		context.setAttribute("months", Month.list());
		LOG.debug("  months: " + Month.list());

		context.setAttribute("monthlyFrequencies", MonthlyFrequency.list());
		LOG.debug("  monthlyFrequencies: " + MonthlyFrequency.list());

		context.setAttribute("employeeTypes", EmployeeType.list());
		LOG.debug("  employeeTypes: " + EmployeeType.list());

		context.setAttribute("customerStatuses", CustomerStatus.list());
		LOG.debug("  customerStatuses: " + CustomerStatus.list());
		
		context.setAttribute("years", Year.list());
		LOG.debug("  years: " + Year.list());
		
		context.setAttribute("floors", Floor.list());
		LOG.debug("  floors: " + Floor.list());
		
		context.setAttribute("fireExtinguisherServiceTypes", FireExtinguisherServiceType.list());
		LOG.debug("  fireExtinguisherServiceTypes: " + FireExtinguisherServiceType.list());
		
        context.setAttribute("serviceTypes", ServiceType.list());
        LOG.debug("  serviceTypes: " + ServiceType.list());
        
        context.setAttribute("fireExtinguisherTestTypes", FireExtinguisherTestType.list());
        LOG.debug("  fireExtinguisherTestTypes" + FireExtinguisherTestType.list());
        
		refreshManufacturers();
		refreshEmployees();
		refreshChemicals();
		refreshWeights();
		refreshOffices();
	}

	/**
	 * Retrieve all manufacturers and store in the context.
	 */
	public void refreshManufacturers()
	{
		refreshList("Manufacturer", "manufacturers", "name");
	}
	
	/**
	 * Retrieve all employees and store in the context.
	 */
	public void refreshEmployees()
	{
		refreshList("Employee", "employees", "lastName");
	}
	
	/**
	 * Retrieve all chemicals and store in the context.
	 */
	public void refreshChemicals()
	{
		refreshList("Chemical", "chemicals", "name");
	}
	
	/**
	 * Retrieve all weights and 
	 */
	public void refreshWeights()
	{
		refreshList("Weight", "weights", "pounds");
	}
	
	/**
	 * Retrieve all weights and 
	 */
	public void refreshOffices()
	{
		refreshList("Office", "offices", "name");
	}
	
	/**
	 * Refresh a list of data
	 */
	private void refreshList(String entityName, String entityKey, String orderBy)
	{
		Session session = null;
		List list = null;

		try {
			session = HibernateUtilities.getSession();
			Query query = session.createQuery("from " + entityName + " where isActive = :active order by " + orderBy);
            query.setBoolean("active", true);
			list = query.list();
		} finally {
			HibernateUtilities.closeSession(session);
		}
		context.setAttribute(entityKey, list);
		LOG.debug("  refreshed " + entityKey + ": " + list);
	}
}

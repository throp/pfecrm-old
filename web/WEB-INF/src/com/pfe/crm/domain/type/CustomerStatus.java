package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * CustomerStatus.java
 * 
 * A typesafe enum representing the customer's status.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jul 24, 2006
 */
public class CustomerStatus implements Serializable
{

	// DATA MEMBERS
	private int id;

	private String description;

	private static final long serialVersionUID = -6881898555903973750L;

	// ACCESSORS
	/**
	 * @return Returns the description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return id;
	}

	// CONSTRUCTOR
	/**
	 * Private constructor typesafe enum
	 */
	private CustomerStatus(int id, String description)
	{
		this.id = id;
		this.description = description;
	}

	// TYPES
	public static CustomerStatus CURRENT = new CustomerStatus(1, "Current");

	public static CustomerStatus PROSPECT = new CustomerStatus(2, "Prospect");

	public static CustomerStatus TERMINATED = new CustomerStatus(3, "Terminated");

	public static CustomerStatus RE_AQUIRE = new CustomerStatus(4, "Re-aquire");

	public static List<CustomerStatus> list;

	// METHODS
	/**
	 * Generate a list of
	 */
	public static List<CustomerStatus> list()
	{
		if (list == null) {
			list = new ArrayList<CustomerStatus>();
			list.add(CURRENT);
			list.add(PROSPECT);
			list.add(TERMINATED);
			list.add(RE_AQUIRE);
		}
		return list;
	}

	/**
	 * Get a CustomerStatus based on the id.
	 */
	public static CustomerStatus getInstance(int id)
	{
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			CustomerStatus cs = (CustomerStatus) iter.next();
			if (cs.getId() == id) {
				return cs;
			}
		}

		throw new InvalidParameterException("No CustomerStatus with id: " + id);
	}
	
	/**
	 * Generate a String representation
	 */
	public String toString()
	{
		return description;
	}
}

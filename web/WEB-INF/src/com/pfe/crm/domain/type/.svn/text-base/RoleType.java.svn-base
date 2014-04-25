package com.pfe.crm.domain.type;


/**
 * RoleType.java
 * 
 * A type of role for the CRM system.  Follows the Typesafe enum
 * pattern.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Sep 18, 2006
 */
public class RoleType
{
	// DATA MEMBERS
	private String name;
	
	// CONSTRUCTOR
	/**
	 * Private constructor for immutability.
	 */
	private RoleType(String name)
	{
		this.name = name;
	}
	
	// TYPES
	public static final RoleType PFE_USER = new RoleType("pfeUser");

	
	// METHODS
	/**
	 * Return a String representation of a RoleType
	 */
	public String toString()
	{
		return "RoleType (" + name + ")";
	}
	
	/**
	 * Return the month for the given month number
	 */
	public static RoleType getInstance(String roleType)
	{
		if("pfeUser".equals(roleType)) { 
			return PFE_USER;
		}
		throw new IllegalArgumentException("role type: " + roleType);
	}
	
	/**
	 * @return Returns the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}

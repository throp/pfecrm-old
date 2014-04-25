package com.pfe.crm.domain.entity;

import java.io.Serializable;

import com.pfe.crm.domain.type.RoleType;

/**
 * Role.java
 * 
 * Represents a role of a given user. Note that this really represents the
 * relationship between a RoleType and a User, and is not a RoleType itself.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Sep 18, 2006
 */
public class Role implements Serializable
{
	// DATA MEMBERS
	private static final long serialVersionUID = 7811754019021824660L;

	private int id;

	private RoleType roleType;

	private Employee employee;
	
	private String userName;

	// ACCESSORS AND MUTATORS
	/**
	 * @return Returns the user.
	 */
	public Employee getEmployee()
	{
		return employee;
	}

	// METHODS
	/**
	 * Generate a String representation
	 */
	public String toString()
	{
		return "Role (" + id + ", " + userName + ", " + roleType + ")";
	}
	/**
	 * @param user
	 *            The user to set.
	 */
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	/**
	 * @return Returns the roleType.
	 */
	public RoleType getRoleType()
	{
		return roleType;
	}

	/**
	 * @param roleType
	 *            The roleType to set.
	 */
	public void setRoleType(RoleType roleType)
	{
		this.roleType = roleType;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName()
	{
		return userName;
	}

}

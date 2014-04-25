package com.pfe.crm.domain.entity;

import java.io.Serializable;

/**
 * LocationNote.java
 * 
 * A note that is related to a location.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 2, 2006
 */
public class LocationNote extends Note implements Serializable
{
	// DATA MEMBERS
	private Location location;

	private static final long serialVersionUID = -166108713710585126L;

	/**
	 * @return Returns the location.
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            The location to set.
	 */
	public void setLocation(Location location)
	{
		this.location = location;
	}

}

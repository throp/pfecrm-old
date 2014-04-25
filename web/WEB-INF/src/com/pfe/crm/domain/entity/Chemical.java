package com.pfe.crm.domain.entity;

import com.pfe.crm.core.domain.BaseEntity;

/**
 * Chemical.java
 * 
 * The chemical of the fire extinguisher.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 3, 2006
 */
public class Chemical extends BaseEntity
{
	// DATA MEMBERS
	private String name;
    
    private String abbreviation;

    private Boolean isActive = Boolean.TRUE;
    
	private static final long serialVersionUID = -2987100252330663420L;

	/**
	 * A string representation
	 */
	public String toString()
	{
		return name;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

    /**
     * @return the isActive
     */
    public Boolean getIsActive()
    {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * @return the abbreviation
     */
    public String getAbbreviation()
    {
        return abbreviation;
    }

    /**
     * @param abbreviation the abbreviation to set
     */
    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    
}

package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Floor.java
 * 
 * Typesafe enum representing the floor a product is on.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 8, 2006
 */
public class Floor implements Serializable
{
	// DATA MEMBERS
	private int number;

	private String description;

	private static List<Floor> list;

	private static final long serialVersionUID = -8341994732659621282L;

	public static final Floor BASEMENT = new Floor(0, "Basement");

    public static final Floor UNSPECIFIED = new Floor(-1, "-");
    
	// CONSTRUCTOR
	/**
	 * Private constructor for immutability
	 */
	private Floor(int number, String description)
	{
		this.description = description;
		this.number = number;
	}

	/**
	 * Get the list of all floors.
	 */
	public static List<Floor> list()
	{
		if (list == null) {
			list = new ArrayList<Floor>();
            list.add(UNSPECIFIED);
			list.add(BASEMENT);
			for (int i = 1; i < 50; i++) {
				final int floorModTen = i % 10;
				if (floorModTen == 1) {
					list.add(new Floor(i, i + "st floor"));
				} else if (floorModTen == 2) {
					list.add(new Floor(i, i + "nd floor"));
				} else if (floorModTen == 3) {
					list.add(new Floor(i, i + "rd floor"));
				} else {
					list.add(new Floor(i, i + "th floor"));
				}
			}
		}
		return list;
	}

	/**
	 * Get the instance associated with the floor num.
	 */
	public static Floor getInstance(int number)
	{
		Iterator iter = list().iterator();
		while (iter.hasNext()) {
			Floor f = (Floor) iter.next();
			if (f.getNumber() == number) {
				return f;
			}
		}
		throw new InvalidParameterException("no Floor exists for: " + number);
	}

	/**
	 * Generate a string representation
	 */
	public String toString()
	{
		return description;
	}

	// ACCESSORS
	/**
	 * @return Returns the description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return Returns the number.
	 */
	public int getNumber()
	{
		return number;
	}

}

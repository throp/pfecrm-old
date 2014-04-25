package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * EmployeeType.java
 * 
 * A typesafe enum to represent a type of employee.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Jul 17, 2006
 */
public class EmployeeType implements Serializable
{
	// DATA MEMBERS
	private static final long serialVersionUID = 3589301427730936363L;
	private int id;
	private String description;
	
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
	 * Private constructor for immutability
	 */
	private EmployeeType(int id, String description)
	{
		this.id = id;
		this.description = description;
	}
	
	// TYPES
	public static EmployeeType ROAD_TECHNICIAN = new EmployeeType(1, "Road Technician");
	public static EmployeeType SALES = new EmployeeType(2, "Sales");
	public static EmployeeType MANAGEMENT = new EmployeeType(3, "Management");
	public static EmployeeType ADMINISTRATIVE = new EmployeeType(4, "Administrative");
	public static EmployeeType SHOP_TECHNICIAN = new EmployeeType(5, "Shop Technician");
	
	// METHODS
	public static List<EmployeeType> list()
	{
		ArrayList<EmployeeType> list = new ArrayList<EmployeeType>();
		list.add(ROAD_TECHNICIAN);
		list.add(SHOP_TECHNICIAN);
		list.add(SALES);
		list.add(MANAGEMENT);
		list.add(ADMINISTRATIVE);
		return list;
	}
		
	public static EmployeeType getInstance(int id)
	{
		Iterator iter = list().iterator();
		while(iter.hasNext()) {
			EmployeeType type = (EmployeeType) iter.next();
			if(type.getId() == id) { 
				return type;
			}
		}
		throw new IllegalArgumentException("No type for id: " + id);
	}
	
	/**
	 * Generate a string representation of the EmployeeType
	 */
	public String toString()
	{
		return description;
	}
}

package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ndg.core.util.DateUtilities;

/**
 * Month.java
 * 
 * A typesafe enum for months.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Mar 24, 2006
 */
public class Month implements Serializable
{
	// DATA MEMBERS
	private static final long serialVersionUID = -6721891681689204446L;	
	private int number;
	private String name;

	// FACTORY METHOD
	/**
	 * Return the month for the given month number
	 */
	public static Month getInstance(int n)
	{
		Iterator iter = list().iterator();
		while(iter.hasNext()) {
			Month month = (Month) iter.next();
			if(month.getNumber() == n) { 
				return month;
			}
		}
		throw new IllegalArgumentException("Invalid month: " + n);
	}
	
	// ACCESSORS	
	public String getName()
	{
		return name;
	}
	public int getNumber()
	{
		return number;
	}
	
	// CONSTRUCTOR
	private Month(int num, String n)
	{
		number = num;
		name = n;
	}
	
	// TYPES
	public static final Month JANUARY = new Month(1, "January");
	public static final Month FEBRUARY = new Month(2, "February");
	public static final Month MARCH = new Month(3, "March");
	public static final Month APRIL = new Month(4, "April");
	public static final Month MAY = new Month(5, "May");
	public static final Month JUNE = new Month(6, "June");
	public static final Month JULY = new Month(7, "July");
	public static final Month AUGUST = new Month(8, "August");
	public static final Month SEPTEMBER = new Month(9, "September");
	public static final Month OCTOBER = new Month(10, "October");
	public static final Month NOVEMBER = new Month(11, "November");
	public static final Month DECEMBER = new Month(12, "December");	


	// METHODS
	/**
	 * Return the list of all Months
	 */
	public static List<Month> list()
	{
		List<Month> list = new ArrayList<Month>();	
		list.add(JANUARY);
		list.add(FEBRUARY);
		list.add(MARCH);		
		list.add(APRIL);
		list.add(MAY);
		list.add(JUNE);		
		list.add(JULY);
		list.add(AUGUST);
		list.add(SEPTEMBER);		
		list.add(OCTOBER);
		list.add(NOVEMBER);
		list.add(DECEMBER);		
		return list;
	}
	
	/**
	 * Return the month name.
	 */
	public String toString()
	{
		return name;
	}
    
    /**
     * Return this month.
     */
    public static Month thisMonth()
    {
        int month = DateUtilities.getMonthForToday();
        return Month.getInstance(month);
    }
}

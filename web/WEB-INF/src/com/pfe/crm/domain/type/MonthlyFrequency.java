package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * MonthlyFrequency.java
 * 
 * A typesafe enum defining the concept of a frequency of months - 
 * i.e. monthly, bi-monthly, yearly, etc.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Jun 27, 2006
 */
public class MonthlyFrequency implements Serializable
{
	// DATA MEMBERS
	private static final long serialVersionUID = -6881858953535741951L;
	public static final List<MonthlyFrequency> LIST = new ArrayList<MonthlyFrequency>();
	private String description;
	private int id;
	private int duration;
	
	/**
	 * Return the month for the given month number
	 */
	public static MonthlyFrequency getInstance(int n)
	{
		Iterator iter = list().iterator();
		while(iter.hasNext()) {
			MonthlyFrequency freq = (MonthlyFrequency) iter.next();
			if(freq.getId() == n) { 
				return freq;
			}
		}
		throw new IllegalArgumentException("Invalid month: " + n);
	}	
	
	// CONSTRUCTOR
	/**
	 * Default constructor - private!
	 */
	private MonthlyFrequency(int id, int duration, String description)
	{
		this.id = id;
		this.duration = duration;
		this.description = description;
		LIST.add(this);
	}
	
	// TYPES
	public static final MonthlyFrequency MONTHLY = new MonthlyFrequency(1, 1, "Monthly");
	public static final MonthlyFrequency BI_MONTHLY = new MonthlyFrequency(2, 2, "Bi-monthly");
	public static final MonthlyFrequency QUARTERLY = new MonthlyFrequency(3, 3, "Quarterly");
	public static final MonthlyFrequency SEMI_ANNUALLY = new MonthlyFrequency(4, 6, "Semi-annually");
	public static final MonthlyFrequency ANNUALLY = new MonthlyFrequency(5, 12, "Annually");
	public static final MonthlyFrequency BI_ANNUALLY = new MonthlyFrequency(6, 24, "Bi-annually");
	
	// ACCESSORS
	/**
	 * @return Returns the description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return Returns the duration.
	 */
	public int getDuration()
	{
		return duration;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return id;
	}

	public static List<MonthlyFrequency> list()
	{
		return new ArrayList<MonthlyFrequency>(LIST);
	}
	
	/**
	 * Return a String representation
	 */
	public String toString()
	{
		return description;
	}
    
    /**
     * A helper method for determining what other months in a year
     * are equivalent, given a target month.
     */
    public List<Month> getEquivalentMonths(Month targetMonth) {
        List<Month> months = new ArrayList<Month>();
        final int frequencyDuration = this.getDuration();
        final int monthNumber = targetMonth.getNumber();
        int mod = monthNumber % frequencyDuration;
        for (Month month : Month.list()) {
            int tempMod = month.getNumber() % frequencyDuration;
            if(tempMod == mod) { 
                months.add(month);
            }
        }
        return months;
    }
	
}

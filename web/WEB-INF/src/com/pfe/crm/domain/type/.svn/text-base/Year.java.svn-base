package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ndg.core.util.DateUtilities;

/**
 * Year.java
 * 
 * Type-safe enum for years
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 7, 2006
 */
public class Year implements Serializable
{
    // DATA MEMBERS
    private int year;

    private static List<Year> list;

    private static final long serialVersionUID = -3385760852016462688L;

    // CONSTRUCTOR
    /**
     * Private constructor for type-safe enum.
     */
    private Year(int year)
    {
        this.year = year;
    }

    /**
     * Get the instance associated with the year.
     */
    public static Year getInstance(int year)
    {
        Iterator iter = list().iterator();
        while (iter.hasNext()) {
            Year y = (Year) iter.next();
            if (y.getYear() == year) {
                return y;
            }
        }
        return null;
    }

    /**
     * Get the list of all years.
     */
    public static List<Year> list()
    {
        if (list == null) {
            list = new ArrayList<Year>();
            int year = DateUtilities.getYearForToday() + 1;
            for (int i = year; i > year - 70; i--) {
                list.add(new Year(i));
            }
        }
        return list;
    }

    /**
     * Generate a String representation.
     */
    public String toString()
    {
        return year + "";
    }

    /**
     * @return Returns the year.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return the string of the year.
     */
    public String getName()
    {
        return year + "";
    }

    /**
     * Return this year.
     */
    public static Year thisYear()
    {
        int thisYear = DateUtilities.getYearForToday();
        return Year.getInstance(thisYear);
    }

    /**
     * Return next year.
     */
    public static Year nextYear()
    {
        int nextYear = DateUtilities.getYearForToday() + 1;
        return Year.getInstance(nextYear);
    }

    /**
     * Return next year.
     */
    public static Year lastYear()
    {
        int lastYear = DateUtilities.getYearForToday() - 1;
        return Year.getInstance(lastYear);
    }
}

package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * FireExtinguisherServiceType.java
 * 
 * A typesafe enum for the fire extinguisher service type.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 10, 2006
 */
public class FireExtinguisherTestType implements Serializable
{
    // DATA MEMBERS
    private int id;

    private String name;

    private String abbreviation;

    private static final long serialVersionUID = -6308249441298729785L;

    private static List<FireExtinguisherTestType> list;

    // CONSTRUCTOR
    /**
     * Private constructor for immutability
     */
    private FireExtinguisherTestType(int id, String abbreviation, String name)
    {
        this.name = name;
        this.id = id;
        this.abbreviation = abbreviation;
    }

    // TYPES
    public static final FireExtinguisherTestType SIX_YEAR = new FireExtinguisherTestType(
            1, "6yr", "6 year maintenance");

    public static final FireExtinguisherTestType HYDRO = new FireExtinguisherTestType(
            2, "Hydro", "Hydro Test");

    // METHODS
    /**
     * Generate a String representation.
     */
    public String toString()
    {
        return name;
    }

    /**
     * Return the list of all types
     */
    public static List<FireExtinguisherTestType> list()
    {
        if (list == null) {
            list = new ArrayList<FireExtinguisherTestType>();
            list.add(SIX_YEAR);
            list.add(HYDRO);
        }
        return list;
    }

    /**
     * Get the instance with the given id
     */
    public static FireExtinguisherTestType getInstance(int id)
    {
        Iterator iter = list().iterator();
        while (iter.hasNext()) {
            FireExtinguisherTestType type = (FireExtinguisherTestType) iter
                    .next();
            if (type.getId() == id) {
                return type;
            }
        }

        return null;
    }

    // ACCESSORS
    /**
     * @return Returns the abbreviation.
     */
    public String getAbbreviation()
    {
        return abbreviation;
    }

    /**
     * @return Returns the id.
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return Returns the name.
     */
    public String getName()
    {
        return name;
    }

}

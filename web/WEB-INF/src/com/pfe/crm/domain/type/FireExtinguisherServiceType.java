package com.pfe.crm.domain.type;

import java.io.Serializable;
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
public class FireExtinguisherServiceType implements Serializable
{
    // DATA MEMBERS
    private int id;

    private String name;

    private String abbreviation;

    private static final long serialVersionUID = -6308249441298729785L;

    private static List<FireExtinguisherServiceType> list;

    // CONSTRUCTOR
    /**
     * Private constructor for immutability
     */
    private FireExtinguisherServiceType(int id, String abbreviation, String name)
    {
        this.name = name;
        this.id = id;
        this.abbreviation = abbreviation;
    }

    // TYPES
    public static final FireExtinguisherServiceType NEW = new FireExtinguisherServiceType(
            1, "New", "New Extinguisher");

    public static final FireExtinguisherServiceType SIX_YEAR = new FireExtinguisherServiceType(
            2, "6yr", "6 year maintenance");

    public static final FireExtinguisherServiceType HYDRO = new FireExtinguisherServiceType(
            3, "Hydro", "Hydro Test");

    public static final FireExtinguisherServiceType RECHARGE = new FireExtinguisherServiceType(
            4, "ReChg", "Re-charge");

    public static final FireExtinguisherServiceType INSTALL = new FireExtinguisherServiceType(
            5, "Ins", "Install");

    public static final FireExtinguisherServiceType CONDEMN = new FireExtinguisherServiceType(
            6, "Cond", "Condemn");

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
    public static List<FireExtinguisherServiceType> list()
    {
        if (list == null) {
            list = new ArrayList<FireExtinguisherServiceType>();
            list.add(NEW);
            list.add(SIX_YEAR);
            list.add(HYDRO);
            list.add(RECHARGE);
            list.add(INSTALL);
            list.add(CONDEMN);
        }
        return list;
    }

    /**
     * Get the instance with the given id
     */
    public static FireExtinguisherServiceType getInstance(int id)
    {
        Iterator iter = list().iterator();
        while (iter.hasNext()) {
            FireExtinguisherServiceType type = (FireExtinguisherServiceType) iter
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

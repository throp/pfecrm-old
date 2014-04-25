package com.pfe.crm.domain.entity;

import com.pfe.crm.core.domain.BaseEntity;

import java.util.Collection;

/**
 * Office.java
 * 
 * Represents a physical office that a customer is related to, like 'Pittsburgh'
 * or 'Washington'.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 4, 2006
 */
public class Office extends BaseEntity
{
    // DATA MEMBERS
    private static final long serialVersionUID = 375679641144275540L;

    private String name;

    private Boolean isActive = true;

    private Collection customers;

    // METHODS
    /**
     * @return Returns the customers.
     */
    public Collection getCustomers()
    {
        return customers;
    }

    /**
     * @param customers
     *            The customers to set.
     */
    public void setCustomers(Collection customers)
    {
        this.customers = customers;
    }

    /**
     * Add a location to the list of customer locations.
     * 
     * @param location
     */
    public void addCustomer(Customer customer)
    {
        if (customer == null) {
            throw new IllegalArgumentException("Null customer in addCustomer!");
        }
        if (customer.getOffice() != null) {
            customer.removeOffice();
        }
        customers.add(customer);
        customer.setOffice(this);
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
     * String representation
     */
    public String toString()
    {
        return name;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive()
    {
        return isActive;
    }

    /**
     * @param isActive
     *            the isActive to set
     */
    public void setIsActive(Boolean isActive)
    {
        this.isActive = isActive;
    }
}

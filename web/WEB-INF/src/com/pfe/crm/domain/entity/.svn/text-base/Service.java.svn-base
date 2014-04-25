package com.pfe.crm.domain.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.pfe.crm.core.domain.BaseEntity;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.MonthlyFrequency;
import com.pfe.crm.domain.type.ServiceType;

/**
 * Service.java
 * 
 * A service that a location can have.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 1, 2006
 */
public class Service extends BaseEntity
{

    // DATA MEMBERS
    private static final long serialVersionUID = 1L;

    private MonthlyFrequency serviceFrequency;

    private Month serviceMonth;

    private Location location;

    private ServiceType serviceType;

    private Set<InventoryItem> inventoryItems;

    protected Set jobs;

    private Set serviceCalls;

    private String notes;

    private int numInventoryItems;

    /**
     * @return the notes
     */
    public String getNotes()
    {
        return notes;
    }

    /**
     * @param notes
     *            the notes to set
     */
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    /**
     * @return the serviceCalls
     */
    public Set getServiceCalls()
    {
        return serviceCalls;
    }

    /**
     * @param serviceCalls
     *            the serviceCalls to set
     */
    public void setServiceCalls(Set serviceCalls)
    {
        this.serviceCalls = serviceCalls;
    }

    /**
     * Add a job.
     */
    public void addJob(Job job)
    {
        if (jobs == null) {
            jobs = new HashSet();
        }
        jobs.add(job);
        job.setService(this);
    }

    /**
     * @return Returns the jobs.
     */
    public Collection getJobs()
    {
        return jobs;
    }

    /**
     * @param jobs
     *            The jobs to set.
     */
    public void setJobs(Set jobs)
    {
        this.jobs = jobs;
    }

    /**
     * @return the serviceType
     */
    public ServiceType getServiceType()
    {
        return serviceType;
    }

    /**
     * @param serviceType
     *            the serviceType to set
     */
    public void setServiceType(ServiceType serviceType)
    {
        this.serviceType = serviceType;
    }

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

    /**
     * @return Returns the serviceFrequency.
     */
    public MonthlyFrequency getServiceFrequency()
    {
        return serviceFrequency;
    }

    /**
     * @param serviceFrequency
     *            The serviceFrequency to set.
     */
    public void setServiceFrequency(MonthlyFrequency serviceFrequency)
    {
        this.serviceFrequency = serviceFrequency;
    }

    /**
     * @return Returns the serviceMonth.
     */
    public Month getServiceMonth()
    {
        return serviceMonth;
    }

    /**
     * @param serviceMonth
     *            The serviceMonth to set.
     */
    public void setServiceMonth(Month serviceMonth)
    {
        this.serviceMonth = serviceMonth;
    }

    /**
     * @return the inventoryItems
     */
    public Set<InventoryItem> getInventoryItems()
    {
        return inventoryItems;
    }

    /**
     * @param inventoryItems
     *            the inventoryItems to set
     */
    public void setInventoryItems(Set inventoryItems)
    {
        this.inventoryItems = inventoryItems;
    }

    /**
     * Add an inventory item.
     */
    public void addInventoryItem(InventoryItem inventoryItem)
    {
        if (inventoryItems == null) {
            inventoryItems = new HashSet<InventoryItem>();
        }
        inventoryItem.setService(this);
        inventoryItems.add(inventoryItem);
    }

    /**
     * Add a service call.
     */
    public void addServiceCall(ServiceCall serviceCall)
    {
        if (serviceCalls == null) {
            serviceCalls = new HashSet();
        }
        serviceCalls.add(serviceCall);
        serviceCall.setService(this);
    }

    /**
     * @return the numInventoryItems
     */
    public int getNumInventoryItems()
    {
        return numInventoryItems;
    }

    /**
     * @param numInventoryItems
     *            the numInventoryItems to set
     */
    public void setNumInventoryItems(int numInventoryItems)
    {
        this.numInventoryItems = numInventoryItems;
    }

}

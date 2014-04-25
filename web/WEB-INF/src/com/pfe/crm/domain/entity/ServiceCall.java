package com.pfe.crm.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ServiceCall.java
 * 
 * When a customer calls to have a location checked out, this is a service call.
 * 
 * @author Ben Northrop Oct 26, 2006
 * 
 */
public class ServiceCall implements Serializable
{

    // DATA MEMBERS
    private int id;

    private Service service;

    private String notes;

    private Date datePlaced;
    
    private Employee employee;
    
    private Job job;

    private static final long serialVersionUID = 3812425090878467519L;

    /**
     * @return the datePlaced
     */
    public Date getDatePlaced()
    {
        return datePlaced;
    }

    /**
     * @param datePlaced
     *            the datePlaced to set
     */
    public void setDatePlaced(Date datePlaced)
    {
        this.datePlaced = datePlaced;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

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
     * @return the employee
     */
    public Employee getEmployee()
    {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    /**
     * @return the service
     */
    public Service getService()
    {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Service service)
    {
        this.service = service;
    }

    /**
     * @return the job
     */
    public Job getJob()
    {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(Job job)
    {
        this.job = job;
    }


}

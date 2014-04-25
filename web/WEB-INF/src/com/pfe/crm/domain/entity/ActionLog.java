package com.pfe.crm.domain.entity;

import java.util.Date;

/**
 * ActionLog.java
 * 
 * An audit record of something done by an employee. 
 * 
 * @author Ben Northrop
 * Dec 8, 2006
 *
 */
public class ActionLog
{
    // DATA MEMBERS
    private int id;
    
    private Employee employee;
    
    private Date date;
    
    private Date time;
    
    private String description;

    // CONSTRUCTOR
    /**
     * Default constructor
     */
    public ActionLog() {
        this.date = new Date();
        this.time = new Date();
    }
    
    /**
     * Convenience constructor.
     */
    public ActionLog(String description) {
        this();
        this.description = description;
    }
    
    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
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
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the time
     */
    public Date getTime()
    {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time)
    {
        this.time = time;
    }
    
    
}

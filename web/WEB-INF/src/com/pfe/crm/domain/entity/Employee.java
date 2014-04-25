package com.pfe.crm.domain.entity;

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.pfe.crm.core.domain.BaseEntity;
import com.pfe.crm.domain.type.EmployeeType;

/**
 * Employee.java
 * 
 * Represents an employee for USI.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jul 17, 2006
 */
public class Employee extends BaseEntity
{
    // DATA MEMBERS
    private String firstName;

    private String lastName;

    private EmployeeType employeeType;

    private static final long serialVersionUID = 5482869286539941321L;

    private Collection customerNotes;

    private Collection locationNotes;

    private Collection serviceCalls;

    private String userName;

    private String password;

    private Set<Job> roadTechnicianJobs;

    private Set<Job> shopTechnicianJobs;

    private Set<Job> creditedTechnicianJobs;

    private Set<Job> returnTechnicianJobs;

    private Collection roles;

    private Boolean isActive;

    private Set<ActionLog> actionLogs;

    /**
     * @return Returns the password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password
     *            The password to set.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return Returns the roles.
     */
    public Collection getRoles()
    {
        return roles;
    }

    /**
     * @param roles
     *            The roles to set.
     */
    public void setRoles(Collection roles)
    {
        this.roles = roles;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName
     *            The userName to set.
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * Add a role to the user.
     */
    public void addRole(Role role)
    {
        if (role == null) {
            throw new InvalidParameterException("role is null in addRole()");
        }
        if (roles == null) {
            roles = new HashSet();
        }
        roles.add(role);
        role.setEmployee(this);
    }

    /**
     * Get the first name and last name concatenated.
     */
    public String getName()
    {
        return firstName + " " + lastName;
    }

    /**
     * @return the isActive
     */
    public Boolean isActive()
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
    public void setActive(Boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Add a customer note to the employee
     */
    public void addLocationNote(LocationNote locationNote)
    {
        if (locationNote == null) {
            throw new IllegalArgumentException(
                    "Null locationNote in addLocationNote()!");
        }
        locationNote.setEmployee(this);
        locationNotes.add(locationNote);
    }

    /**
     * @return Returns the customerNotes.
     */
    public Collection getLocationNotes()
    {
        return locationNotes;
    }

    /**
     * @param customerNotes
     *            The customerNotes to set.
     */
    public void setLocationNotes(Collection locationNotes)
    {
        this.locationNotes = locationNotes;
    }

    /**
     * Add a customer note to the employee
     */
    public void addCustomerNote(CustomerNote customerNote)
    {
        if (customerNote == null) {
            throw new IllegalArgumentException(
                    "Null customerNote in addCustomerNote()!");
        }
        customerNote.setEmployee(this);
        customerNotes.add(customerNote);
    }

    /**
     * @return Returns the customerNotes.
     */
    public Collection getCustomerNotes()
    {
        return customerNotes;
    }

    /**
     * @param customerNotes
     *            The customerNotes to set.
     */
    public void setCustomerNotes(Collection customerNotes)
    {
        this.customerNotes = customerNotes;
    }

    /**
     * A String representation
     */
    public String toString()
    {
        return firstName + " " + lastName;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    /**
     * @return Returns the lastName.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return Returns the employeeType.
     */
    public EmployeeType getEmployeeType()
    {
        return employeeType;
    }

    /**
     * @param employeeType
     *            The employeeType to set.
     */
    public void setEmployeeType(EmployeeType employeeType)
    {
        this.employeeType = employeeType;
    }

    /**
     * @return Returns the roadTechnicianJobs.
     */
    public Set<Job> getRoadTechnicianJobs()
    {
        return roadTechnicianJobs;
    }

    /**
     * @param roadTechnicianJobs
     *            The roadTechnicianJobs to set.
     */
    public void setRoadTechnicianJobs(Set<Job> roadTechnicianJobs)
    {
        this.roadTechnicianJobs = roadTechnicianJobs;
    }

    /**
     * @return Returns the shopTechnicianJobs.
     */
    public Set<Job> getShopTechnicianJobs()
    {
        return shopTechnicianJobs;
    }

    /**
     * @param shopTechnicianJobs
     *            The shopTechnicianJobs to set.
     */
    public void setShopTechnicianJobs(Set<Job> shopTechnicianJobs)
    {
        this.shopTechnicianJobs = shopTechnicianJobs;
    }

    /**
     * Add a job to the list.
     */
    public void addShopTechnicianJob(Job job)
    {
        if (job == null) {
            throw new InvalidParameterException("Job is null!");
        }
        job.setShopTechnician(this);
        shopTechnicianJobs.add(job);
    }

    /**
     * Add a job to the list.
     */
    public void addRoadTechnicianJob(Job job)
    {
        if (job == null) {
            throw new InvalidParameterException("Job is null!");
        }
        job.setRoadTechnician(this);
        roadTechnicianJobs.add(job);
    }

    /**
     * Remove a road tech job from the list.
     */
    public void removeRoadTechnicianJob(Job job)
    {
        if (job == null) {
            throw new InvalidParameterException("Job is null!");
        }

        this.getRoadTechnicianJobs().remove(job);
    }

    /**
     * @return the serviceCalls
     */
    public Collection getServiceCalls()
    {
        return serviceCalls;
    }

    /**
     * @param serviceCalls
     *            the serviceCalls to set
     */
    public void setServiceCalls(Collection serviceCalls)
    {
        this.serviceCalls = serviceCalls;
    }

    /**
     * @return the creditedTechnicianJobs
     */
    public Set<Job> getCreditedTechnicianJobs()
    {
        return creditedTechnicianJobs;
    }

    /**
     * @param creditedTechnicianJobs
     *            the creditedTechnicianJobs to set
     */
    public void setCreditedTechnicianJobs(Set<Job> creditedTechnicianJobs)
    {
        this.creditedTechnicianJobs = creditedTechnicianJobs;
    }

    /**
     * @return the returnTechnicianJobs
     */
    public Set<Job> getReturnTechnicianJobs()
    {
        return returnTechnicianJobs;
    }

    /**
     * @param returnTechnicianJobs
     *            the returnTechnicianJobs to set
     */
    public void setReturnTechnicianJobs(Set<Job> returnTechnicianJobs)
    {
        this.returnTechnicianJobs = returnTechnicianJobs;
    }

    /**
     * Add a job to the list.
     */
    public void addReturnTechnicianJob(Job job)
    {
        if (job == null) {
            throw new InvalidParameterException("Job is null!");
        }
        job.setReturnTechnician(this);
        if (returnTechnicianJobs == null) {
            returnTechnicianJobs = new HashSet<Job>();
        }
        returnTechnicianJobs.add(job);
    }

    /**
     * Add a job to the list.
     */
    public void addCreditedTechnicianJob(Job job)
    {
        if (job == null) {
            throw new InvalidParameterException("Job is null!");
        }
        job.setCreditedTechnician(this);
        if (creditedTechnicianJobs == null) {
            creditedTechnicianJobs = new HashSet<Job>();
        }
        creditedTechnicianJobs.add(job);
    }

    /**
     * Add an action log to an employee.
     */
    public void addActionLog(ActionLog actionLog)
    {
        if (actionLog == null) {
            throw new InvalidParameterException("ActionLog is null!");
        }
        actionLog.setEmployee(this);
        if (actionLogs == null) {
            actionLogs = new HashSet<ActionLog>();
        }
        actionLogs.add(actionLog);
    }

    /**
     * @return the actionLogs
     */
    public Set<ActionLog> getActionLogs()
    {
        return actionLogs;
    }

    /**
     * @param actionLogs
     *            the actionLogs to set
     */
    public void setActionLogs(Set<ActionLog> actionLogs)
    {
        this.actionLogs = actionLogs;
    }
}

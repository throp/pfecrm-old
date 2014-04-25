package com.pfe.crm.domain.entity;

import java.util.Date;

import com.ndg.core.util.DateUtilities;
import com.pfe.crm.core.domain.BaseEntity;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.Year;

/**
 * Job.java
 * 
 * A job for a particular service.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 9, 2006
 */
public class Job extends BaseEntity
{

    // DATA MEMBERS
    private static final long serialVersionUID = 7452500566586998675L;

    private Month monthDue;

    private Year yearDue;

    private Date dateInRoadTechQueue;

    private Date dateInShopTechQueue;

    private Date dateInReturnTechQueue;

    private Date dateReadyForReturn;

    private Date dateCompleted;

    private Date dateBilled;

    private Employee shopTechnician;

    private Employee roadTechnician;

    private Employee returnTechnician;

    private Employee creditedTechnician;

    private Service service;

    private ServiceCall serviceCall;

    private float invoiceAmount;

    private String invoiceNumber;

    // CONSTRUCTORS
    /**
     * Default
     */
    public Job()
    {
    }

    /**
     * Convenience constructor.
     */
    public Job(Month monthDue, Year yearDue, Service service)
    {
        this.monthDue = monthDue;
        this.yearDue = yearDue;
        this.service = service;
    }



    /**
     * Calculate the number of days in the process.
     */
    public int getDaysInProgress()
    {
        return DateUtilities.calculateDaysBetween(dateInRoadTechQueue,
                new Date());
    }

    /**
     * Calculate whether it is in the shop right now or not.
     */
    public boolean getIsInShop()
    {
        return dateInShopTechQueue != null && dateReadyForReturn == null;
    }

    /**
     * Calculate whether the job is on the road being serviced.
     */
    public boolean getIsBeingServiced()
    {
        return dateInRoadTechQueue != null && dateCompleted == null
                && dateInShopTechQueue == null;
    }

    /**
     * Calculate whether the job is on the road being retured.
     */
    public boolean getIsBeingReturned()
    {
        return dateInReturnTechQueue != null && dateCompleted == null;
    }

    /**
     * @return the invoiceAmount
     */
    public float getInvoiceAmount()
    {
        return invoiceAmount;
    }

    /**
     * @param invoiceAmount
     *            the invoiceAmount to set
     */
    public void setInvoiceAmount(float amountBilled)
    {
        this.invoiceAmount = amountBilled;
    }

    /**
     * @return Returns the dateBilled.
     */
    public Date getDateBilled()
    {
        return dateBilled;
    }

    /**
     * @param dateBilled
     *            The dateBilled to set.
     */
    public void setDateBilled(Date dateBilled)
    {
        this.dateBilled = dateBilled;
    }

    /**
     * @return Returns the dateComplete.
     */
    public Date getDateCompleted()
    {
        return dateCompleted;
    }

    /**
     * @param dateComplete
     *            The dateComplete to set.
     */
    public void setDateCompleted(Date dateComplete)
    {
        this.dateCompleted = dateComplete;
    }

    /**
     * @return Returns the dateInRoadTechQueue.
     */
    public Date getDateInRoadTechQueue()
    {
        return dateInRoadTechQueue;
    }

    /**
     * @param dateInRoadTechQueue
     *            The dateInRoadTechQueue to set.
     */
    public void setDateInRoadTechQueue(Date dateInRoadTechQueue)
    {
        this.dateInRoadTechQueue = dateInRoadTechQueue;
    }

    /**
     * @return Returns the dateInShopTechQueue.
     */
    public Date getDateInShopTechQueue()
    {
        return dateInShopTechQueue;
    }

    /**
     * @param dateInShopTechQueue
     *            The dateInShopTechQueue to set.
     */
    public void setDateInShopTechQueue(Date dateInShopTechQueue)
    {
        this.dateInShopTechQueue = dateInShopTechQueue;
    }

    /**
     * @return Returns the dateReadyForReturn.
     */
    public Date getDateReadyForReturn()
    {
        return dateReadyForReturn;
    }

    /**
     * @param dateReadyForReturn
     *            The dateReadyForReturn to set.
     */
    public void setDateReadyForReturn(Date dateReadyForReturn)
    {
        this.dateReadyForReturn = dateReadyForReturn;
    }

    /**
     * @return Returns the roadTechnician.
     */
    public Employee getRoadTechnician()
    {
        return roadTechnician;
    }

    /**
     * @param roadTechnician
     *            The roadTechnician to set.
     */
    public void setRoadTechnician(Employee roadTechnician)
    {
        this.roadTechnician = roadTechnician;
    }

    /**
     * @return Returns the service.
     */
    public Service getService()
    {
        return service;
    }

    /**
     * @param service
     *            The service to set.
     */
    public void setService(Service service)
    {
        this.service = service;
    }

    /**
     * @return Returns the shopTechnician.
     */
    public Employee getShopTechnician()
    {
        return shopTechnician;
    }

    /**
     * @param shopTechnician
     *            The shopTechnician to set.
     */
    public void setShopTechnician(Employee shopTechnician)
    {
        this.shopTechnician = shopTechnician;
    }

    /**
     * @return the creditedTechnician
     */
    public Employee getCreditedTechnician()
    {
        return creditedTechnician;
    }

    /**
     * @param creditedTechnician
     *            the creditedTechnician to set
     */
    public void setCreditedTechnician(Employee creditedTechnician)
    {
        this.creditedTechnician = creditedTechnician;
    }

    /**
     * @return the returnTechnician
     */
    public Employee getReturnTechnician()
    {
        return returnTechnician;
    }

    /**
     * @param returnTechnician
     *            the returnTechnician to set
     */
    public void setReturnTechnician(Employee returnTechnician)
    {
        this.returnTechnician = returnTechnician;
    }

    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber
     *            the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the serviceCall
     */
    public ServiceCall getServiceCall()
    {
        return serviceCall;
    }

    /**
     * @param serviceCall
     *            the serviceCall to set
     */
    public void setServiceCall(ServiceCall serviceCall)
    {
        this.serviceCall = serviceCall;
    }

    /**
     * @return the dateInReturnTechQueue
     */
    public Date getDateInReturnTechQueue()
    {
        return dateInReturnTechQueue;
    }

    /**
     * @param dateInReturnTechQueue
     *            the dateInReturnTechQueue to set
     */
    public void setDateInReturnTechQueue(Date dateInReturnTechQueue)
    {
        this.dateInReturnTechQueue = dateInReturnTechQueue;
    }

    /**
     * @return the monthDue
     */
    public Month getMonthDue()
    {
        return monthDue;
    }

    /**
     * @param monthDue
     *            the monthDue to set
     */
    public void setMonthDue(Month monthDue)
    {
        this.monthDue = monthDue;
    }

    /**
     * @return the yearDue
     */
    public Year getYearDue()
    {
        return yearDue;
    }

    /**
     * @param yearDue
     *            the yearDue to set
     */
    public void setYearDue(Year yearDue)
    {
        this.yearDue = yearDue;
    }

}

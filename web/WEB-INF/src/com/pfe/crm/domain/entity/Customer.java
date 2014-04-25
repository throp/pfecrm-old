package com.pfe.crm.domain.entity;

import java.util.Collection;

import com.pfe.crm.core.domain.BaseEntity;
import com.pfe.crm.domain.type.CustomerStatus;

/**
 * Customer.java
 * 
 * The core customer entity.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 13, 2006
 */
public class Customer extends BaseEntity
{
    // CONSTANTS
    /**
     * Random SUID
     */
    private static final long serialVersionUID = 6997148421267865053L;

    // DATA MEMBERS
    private String name;

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private String state;

    private String zip;

    private String faxNumber;

    private Office office;

    private Collection locations;

    private Collection notes;

    private CustomerStatus status;

    private String blanketPO;

    private String primaryContactFirstName;

    private String primaryContactLastName;

    private String primaryContactPhoneNumber;

    private String primaryContactPhoneExtension;

    private String primaryContactEmailAddress;

    private String primaryContactTitle;

    private String secondaryContactFirstName;

    private String secondaryContactLastName;

    private String secondaryContactPhoneNumber;

    private String secondaryContactPhoneExtension;

    private String secondaryContactEmailAddress;

    private String secondaryContactTitle;

    /**
     * Return the truncated customer name.
     */
    public String getNameAbbreviation()
    {
        if (name == null) {
            return null;
        } else if (name.length() < 20) {
            return name;
        } else {
            return name.substring(0, 19) + "...";
        }
    }

    /**
     * @return the blanketPO
     */
    public String getBlanketPO()
    {
        return blanketPO;
    }

    /**
     * @param blanketPO
     *            the blanketPO to set
     */
    public void setBlanketPO(String blanketPO)
    {
        this.blanketPO = blanketPO;
    }

    /**
     * Add a location to the list of customer locations.
     * 
     * @param location
     */
    public void addLocation(Location location)
    {
        if (location == null) {
            throw new IllegalArgumentException("Null location in addLocation!");
        }
        if (location.getCustomer() != null) {
            location.removeCustomer();
        }
        locations.add(location);
        location.setCustomer(this);
    }

    public Collection getLocations()
    {
        return locations;
    }

    public void setLocations(Collection locations)
    {
        this.locations = locations;
    }

    /**
     * @return Returns the address1.
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * @param address1
     *            The address1 to set.
     */
    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    /**
     * @return Returns the address2.
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * @param address2
     *            The address2 to set.
     */
    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    /**
     * @return Returns the address3.
     */
    public String getAddress3()
    {
        return address3;
    }

    /**
     * @param address3
     *            The address3 to set.
     */
    public void setAddress3(String address3)
    {
        this.address3 = address3;
    }

    /**
     * @return Returns the city.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city
     *            The city to set.
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return Returns the faxNumber.
     */
    public String getFaxNumber()
    {
        return faxNumber;
    }

    /**
     * @param faxNumber
     *            The faxNumber to set.
     */
    public void setFaxNumber(String faxNumber)
    {
        this.faxNumber = faxNumber;
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
     * @return Returns the state.
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state
     *            The state to set.
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return Returns the zip.
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * @param zip
     *            The zip to set.
     */
    public void setZip(String zip)
    {
        this.zip = zip;
    }

    /**
     * @return Returns the status.
     */
    public CustomerStatus getStatus()
    {
        return status;
    }

    /**
     * @param status
     *            The status to set.
     */
    public void setStatus(CustomerStatus status)
    {
        this.status = status;
    }

    /**
     * @return Returns the notes.
     */
    public Collection getNotes()
    {
        return notes;
    }

    /**
     * @param notes
     *            The notes to set.
     */
    public void setNotes(Collection notes)
    {
        this.notes = notes;
    }

    /**
     * @param note
     *            to add
     */
    public void addNote(CustomerNote note)
    {
        if (note == null) {
            throw new IllegalArgumentException("Null note in addNote()!");
        }
        note.setCustomer(this);
        notes.add(note);
    }

    /**
     * @return Returns the office.
     */
    public Office getOffice()
    {
        return office;
    }

    /**
     * @param office
     *            The office to set.
     */
    public void setOffice(Office office)
    {
        this.office = office;
    }

    /**
     * Remove the office
     */
    public void removeOffice()
    {
        this.office = null;
    }

    /**
     * @return the primaryContactEmailAddress
     */
    public String getPrimaryContactEmailAddress()
    {
        return primaryContactEmailAddress;
    }

    /**
     * @param primaryContactEmailAddress
     *            the primaryContactEmailAddress to set
     */
    public void setPrimaryContactEmailAddress(String primaryContactEmailAddress)
    {
        this.primaryContactEmailAddress = primaryContactEmailAddress;
    }

    /**
     * @return the primaryContactTitle
     */
    public String getPrimaryContactTitle()
    {
        return primaryContactTitle;
    }

    /**
     * @param primaryContactTitle
     *            the primaryContactTitle to set
     */
    public void setPrimaryContactTitle(String primaryContactFaxNumber)
    {
        this.primaryContactTitle = primaryContactFaxNumber;
    }

    /**
     * @return the primaryContactFirstName
     */
    public String getPrimaryContactFirstName()
    {
        return primaryContactFirstName;
    }

    /**
     * @param primaryContactFirstName
     *            the primaryContactFirstName to set
     */
    public void setPrimaryContactFirstName(String primaryContactFirstName)
    {
        this.primaryContactFirstName = primaryContactFirstName;
    }

    /**
     * @return the primaryContactLastName
     */
    public String getPrimaryContactLastName()
    {
        return primaryContactLastName;
    }

    /**
     * @param primaryContactLastName
     *            the primaryContactLastName to set
     */
    public void setPrimaryContactLastName(String primaryContactLastName)
    {
        this.primaryContactLastName = primaryContactLastName;
    }

    /**
     * @return the primaryContactPhoneNumber
     */
    public String getPrimaryContactPhoneNumber()
    {
        return primaryContactPhoneNumber;
    }

    /**
     * @param primaryContactPhoneNumber
     *            the primaryContactPhoneNumber to set
     */
    public void setPrimaryContactPhoneNumber(String primaryContactPhoneNumber)
    {
        this.primaryContactPhoneNumber = primaryContactPhoneNumber;
    }

    /**
     * @return the secondaryContactEmailAddress
     */
    public String getSecondaryContactEmailAddress()
    {
        return secondaryContactEmailAddress;
    }

    /**
     * @param secondaryContactEmailAddress
     *            the secondaryContactEmailAddress to set
     */
    public void setSecondaryContactEmailAddress(
            String secondaryContactEmailAddress)
    {
        this.secondaryContactEmailAddress = secondaryContactEmailAddress;
    }

    /**
     * @return the secondaryContactTitle
     */
    public String getSecondaryContactTitle()
    {
        return secondaryContactTitle;
    }

    /**
     * @param secondaryContactTitle
     *            the secondaryContactTitle to set
     */
    public void setSecondaryContactTitle(String secondaryContactFaxNumber)
    {
        this.secondaryContactTitle = secondaryContactFaxNumber;
    }

    /**
     * @return the secondaryContactFirstName
     */
    public String getSecondaryContactFirstName()
    {
        return secondaryContactFirstName;
    }

    /**
     * @param secondaryContactFirstName
     *            the secondaryContactFirstName to set
     */
    public void setSecondaryContactFirstName(String secondaryContactFirstName)
    {
        this.secondaryContactFirstName = secondaryContactFirstName;
    }

    /**
     * @return the secondaryContactLastName
     */
    public String getSecondaryContactLastName()
    {
        return secondaryContactLastName;
    }

    /**
     * @param secondaryContactLastName
     *            the secondaryContactLastName to set
     */
    public void setSecondaryContactLastName(String secondaryContactLastName)
    {
        this.secondaryContactLastName = secondaryContactLastName;
    }

    /**
     * @return the secondaryContactPhoneNumber
     */
    public String getSecondaryContactPhoneNumber()
    {
        return secondaryContactPhoneNumber;
    }

    /**
     * @param secondaryContactPhoneNumber
     *            the secondaryContactPhoneNumber to set
     */
    public void setSecondaryContactPhoneNumber(
            String secondaryContactPhoneNumber)
    {
        this.secondaryContactPhoneNumber = secondaryContactPhoneNumber;
    }

    /**
     * @return the primaryContactPhoneExtension
     */
    public String getPrimaryContactPhoneExtension()
    {
        return primaryContactPhoneExtension;
    }

    /**
     * @param primaryContactPhoneExtension
     *            the primaryContactPhoneExtension to set
     */
    public void setPrimaryContactPhoneExtension(
            String primaryContactPhoneExtension)
    {
        this.primaryContactPhoneExtension = primaryContactPhoneExtension;
    }

    /**
     * @return the secondaryContactPhoneExtension
     */
    public String getSecondaryContactPhoneExtension()
    {
        return secondaryContactPhoneExtension;
    }

    /**
     * @param secondaryContactPhoneExtension
     *            the secondaryContactPhoneExtension to set
     */
    public void setSecondaryContactPhoneExtension(
            String secondaryContactPhoneExtension)
    {
        this.secondaryContactPhoneExtension = secondaryContactPhoneExtension;
    }
}

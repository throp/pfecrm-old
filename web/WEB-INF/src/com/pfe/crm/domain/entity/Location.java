package com.pfe.crm.domain.entity;

import com.pfe.crm.core.domain.BaseEntity;
import com.pfe.crm.domain.type.ServiceType;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Location.java
 * 
 * A core entity which represents a location of a given customer. Customers can
 * have many locations.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 27, 2006
 */
public class Location extends BaseEntity
{
    // DATA MEMBERS
    private static final long serialVersionUID = -1910473588189446570L;

    private String name;

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private String state;

    private String zip;

    private Customer customer;

    private Set services;

    private Collection notes;

    private String po;

    private boolean isBlanketPO;

    private boolean isUseCustomerAddress;

    private boolean isUseCustomerContact;

    private String contactFirstName;

    private String contactLastName;

    private String contactPhoneNumber;

    private String contactPhoneExtension;

    private String contactTitle;

    private String contactEmailAddress;

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
     * Return the truncated customer name.
     */
    public String getAddress1Abbreviation()
    {
        if (address1 == null) {
            return null;
        } else if (address1.length() < 20) {
            return address1;
        } else {
            return address1.substring(0, 19) + "...";
        }
    }

    /**
     * @return the contactEmailAddress
     */
    public String getContactEmailAddress()
    {
        return contactEmailAddress;
    }

    /**
     * @param contactEmailAddress
     *            the contactEmailAddress to set
     */
    public void setContactEmailAddress(String contactEmailAddress)
    {
        this.contactEmailAddress = contactEmailAddress;
    }

    /**
     * @return the contactFirstName
     */
    public String getContactFirstName()
    {
        return contactFirstName;
    }

    /**
     * @param contactFirstName
     *            the contactFirstName to set
     */
    public void setContactFirstName(String contactFirstName)
    {
        this.contactFirstName = contactFirstName;
    }

    /**
     * @return the contactLastName
     */
    public String getContactLastName()
    {
        return contactLastName;
    }

    /**
     * @param contactLastName
     *            the contactLastName to set
     */
    public void setContactLastName(String contactLastName)
    {
        this.contactLastName = contactLastName;
    }

    /**
     * @return the contactPhoneNumber
     */
    public String getContactPhoneNumber()
    {
        return contactPhoneNumber;
    }

    /**
     * @param contactPhoneNumber
     *            the contactPhoneNumber to set
     */
    public void setContactPhoneNumber(String contactPhoneNumber)
    {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    /**
     * @return the contactTitle
     */
    public String getContactTitle()
    {
        return contactTitle;
    }

    /**
     * @param contactTitle
     *            the contactTitle to set
     */
    public void setContactTitle(String contactTitle)
    {
        this.contactTitle = contactTitle;
    }

    /**
     * @return the isUseCustomerContact
     */
    public boolean getIsUseCustomerContact()
    {
        return isUseCustomerContact;
    }

    /**
     * @param isUseCustomerContact
     *            the isUseCustomerContact to set
     */
    public void setIsUseCustomerContact(boolean isUseCustomerContact)
    {
        this.isUseCustomerContact = isUseCustomerContact;
    }

    /**
     * @return the isUseCustomerContact
     */
    public boolean isUseCustomerContact()
    {
        return isUseCustomerContact;
    }

    /**
     * @param isUseCustomerContact
     *            the isUseCustomerContact to set
     */
    public void setUseCustomerContact(boolean isUseCustomerContact)
    {
        this.isUseCustomerContact = isUseCustomerContact;
    }

    /**
     * @return the isUseCustomerAddress
     */
    public boolean isUseCustomerAddress()
    {
        return isUseCustomerAddress;
    }

    /**
     * @param isUseCustomerAddress
     *            the isUseCustomerAddress to set
     */
    public void setUseCustomerAddress(boolean isUseCustomerAddress)
    {
        this.isUseCustomerAddress = isUseCustomerAddress;
    }

    /**
     * @return the isUseCustomerAddress
     */
    public boolean getIsUseCustomerAddress()
    {
        return isUseCustomerAddress;
    }

    /**
     * @param isUseCustomerAddress
     *            the isUseCustomerAddress to set
     */
    public void setIsUseCustomerAddress(boolean isUseCustomerAddress)
    {
        this.isUseCustomerAddress = isUseCustomerAddress;
    }

    /**
     * @return the isBlanketPO
     */
    public boolean isBlanketPO()
    {
        return isBlanketPO;
    }

    /**
     * @param isBlanketPO
     *            the isBlanketPO to set
     */
    public void setBlanketPO(boolean isBlanketPo)
    {
        this.isBlanketPO = isBlanketPo;
    }

    /**
     * @return the isBlanketPO
     */
    public boolean getIsBlanketPO()
    {
        return isBlanketPO;
    }

    /**
     * @param isBlanketPO
     *            the isBlanketPO to set
     */
    public void setIsBlanketPO(boolean isBlanketPo)
    {
        this.isBlanketPO = isBlanketPo;
    }

    /**
     * @return the po
     */
    public String getPo()
    {
        return po;
    }

    /**
     * @param po
     *            the po to set
     */
    public void setPo(String po)
    {
        this.po = po;
    }

    /**
     * Remove the customer association
     */
    public void removeCustomer()
    {
        customer = null;
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
     * @return Returns the customer.
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * @param customer
     *            The customer to set.
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
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
     * @return Returns the services.
     */
    public Set getServices()
    {
        return services;
    }

    /**
     * Get a specific service.
     */
    public Service getService(ServiceType serviceType)
    {
        Set theServices = getServices();
        if (theServices == null) {
            return null;
        }
        Iterator iter = theServices.iterator();
        while (iter.hasNext()) {
            Service s = (Service) iter.next();
            if (s.getServiceType().equals(serviceType)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Add a specific service.
     */
    public void addService(Service service)
    {
        if (getServices() == null) {
            services = new HashSet();
        }
        service.setLocation(this);
        services.add(service);
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
    public void addNote(LocationNote note)
    {
        if (note == null) {
            throw new IllegalArgumentException("Null note in addNote()!");
        }
        note.setLocation(this);
        notes.add(note);
    }

    /**
     * @param services
     *            the services to set
     */
    public void setServices(Set services)
    {
        this.services = services;
    }

    /**
     * @return the contactPhoneExtension
     */
    public String getContactPhoneExtension()
    {
        return contactPhoneExtension;
    }

    /**
     * @param contactPhoneExtension
     *            the contactPhoneExtension to set
     */
    public void setContactPhoneExtension(String contactPhoneExtension)
    {
        this.contactPhoneExtension = contactPhoneExtension;
    }
}

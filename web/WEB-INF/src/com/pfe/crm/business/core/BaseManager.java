package com.pfe.crm.business.core;

import org.hibernate.Session;

/**
 * BaseManager.java
 * 
 * Base manager from which all other managers descend.
 * 
 * @author Ben Northrop May 12, 2007
 * 
 */
public class BaseManager
{
    // DATA MEMBER
    private Session session;

    // CONSTRUCTOR
    public BaseManager(Session session)
    {
        this.session = session;
    }

}

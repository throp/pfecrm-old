package com.pfe.crm.core.util;

import org.apache.log4j.Category;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.pfe.crm.domain.entity.ActionLog;
import com.pfe.crm.domain.entity.Chemical;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.CustomerNote;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.InventoryItem;
import com.pfe.crm.domain.entity.Job;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.LocationNote;
import com.pfe.crm.domain.entity.Manufacturer;
import com.pfe.crm.domain.entity.Office;
import com.pfe.crm.domain.entity.Role;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.entity.ServiceCall;
import com.pfe.crm.domain.entity.Weight;

/**
 * HibernateUtilities
 * 
 * A set of utility methods for Hibernate.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Jun 22, 2006
 */
public class HibernateUtilities
{
    // DATA MEMBERS
    /**
     * The single instance of hibernate configuration
     */
    private static Configuration config;

    /**
     * The single instance of hibernate SessionFactory
     */
    private static org.hibernate.SessionFactory sessionFactory;

    // CONSTANTS
    private final static String CLASS_NAME = new HibernateUtilities()
            .getClass().getName();

    private final static Category LOG = Category.getInstance(CLASS_NAME);

    // METHODS
    /**
     * Return a valid session, using the given sessionFactory and Configuration.
     */
    public static Session getSession()
    {
        try {
            if (config == null) {
                initConfiguration();
            }
            return sessionFactory.openSession();
        } catch (HibernateException he) {
            LOG.error("HibernateException when getting session! ", he);
            throw he;
        }
    }

    /**
     * @throws MappingException
     * @throws HibernateException
     * @throws IllegalStateException
     */
    private static void initConfiguration() throws MappingException,
            HibernateException, IllegalStateException
    {
        config = new Configuration();
        try {
            config.addClass(Customer.class);
            config.addClass(Location.class);
            config.addClass(Employee.class);
            config.addClass(Service.class);
            config.addClass(InventoryItem.class);
            config.addClass(Manufacturer.class);
            config.addClass(Chemical.class);
            config.addClass(Weight.class);
            config.addClass(CustomerNote.class);
            config.addClass(Role.class);
            config.addClass(LocationNote.class);
            config.addClass(Office.class);
            config.addClass(Job.class); 
            config.addClass(ServiceCall.class);
            config.addClass(ActionLog.class);
        } catch (MappingException me) {
            LOG.error("MappingException: " + me);
            throw me;
        }
        sessionFactory = config.buildSessionFactory();
        if (sessionFactory == null) {
            throw new IllegalStateException(
                    "SessionFactory not returned by Hibernate config!");
        }
    }

    /**
     * Close and flush the session.
     */
    public static void closeSession(Session session)
    {
        if (session == null) {
            LOG
                    .warn("session is null in closeSession().  Could indicate prior error.");
            return;
        }
        try {
            session.flush();
            session.close();
        } catch (HibernateException he) {
            LOG.error("HibernateException: " + he);
            throw he;
        }
    }
}

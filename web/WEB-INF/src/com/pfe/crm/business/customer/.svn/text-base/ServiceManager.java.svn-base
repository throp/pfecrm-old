package com.pfe.crm.business.customer;

import org.apache.log4j.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.domain.entity.Service;

/**
 * ServiceManager.java
 * 
 * Some common functionality for managing services.
 * 
 * @author Ben Northrop Dec 8, 2006
 * 
 */
public class ServiceManager
{
    // DATA MEMBERS
    private Service service;

    private Session session;

    private final Category LOG = Category.getInstance(ServiceManager.class);

    // CONSTRUCTORS
    /**
     * Default constructor.
     */
    public ServiceManager(Service service, Session session)
    {
        this.service = service;
        this.session = session;
    }

    /**
     * Update the number of inventory items for a given service.
     */
    public void updateNumberInventoryItems()
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" select count(i) ");
        hql.append(" from InventoryItem i ");
        hql.append(" join i.service s ");
        hql.append(" where s.id = :serviceId ");
        Query query = session.createQuery(hql.toString());
        query.setParameter("serviceId", service.getId());
        Integer numInventoryItems = (Integer) query.uniqueResult();
        LOG.debug(numInventoryItems + " for service "
                + service.getServiceType().getName());
        service.setNumInventoryItems(numInventoryItems.intValue());
    }
}

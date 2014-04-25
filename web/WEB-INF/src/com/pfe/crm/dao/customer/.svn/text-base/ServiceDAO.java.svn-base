package com.pfe.crm.dao.customer;

import org.hibernate.Session;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Service;

/**
 * ServiceDAO.java
 * 
 * All CRUD methods for a service entity.
 * 
 * @author Ben Northrop Jun 26, 2007
 * 
 */
public class ServiceDAO extends BaseDAO<Service>
{

    /**
     * @param session
     */
    public ServiceDAO(Session session)
    {
        super(session);
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Service.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Service";
    }

}

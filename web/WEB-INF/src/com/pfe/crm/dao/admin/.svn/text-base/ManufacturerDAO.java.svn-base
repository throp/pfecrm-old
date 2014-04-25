package com.pfe.crm.dao.admin;

import org.hibernate.Session;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Manufacturer;

/**
 * ManufacturerDAO.java
 * 
 * All data access methods related to the manufacturer.
 * 
 * @author Ben Northrop
 * Jun 6, 2007
 *
 */
public class ManufacturerDAO extends BaseDAO<Manufacturer>
{

    /**
     * @param session
     */
    public ManufacturerDAO(Session session)
    {
        super(session);
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Manufacturer.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Manufacturer";
    }

}

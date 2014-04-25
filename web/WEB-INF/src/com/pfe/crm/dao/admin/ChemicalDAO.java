package com.pfe.crm.dao.admin;

import org.hibernate.Session;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Chemical;

/**
 * ChemicalDAO.java
 * 
 * 
 * 
 * @author Ben Northrop
 * Jun 6, 2007
 *
 */
public class ChemicalDAO extends BaseDAO<Chemical>
{

    /**
     * @param session
     */
    public ChemicalDAO(Session session)
    {
        super(session);
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Chemical.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Chemical";
    }

}

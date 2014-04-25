package com.pfe.crm.dao.admin;

import org.hibernate.Session;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Weight;

/**
 * WeightDAO.java
 * 
 * All HQL statements related to the Weight entity.
 * 
 * @author Ben Northrop May 20, 2007
 */
public class WeightDAO extends BaseDAO<Weight>
{
    /**
     * Default constructor - passing hibernate session.
     */
    public WeightDAO(Session session)
    {
        super(session);
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Weight.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Weight";
    }
    
}

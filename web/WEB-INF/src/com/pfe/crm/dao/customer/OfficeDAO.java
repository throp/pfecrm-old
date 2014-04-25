/*
 * Copyright (c) 2007 Vocollect, Inc.
 * Pittsburgh, PA 15235
 * All rights reserved.
 *
 * This source code contains confidential information that is owned by
 * Vocollect, Inc. and may not be copied, disclosed or otherwise used without
 * the express written consent of Vocollect, Inc.
 */

package com.pfe.crm.dao.customer;

import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Office;

import org.hibernate.Session;

/**
 * All CRUD functionality for offices.
 * 
 * @author bnorthrop
 */
public class OfficeDAO extends BaseDAO<Office>
{

    /**
     * Constructor.
     * 
     * @param session
     */
    public OfficeDAO(Session session)
    {
        super(session);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Office.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Office";
    }

}

/*
 * Copyright (c) 2007 Vocollect, Inc.
 * Pittsburgh, PA 15235
 * All rights reserved.
 *
 * This source code contains confidential information that is owned by
 * Vocollect, Inc. and may not be copied, disclosed or otherwise used without
 * the express written consent of Vocollect, Inc.
 */

package com.pfe.crm.core.dao;

/**
 * A standard DAOException indicating an error in a DAO.
 * 
 * @author bnorthrop
 */
public class DAOException extends RuntimeException
{
    private static final long serialVersionUID = 2738616465709957667L;

    /**
     * Default constructor.
     */
    public DAOException(String message)
    {
        super(message);
    }
}

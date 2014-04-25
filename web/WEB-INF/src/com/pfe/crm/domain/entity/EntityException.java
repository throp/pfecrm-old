package com.pfe.crm.domain.entity;

/**
 * EntityException.java
 * 
 * A customer exception used to indicate a problem in 
 * a basic entity.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Jun 20, 2006
 */
public class EntityException extends RuntimeException
{
	/**
	 * Random SUID
	 */
	private static final long serialVersionUID = -1685601913375428537L;

	
	// CONSTRUCTOR
	/**
	 * Default constructor.
	 */
	public EntityException(final String msg, final Exception cause)
	{
		super(msg, cause);
	}

}

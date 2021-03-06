package com.pfe.crm.domain.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * EmployeeTypeUserType.java
 * 
 * The glue between the EmployeeType and Hibernate
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Jul 17, 2006
 */
public class EmployeeTypeUserType implements UserType
{
	// DATA MEMBERS
	private static final int[] SQL_TYPES = {Types.INTEGER};
	
	
	// OVERRIDDEN METHODS
	/**
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	public int[] sqlTypes()
	{
		return SQL_TYPES;
	}

	/**
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	public Class returnedClass()
	{
		return EmployeeType.class;
	}

	/**
	 * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
	 */
	public boolean equals(Object x, Object y) throws HibernateException
	{
		return x == y;
	}


	/**
	 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
	 */
	public int hashCode(Object value) throws HibernateException
	{
		return value.hashCode();
	}

	/**
	 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
	 */
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException
	{
		return EmployeeType.getInstance(rs.getInt(names[0]));
	}

	/**
	 * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
	 */
	public void nullSafeSet(PreparedStatement ps, Object value, int index) throws HibernateException, SQLException
	{
		if(value == null) { 
			ps.setNull(index, Types.INTEGER);
		} else { 
			ps.setInt(index, ((EmployeeType) value).getId());
		}

	}

	/**
	 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
	 */
	public Object deepCopy(Object value) throws HibernateException
	{
		return value;
	}

	/**
	 * @see org.hibernate.usertype.UserType#isMutable()
	 */
	public boolean isMutable()
	{
		return false;
	}

	/**
	 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
	 */
	public Serializable disassemble(Object value) throws HibernateException
	{
		return (Serializable) value;
	}

	/**
	 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
	 */
	public Object assemble(Serializable cached, Object owner) throws HibernateException
	{
		return cached;
	}

	/**
	 * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public Object replace(Object original, Object target, Object owner) throws HibernateException
	{
		return original;
	}

}

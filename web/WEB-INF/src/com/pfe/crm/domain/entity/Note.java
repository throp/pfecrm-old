package com.pfe.crm.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Note.java
 * 
 * A generic note that can be associated with different types 
 * of entities (e.g. customer, location, etc.).
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Sep 5, 2006
 */
public abstract class Note implements Serializable
{
	// DATA MEMBERS
	private int id;
	private String note;
	private Employee employee;
	private Date enteredDate = new Date();
	
	// ACCESSORS AND MUTATORS
	/**
	 * @return Returns the enteredDate.
	 */
	public Date getEnteredDate()
	{
		return enteredDate;
	}
	/**
	 * @param enteredDate The enteredDate to set.
	 */
	public void setEnteredDate(Date date)
	{
		this.enteredDate = date;
	}
	/**
	 * @return Returns the employee.
	 */
	public Employee getEmployee()
	{
		return employee;
	}
	/**
	 * @param employee The employee to set.
	 */
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	/**
	 * @return Returns the note.
	 */
	public String getNote()
	{
		return note;
	}
	/**
	 * @param note The note to set.
	 */
	public void setNote(String note)
	{
		this.note = note;
	}
	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
}

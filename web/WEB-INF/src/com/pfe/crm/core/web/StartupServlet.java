package com.pfe.crm.core.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Category;

/**
 * StartupServlet.java
 * 
 * A servlet used to initialize the CRM web application.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Jun 27, 2006
 */
public class StartupServlet extends HttpServlet
{
	// DATA MEMBERS
	private Category LOG = Category.getInstance(BaseAction.class);
	private static final long serialVersionUID = 8748156111659816219L;
	
	// METHODS
	/**
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		LOG.debug("Initializing CRM web application...");
		ServletContext context = config.getServletContext();
		ListManager listManager = ListManager.init(context);
		listManager.refreshAllLists();
	}


}

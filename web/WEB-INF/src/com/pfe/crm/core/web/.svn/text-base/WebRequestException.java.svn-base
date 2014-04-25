package com.pfe.crm.core.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * Indicates that the web request was in error (for example a missing request
 * parameter was encountered.
 * 
 * @author Ben Northrop
 * Date: October 21st, 2002
 */
public class WebRequestException extends RuntimeException 
{
	// CONSTANTS
	/**
	 * Determines if a de-serialized file is compatible with this class.
	 */
	
	private static final long serialVersionUID = 1L;
	
	// DATA MEMBERS
	/**
	 * The HttpServletRequest instance that contains a map of parameters.
	 */
	private HttpServletRequest request;
	
	
	// CONSTRUCTORS
	/**
	 * Constructor for WebRequestException
	 */
	public WebRequestException(String inMessage, Exception inPrevious) 
	{
		super(inMessage, inPrevious);
	}

	

	// METHODS
	/**
	 * Overridden toString() used to print out the HttpServletRequest
	 * parameters.
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		if(request != null) {	
			sb.append("\n  Request Parameters: ");
			Enumeration parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()) {
				String parameterName = (String) parameterNames.nextElement();
				sb.append("\n    -" + parameterName + ": " + request.getParameter(parameterName));
			}
		}
		return sb.toString();		
	}
	
	/**
	 * Gets the request
	 * @return Returns a HttpServletRequest
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * Sets the request
	 * @param request The request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}


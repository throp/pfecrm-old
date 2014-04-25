package com.pfe.crm.core.web.message;

import javax.servlet.http.HttpServletRequest;

import com.ndg.core.web.message.Message;
import com.ndg.core.web.message.MessageManager;
import com.ndg.core.web.message.MessageType;

/**
 * MessageUtilities.java
 * 
 * A utility class (facade) for dealing with messages.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben
 * Date: Aug 16, 2006
 */
public class MessageUtilities
{
	/**
	 * Add a confirmation message.
	 */
	public static void addConfirmationMessage(HttpServletRequest request, String str)
	{
		MessageManager messageManager = MessageManager.getInstance(request.getSession());
		Message message = new Message(MessageType.CONFIRMATION, str);
		messageManager.addMessage(message);		
	}
	
	/**
	 * Add an error message.
	 */
	public static void addErrorMessage(HttpServletRequest request, String str)
	{
		MessageManager messageManager = MessageManager.getInstance(request.getSession());
		Message message = new Message(MessageType.ERROR, str);
		messageManager.addMessage(message);		
	}	
	
	/**
	 * Add an error message.
	 */
	public static void addInformationMessage(HttpServletRequest request, String str)
	{
		MessageManager messageManager = MessageManager.getInstance(request.getSession());
		Message message = new Message(MessageType.INFORMATION, str);
		messageManager.addMessage(message);		
	}		
}

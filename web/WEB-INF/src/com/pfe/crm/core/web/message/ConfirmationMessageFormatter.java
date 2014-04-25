package com.pfe.crm.core.web.message;


/**
 * ConfirmationMessageFormatter<br>
 * 
 * The message formatter for displaying Confirmation messages to the user
 * for the CCO application.<br>
 * 
 * Copyright (c) Straightline 2003.  All Rights Reserved.
 * 
 *  @author Ben Northrop
 */
public class ConfirmationMessageFormatter extends BaseMessageFormatter 
{
	protected String getColor() { return "#009999"; }
	
	protected String getImgSrc() { return "/CRM/images/message_confirmation.gif"; }
}

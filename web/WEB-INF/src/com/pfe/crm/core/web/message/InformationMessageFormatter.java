package com.pfe.crm.core.web.message;


/**
 * InformationMessageFormatter<br>
 * 
 * The message formatter for displaying Information messages to the user
 * for the CCO application.<br>
 * 
 * Copyright (c) NDG 2003.  All Rights Reserved.
 * 
 *  @author Ben Northrop
 */
public class InformationMessageFormatter extends BaseMessageFormatter 
{
	protected String getColor() { return "#ff9933"; }
	
	protected String getImgSrc() { return "/CRM/images/message_information.gif"; }
}

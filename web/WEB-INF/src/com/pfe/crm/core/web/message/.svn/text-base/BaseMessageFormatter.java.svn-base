package com.pfe.crm.core.web.message;

import java.util.Collection;
import java.util.Iterator;

import com.ndg.core.util.StringUtilities;
import com.ndg.core.web.message.Message;
import com.ndg.core.web.message.MessageFormatter;

/**
 * CCOMessageFormatter<br>
 * 
 * An abstract MessageFormatter which generates a string representation of
 * Messages to be displayed to a user. Instances of this class need to define
 * the color and image (optional).<br>
 * 
 * Copyright (c) Straightline 2003. All Rights Reserved.
 * 
 * @author Ben Northrop, June 19th 2003
 */
public abstract class BaseMessageFormatter implements MessageFormatter
{
	// ABSTRACT METHODS
	/**
	 * Get the color used for the border color and title.
	 */
	protected abstract String getColor();

	/**
	 * Get the src of the image to be used for the specific message type.
	 */
	protected abstract String getImgSrc();

	// OVERRIDDEN METHODS
	/**
	 * Generate a string representation of an error message for the user.
	 * 
	 * @see MessageFormatter#format(Message)
	 */
	public String format(Message message)
	{
		StringBuffer htmlMessage = new StringBuffer();

		htmlMessage.append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		htmlMessage.append("  <tr height=\"5\"><td></td></tr>");
		if (!StringUtilities.isEmpty(message.getTitle())) {
			htmlMessage.append("  <tr>");
			htmlMessage.append("    <td class=\"boldtext\">");
			htmlMessage.append("      <font color=\"" + getColor() + "\"> ").append(
					message.getTitle()).append("</font>");
			htmlMessage.append("    </td>");
			htmlMessage.append("  </tr>");
		}
		htmlMessage.append("  <tr>");
		htmlMessage.append("    <td class=\"textsmall\">");
		htmlMessage.append("     ").append(message.getMessage());
		htmlMessage.append("    </td>");
		htmlMessage.append("  </tr>");
		htmlMessage.append("  <tr height=\"5\"><td></td></tr>");
		htmlMessage.append("</table>");

		return htmlMessage.toString();
	}

	/**
	 * Takes a Collection of Message objects and creates a String representation
	 * of it.
	 * 
	 * @param Collection
	 *            Message objects
	 */
	public String format(Collection messages)
	{
		StringBuffer out = new StringBuffer();

		if (messages == null || messages.isEmpty()) {
			return "";
		}

		out.append("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" bordercolor=\""
				+ getColor() + "\" bgcolor=\"#DCDCDC\" width=\"800\">");

		Iterator iter = messages.iterator();
		while (iter.hasNext()) {
			Message message = (Message) iter.next();
			out.append("  <tr>");
			out.append("    <td valign=\"top\">");
			out.append("      <table border=\"0\" cellspacing=\"1\" cellpadding=\"2\">");
			out.append("        <tr>");
			out.append("          <td rowspan=\"500\"><img src=\"" + getImgSrc() + "\"></td>");
			out.append("          <td>" + format(message) + "</td>");
			out.append("        </tr>");
			out.append("      </table>");
			out.append("    </td>");
			out.append("  </tr>");
		}

		out.append("</table><br>");
		return out.toString();
	}
}

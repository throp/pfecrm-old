<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
			<a href="/CRM/GoToAddLocationAction.do?customerId=<bean:write name="customer" property="id" />">Add Location</a>
			|
			<a href="/CRM/ViewLocationsAction.do?id=<bean:write name="customer" property="id" format="#" />">View All</a>
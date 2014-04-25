<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<table border="0">
	<tr>
		<td>
			Are you sure you want to delete the <a href="/CRM/ViewBillingAction.do?id=<bean:write name="id" />"><bean:write name="name"  /></a> customer and <i>all</i> related information?
		</td>
	</tr>
	<tr height="15"><td></td></tr>
	<tr>
		<td align="center">
			<form action="/CRM/DeleteCustomerAction.do" method="POST">
				<input type="hidden" name="id" value="<bean:write name="id" />">
				<input type="hidden" name="name" value="<bean:write name="name" />">
				<input type="submit" value="Yes">

			&nbsp;&nbsp;
			<input type="button" value="No" onClick="history.back()" />
			</form>			
		</td>
	</tr>
</table>
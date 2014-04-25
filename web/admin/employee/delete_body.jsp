<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<table border="0">
	<tr>
		<td>
			Are you sure you want to deactivate <a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="employee" property="id" />"><bean:write name="employee" property="name"  /></a>?
			&nbsp;Note: this will <i>not</i> remove him from the system.
		</td>
	</tr>
	<tr height="15"><td></td></tr>
	<tr>
		<td align="center">
			<form action="/CRM/DeleteEmployeeAction.do" method="POST">
				<input type="hidden" name="employeeId" value="<bean:write name="employee" property="id" />">
				<input type="submit" value="Yes">

			&nbsp;&nbsp;
			<input type="button" value="No" onClick="history.back()" />
			</form>			
		</td>
	</tr>
</table>
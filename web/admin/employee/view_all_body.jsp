<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>

<table cellspacing="0" class="data" align="center">
	<thead>
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Username</th>
		<th>Password</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<logic:iterate name="employees" id="employee">
	<tr height="22"
		<logic:equal name="employee" property="isActive" value="false">
			class="inactive"
		</logic:equal>				
		>
		<td>
			&nbsp;
			<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="employee" property="id" />"><bean:write name="employee" property="firstName" />
			&nbsp;
			<bean:write name="employee" property="lastName" /></a>
		</td>
		<td>			
			<bean:define name="employee" property="employeeType" id="employeeType" />
			<bean:write name="employeeType" property="description" />
		</td>
		<td>
			<bean:write name="employee" property="userName" />
		</td>
		<td>
			<logic:present name="employee" property="password" >
			******	
			</logic:present>
		</td>

		<td align="right">
			<logic:equal name="employee" property="isActive" value="false" >

			</logic:equal>				
			<logic:notEqual name="employee" property="isActive" value="false" >
				<a href="/CRM/GoToDeleteEmployeeAction.do?employeeId=<bean:write name="employee" property="id" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
			</logic:notEqual>		
		</td>
	</tr>
	</logic:iterate>
	</tbody>
	<tfoot>
	<tr height="1">
		<td colspan="6" ></td>
	</tr>
	</tfoot>
</table>

<br>


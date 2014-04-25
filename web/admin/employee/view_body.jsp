<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/admin/validation.js" ></script>
<form name="frmEmployee" action="/CRM/EditEmployeeAction.do" onSubmit="return validateEmployee();">
<input type="hidden" name="employeeId" value="<bean:write name="employee" property="id" />" />
<table cellspacing="2" cellpadding="2">
	<tr>
		<td>Name:</td>
		<td>
			<input type="text" name="firstName" value="<bean:write name="employee" property="firstName" />">
			&nbsp;&nbsp;
			<input type="text" name="lastName" value="<bean:write name="employee" property="lastName" />">
		</td>
	</tr>

	<tr>
		<td>Type:</td>
		<td>
			<select name="employeeType">
				<option></option>
				<bean:define name="employee" property="employeeType" id="type" />
				<bean:define name="type" property="description" id="description" />
				<logic:iterate name="employeeTypes" id="employeeType">
					<option value="<bean:write name="employeeType" property="id" format="#" />"
						<logic:equal name="description" value="<%= ((com.pfe.crm.domain.type.EmployeeType) employeeType).getDescription() %>" >
							selected
						</logic:equal>
					>
						<bean:write name="employeeType" property="description" />
					</option>
				</logic:iterate>
		</td>
	</tr>

	<tr>
		<td>Username:&nbsp;&nbsp;</td>
		<td>
			<logic:equal name="isCurrentUser" value="yes" >
				<input type="text" name="userName" value="<bean:write name="employee" property="userName" />"/>
			</logic:equal>
			<logic:equal name="isCurrentUser" value="no" >
				<bean:write name="employee" property="userName" />
			</logic:equal>			
		</td>
	</tr>
	<tr>
		<td>Password: </td>
		<td>
			<logic:equal name="isCurrentUser" value="yes" >
				<input type="text" name="password" value="<bean:write name="employee" property="password" />"/>
			</logic:equal>
			<logic:equal name="isCurrentUser" value="no" >
				******
			</logic:equal>
		</td>
	</tr>

	<tr>
		<td></td>
		<td><input type="submit" value="Save"</td>
	</tr>
</table>
</form>
<br>
<jsp:include page="link_bar.jsp" flush="true" />
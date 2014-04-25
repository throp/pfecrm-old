<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/admin/validation.js" ></script>
<form name="frmEmployee" action="/CRM/AddEmployeeAction.do" onSubmit="return validateEmployee();">
<table cellspacing="2" cellpadding="2">
	<tr>
		<td>Name:</td>
		<td>
			<input type="text" name="firstName">
			&nbsp;&nbsp;
			<input type="text" name="lastName">
		</td>
	</tr>
	<tr>
		<td>Type:</td>
		<td>
			<select name="employeeType">
				<option></option>
				<logic:iterate name="employeeTypes" id="employeeType">
					<option value="<bean:write name="employeeType" property="id" format="#" />">
						<bean:write name="employeeType" property="description" />
					</option>
				</logic:iterate>
		</td>
	</tr>
	<tr>
		<td>Username: </td>
		<td><input type="text" name="userName" /> <i>(optional)</i></td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><input type="text" name="password" /> <i>(optional)</i></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Add"</td>
	</tr>
</table>
</form>
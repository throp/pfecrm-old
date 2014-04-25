<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<form action="/CRM/AddOfficeAction.do">
<table border="0" width="800">
	<tr>
		<td width="50">Name:&nbsp;</td>
		<td><input type="text" name="name" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Add" /></td>
	</tr>
</table>
</form>
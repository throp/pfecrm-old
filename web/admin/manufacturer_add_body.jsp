<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/admin/validation.js" ></script>
<form name="frmManufacturer" action="/CRM/AddManufacturerAction.do" onSubmit="return validateManufacturer();">
<table>
	<tr>
		<td>Name:</td>
		<td>
			<input type="text" name="name" size="50">
		</td>
	</tr>
	<tr>
		<td>Abbreviation:</td>
		<td>
			<input type="text" name="abbreviation" maxlength="7" size="10"> 
		</td>
	</tr>	
	<tr>
		<td>Fire Extinguisher:</td>
		<td>
			<input type="checkbox" name="isFireExtinguisher" >
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Add"</td>
	</tr>
</table>
</form>
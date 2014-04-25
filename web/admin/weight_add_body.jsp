<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script>
	function validateWeight()
	{
		if(isEmpty(frmWeight.pounds, 'Pounds', 'true')) {
			return false;
		}
		return true;
	
	}
</script>
<form name="frmWeight" action="/CRM/AddWeightAction.do" onSubmit="return validateWeight();">
<table>
	<tr>
		<td>Weight (lbs):</td>
		<td>
			<input type="text" name="pounds" size="50">
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Add"></td>
	</tr>
</table>
</form>
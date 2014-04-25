<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script>
	function validate()
	{
		if(isEmpty(frmBill.billedAmount, 'Amount', 'true')) { 
			return false;
		}
		return true;
	}
</script>
<form name="frmBill" action="/CRM/UpdateJobBillAction.do" onSubmit="return validate();">
	
<input type="hidden" name="jobId" value="<bean:write name="job" property="id" />" />
<table border="0">
	<tr>
		<td>Invoice Amount:&nbsp;&nbsp;</td>
		<td><input type="text" name="invoiceAmount" /></td>
	</tr>
	<tr>
		<td>Invoice Number:&nbsp;&nbsp;</td>
		<td><input type="text" name="invoiceNumber" /></td>
	</tr>	
	<tr>
		<td>Technician:&nbsp;</td>
		<td>						
			<select name="employeeId">
				<option value="">-</option>
				<logic:iterate name="employees" id="employee" >
					<bean:define name="employee" property="employeeType" id="employeeType" />
					<logic:equal name="employeeType" property="description" value="Road Technician">
					<option value="<bean:write name="employee" property="id" />"	>
						<bean:write name="employee" property="firstName" />
						<bean:write name="employee" property="lastName" />		
					</option>
					</logic:equal>
					<logic:equal name="employeeType" property="description" value="Shop Technician">
					<option value="<bean:write name="employee" property="id" />"	>
						<bean:write name="employee" property="firstName" />
						<bean:write name="employee" property="lastName" />		
					</option>
					</logic:equal>							
				</logic:iterate>
			</select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Bill" /></td>
	</tr>	
</table>
</form>

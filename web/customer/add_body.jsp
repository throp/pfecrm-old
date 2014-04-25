<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/customer/validation.js"></script>
<form action="/CRM/AddCustomerAction.do" name="frmBilling" onSubmit="return validateBilling();">
<table border="0" cellspacing="2" cellpadding="2" width="800">
	<tr>
		<td width="20" rowspan="100"></td>
		<td width="70">*Name:</td>
		<td width="400"><input type="text" name="name" size="50"></td>
		<td width="310"></td>
	</tr>
	<tr>
		<td>*Status:</td>
		<td>
			<select name="status">
			<option value=""></option>
			<logic:iterate name="customerStatuses" id="status">
				<option value="<bean:write name="status" property="id" format="#" />">
					<bean:write name="status" property="description" />
				</option>
			</logic:iterate>
			</select>
		</td>
	</tr>
	<tr>
		<td>*Office:</td>
		<td>
			<select name="officeId">
			<option value=""></option>
			<logic:iterate name="offices" id="office">
				<option value="<bean:write name="office" property="id" format="#" />">
					<bean:write name="office" property="name" />
				</option>
			</logic:iterate>
			</select>
		</td>
	</tr>	
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2" class=""><b>Billing Address</b></td>
	</tr>	
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>
	<tr>
		<td>*Street:</td>
		<td><input type="text" name="address1" size="50"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="address2" size="50"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="address3" size="50"></td>
	</tr>		
	<tr>
		<td>*City:</td>
		<td><input type="text" name="city">&nbsp;&nbsp;*State:&nbsp;<input type="text" size="3" name="state">&nbsp;&nbsp;*Zip:&nbsp;<input type="text" size="5" name="zip"></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2"><b>Primary Contact</b></td>
	</tr>
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>	
	<tr>
		<td>Name:</td>
		<td><input type="text" name="primaryContactFirstName" >&nbsp;&nbsp;<input type="text" name="primaryContactLastName" ></td>
	</tr>	
	<tr>
		<td>Title:</td>
		<td><input type="text" name="primaryContactTitle"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td>
			<input type="text" name="primaryContactPhoneNumber">
			&nbsp;ext:
			<input type="text" name="primaryContactPhoneExtension" size="4" maxlength="4">
		</td>
	</tr>	
	<tr>
		<td>Email:</td>
		<td><input type="text" name="primaryContactEmailAddress" size="50"></td>
	</tr>		
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2" ><b>Secondary Contact</b></td>
	</tr>
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>	
	<tr>
		<td>Name:</td>
		<td><input type="text" name="secondaryContactFirstName" >&nbsp;&nbsp;<input type="text" name="secondaryContactLastName" ></td>
	</tr>	
	<tr>
		<td>Title:</td>
		<td><input type="text" name="secondaryContactTitle"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td>
			<input type="text" name="secondaryContactPhoneNumber">
			&nbsp;ext:
			<input type="text" name="secondaryContactPhoneExtension" size="4" maxlength="4">
		</td>
	</tr>	
	<tr>
		<td>Email:</td>
		<td><input type="text" name="secondaryContactEmailAddress" size="50"></td>
	</tr>		
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Fax:</td>
		<td><input type="text" name="faxNumber"></td>
	</tr>		
	<tr>
		<td>Blanket PO:</td>
		<td><input type="text" name="blanketPO"></td>
	</tr>

	<tr>
		<td></td>
		<td>
			<input type="submit" value="Submit" >
			&nbsp;
			<input type="reset"></td>
	</tr>		
</table>
</form>
<script language="javascript">
	frmBilling.name.focus();
	frmBilling.name.select();
</script>
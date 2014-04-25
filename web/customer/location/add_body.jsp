<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>
<jsp:include page="top.jsp">
	<jsp:param name="title" value="Add Location" />
</jsp:include>
<script>
	var isBlanketPO = false;
	var isUseCustomerAddress = false;
	var isUseCustomerContact = false;
	var blanketPO = "<bean:write name="customer" property="blanketPO" />";
	var customerAddress1 = "<bean:write name="customer" property="address1" />";
	var customerAddress2 = "<bean:write name="customer" property="address2" />";
	var customerAddress3 = "<bean:write name="customer" property="address3" />";
	var customerCity = "<bean:write name="customer" property="city" />";
	var customerState = "<bean:write name="customer" property="state" />";
	var customerZip = "<bean:write name="customer" property="zip" />";
	var locationAddress1 = "";
	var locationAddress2 = "";
	var locationAddress3 = "";
	var locationCity = "";
	var locationState = "";
	var locationZip = "";	
	var customerContactFirstName = "<bean:write name="customer" property="primaryContactFirstName" />";
	var customerContactLastName = "<bean:write name="customer" property="primaryContactLastName" />";
	var customerContactTitle = "<bean:write name="customer" property="primaryContactTitle" />";
	var customerContactPhoneNumber = "<bean:write name="customer" property="primaryContactPhoneNumber" />";
	var customerContactPhoneExtension = "<bean:write name="customer" property="primaryContactPhoneExtension" />";
	var customerContactEmailAddress = "<bean:write name="customer" property="primaryContactEmailAddress" />";
	var locationContactFirstName = "";
	var locationContactLastName = "";
	var locationContactTitle = "";
	var locationContactPhoneNumber = "";
	var locationContactPhoneExtension = "";
	var locationContactEmailAddress = "";	
</script>
<script language="javascript" src="/CRM/customer/location/location.js"></script>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/customer/validation.js"></script>
	<form name="frmLocation" action="/CRM/AddLocationAction.do" onSubmit="return validateLocation();" method="POST">
		<input type="hidden" name="customerId" value="<bean:write name="customer" property="id" />" />
	<table border="0" cellspacing="2" cellpadding="2" width="700" >

					<tr>
						<td width="20" rowspan="100"></td>
						<td width="200">*Name:&nbsp;</td>
						<td width="400"><input name="name" type="text" size="50"></td>
						<td width="270"></td>						
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" class=""><b>Address</b></td>
					</tr>	
					<tr height="1">
						<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
					</tr>					
					<tr>
						<td><i>use customer address</i>:&nbsp; </td> 
						<td><input type="checkbox" name="isUseCustomerAddress" value="yes" onClick="toggleAddress()"/></td>
					</tr>
					<tr>
						<td>*Address:&nbsp;</td>
						<td colspan="4"><input name="address1" type="text" size="50" ></td>
					</tr>		
					<tr>
						<td></td>
						<td colspan="4"><input name="address2" type="text" size="50" ></td>
					</tr>		
					<tr>
						<td></td>
						<td colspan="4"><input name="address3" type="text" size="50" ></td>
					</tr>												
					<tr>
						<td>*City:</td>
						<td><input name="city" type="text" >
						&nbsp;&nbsp;&nbsp;
						*State:&nbsp;<input name="state" type="text" size="2" >&nbsp;&nbsp;*Zip:&nbsp;<input name="zip" type="text" size="5" ></td>
					</tr>		
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" class=""><b>Contact</b></td>
					</tr>	
					<tr height="1">
						<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
					</tr>						
					<tr>
						<td><i>use customer contact</i>:</td>
						<td>
							<input type="checkbox" name="isUseCustomerContact" value="yes" onClick="toggleContact();" />
						</td>
					</tr>			
					<tr>
						<td>Name:</td>
						<td>
							<input type="text" name="contactFirstName">&nbsp;
							<input type="text" name="contactLastName">
						</td>
					</tr>
					<tr>
						<td>Title:</td>
						<td>
							<input type="text" name="contactTitle" />
						</td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td>
							<input type="text" name="contactPhoneNumber" />
							&nbsp;ext:&nbsp;
							<input type="text" name="contactPhoneExtension" maxlength="4" size="4"/>
						</td>
					</tr>		
					<tr>
						<td>Email Address:</td>
						<td>
							<input type="text" name="contactEmailAddress" size="50" />
						</td>
					</tr>										

					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" class=""><b>Billing</b></td>
					</tr>	
					<tr height="1">
						<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
					</tr>	
					<tr>
						<td>PO:&nbsp;</td>
						<td>
							<input type="text" name="po" />
							&nbsp;&nbsp;
							(<i>or use blanket po</i>: <input type="checkbox" name="isBlanketPO" value="yes" onClick="toggleBlanketPo();"/>)
						</td>
					</tr>					

					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="1" align="center">
						<td><input type="submit" value="Add Location"></td>
					</tr>					
	</table>
	</form>
	<br>
<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />
<script language="javascript">
	frmLocation.name.focus();
	frmLocation.name.select();
</script>
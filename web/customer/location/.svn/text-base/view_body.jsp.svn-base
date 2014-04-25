<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>
<jsp:include page="top.jsp" >
	<jsp:param name="title" value="Name" />
</jsp:include>

<script>
	var isBlanketPO = <bean:write name="location" property="isBlanketPO" />;
	var isUseCustomerAddress = <bean:write name="location" property="isUseCustomerAddress" />;
	var isUseCustomerContact = <bean:write name="location" property="isUseCustomerContact" />;
	var blanketPO = "<bean:write name="customer" property="blanketPO" />";
	var customerAddress1 = "<bean:write name="customer" property="address1" />";
	var customerAddress2 = "<bean:write name="customer" property="address2" />";
	var customerAddress3 = "<bean:write name="customer" property="address3" />";
	var customerCity = "<bean:write name="customer" property="city" />";
	var customerState = "<bean:write name="customer" property="state" />";
	var customerZip = "<bean:write name="customer" property="zip" />";
	<logic:equal name="location" property="isUseCustomerAddress" value="true">
		var locationAddress1 = "";
		var locationAddress2 = "";
		var locationAddress3 = "";
		var locationCity = "";
		var locationState = "";
		var locationZip = "";	
	</logic:equal>
	<logic:notEqual name="location" property="isUseCustomerAddress" value="true">
		var locationAddress1 = "<bean:write name="location" property="address1" />";
		var locationAddress2 = "<bean:write name="location" property="address2" />";
		var locationAddress3 = "<bean:write name="location" property="address3" />";
		var locationCity = "<bean:write name="location" property="city" />";
		var locationState = "<bean:write name="location" property="state" />";
		var locationZip = "<bean:write name="location" property="zip" />";	
	</logic:notEqual>
	var customerContactFirstName = "<bean:write name="customer" property="primaryContactFirstName" />";
	var customerContactLastName = "<bean:write name="customer" property="primaryContactLastName" />";
	var customerContactTitle = "<bean:write name="customer" property="primaryContactTitle" />";
	var customerContactPhoneNumber = "<bean:write name="customer" property="primaryContactPhoneNumber" />";
	var customerContactPhoneExtension = "<bean:write name="customer" property="primaryContactPhoneExtension" />";
	var customerContactEmailAddress = "<bean:write name="customer" property="primaryContactEmailAddress" />";
	<logic:equal name="location" property="isUseCustomerContact" value="true" >
		var locationContactFirstName = "";
		var locationContactLastName = "";
		var locationContactTitle = "";
		var locationContactPhoneNumber = "";
		var locationContactPhoneExtension = "";
		var locationContactEmailAddress = "";			
	</logic:equal>
	<logic:equal name="location" property="isUseCustomerContact" value="false" >
		var locationContactFirstName = "<bean:write name="location" property="contactFirstName" />";
		var locationContactLastName = "<bean:write name="location" property="contactLastName" />";
		var locationContactTitle = "<bean:write name="location" property="contactTitle" />";
		var locationContactPhoneNumber = "<bean:write name="location" property="contactPhoneNumber" />";
		var locationContactPhoneExtension = "<bean:write name="location" property="contactPhoneExtension" />";
		var locationContactEmailAddress = "<bean:write name="location" property="contactEmailAddress" />";
	</logic:equal>	
</script>
<script language="javascript" src="/CRM/customer/location/location.js"></script>
<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/customer/validation.js"></script>
	<form name="frmLocation" action="/CRM/EditLocationAction.do" onSubmit="return validateLocation()" method="POST">
		<input type="hidden" name="id" value="<bean:write name="location" property="id" />" />
	<table border="0" cellspacing="2" cellpadding="2" width="550" >

					<tr>
						<td>Name:&nbsp;</td>
						<td colspan="4"><input name="name" type="text" size="50" value="<bean:write name="location" property="name" />"></td>

					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><i>use customer address</i>:&nbsp;</td>
						<td>
							<input type="checkbox" name="isUseCustomerAddress" value="yes" onClick="toggleAddress()"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								checked
							</logic:equal>
							>
						</td>
					</tr>
					<tr>
						<td>Address:&nbsp;</td>
						<td colspan="4">
							<input name="address1" type="text" size="50" value="<bean:write name="location" property="address1" />"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								disabled
							</logic:equal>								
								>
						</td>
					</tr>		
					<tr>
						<td></td>
						<td colspan="4">
							<input name="address2" type="text" size="50" value="<bean:write name="location" property="address2" />"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								disabled
							</logic:equal>								
								>
						</td>
					</tr>		
					<tr>
						<td></td>
						<td colspan="4">
							<input name="address3" type="text" size="50" value="<bean:write name="location" property="address3" />"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								disabled
							</logic:equal>								
								>
						</td>
					</tr>												
					<tr>
						<td>City:</td>
						<td>
						<input name="city" type="text" value="<bean:write name="location" property="city" />"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								disabled
							</logic:equal>								
								>
						&nbsp;&nbsp;State:
						&nbsp;
							<input name="state" type="text" size="2" value="<bean:write name="location" property="state" />"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								disabled
							</logic:equal>								
								>
							&nbsp;&nbsp;Zip:&nbsp;<input name="zip" type="text" size="5" value="<bean:write name="location" property="zip" />"
							<logic:equal name="location" property="isUseCustomerAddress" value="true" >
								disabled
							</logic:equal>								
								>
						</td>					
					</tr>

					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><i>use customer contact</i>:&nbsp;</td>
						<td>
							<input type="checkbox" name="isUseCustomerContact" value="yes" onClick="toggleContact()"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								checked
							</logic:equal>
							>
						</td>
					</tr>
					<tr>
						<td>Contact:</td>
						<td>
							<input type="text" name="contactFirstName" value="<bean:write name="location" property="contactFirstName" />"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								disabled
							</logic:equal>									
								>
							&nbsp;&nbsp;
							<input type="text" name="contactLastName" value="<bean:write name="location" property="contactLastName" />"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								disabled
							</logic:equal>									
								>
						</td>
					</tr>	
					<tr>
						<td>Title:</td>
						<td>
							<input type="text" name="contactTitle" value="<bean:write name="location" property="contactTitle" />"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								disabled
							</logic:equal>								
							>
						</td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td>
							<input type="text" name="contactPhoneNumber" value="<bean:write name="location" property="contactPhoneNumber" />"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								disabled
							</logic:equal>									
								>
							&nbsp;ext:&nbsp;
							<input type="text" name="contactPhoneExtension" value="<bean:write name="location" property="contactPhoneExtension" />" maxlength="4" size="4"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								disabled
							</logic:equal>									
								>
						</td>
					</tr>	
					<tr>
						<td>Email:</td>
						<td>
							<input type="text" name="contactEmailAddress" size="50" value="<bean:write name="location" property="contactEmailAddress" />"
							<logic:equal name="location" property="isUseCustomerContact" value="true" >
								disabled
							</logic:equal>											
								>
						</td>
					</tr>							

					<tr>
							<td>&nbsp;</td>
					</tr>
					<tr>
						<td>PO:</td>
						<td>
							<input type="text" name="po" value="<bean:write name="location" property="po" />" />
							&nbsp;&nbsp;
							(<i>or use blanket po</i>: <input type="checkbox" name="isBlanketPO" value="yes" onClick="toggleBlanketPo();"/>)
						</td>
					</tr>
					<tr>
						<td colspan="1" align="center">
						<td><input type="submit" value="Save"></td>
					</tr>					
	</table>
	</form> 
	<script>
		if(isBlanketPO) { 
			frmLocation.po.disabled = true;
			frmLocation.isBlanketPO.checked = true;
		}		
	</script>
	<br>
	<jsp:include page="link_bar.jsp" flush="true" />
	
	
<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />
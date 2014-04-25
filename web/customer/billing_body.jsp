<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/struts-html" prefix="html" %>

<script language="javascript" src="/CRM/js/validation.js" ></script>
<script language="javascript" src="/CRM/customer/validation.js"></script>

<jsp:include page="top.jsp" flush="true" >
	<jsp:param name="section" value="billing" />
</jsp:include>
<form action="/CRM/EditBillingAction.do" method="POST" name="frmBilling" onSubmit="return validateEditBilling();" >
<input type="hidden" name="id" value="<bean:write name="customer" property="id" format="#" />">
<table border="0" cellspacing="2" cellpadding="2" width="700">
	<tr>
		<td>Office:</td>
		<td>
				<bean:define name="customer" property="office" id="customerOffice" />
				<select name="officeId">
					<logic:iterate name="offices" id="office">
						<option value="<bean:write name="office" property="id" />"
						<logic:equal name="office" property="name" value="<%= ((com.pfe.crm.domain.entity.Office) customerOffice).getName() %>" >
							selected
						</logic:equal>
						>
							<bean:write name="office" property="name" />
						</option>
					</logic:iterate>
				</select>					
		</td>
	</tr>			
	<tr>
		<td>Customer Name:</td>
		<td><input type="text" name="name" value="<bean:write name="customer" property="name" />" size="50"></td>
	</tr>		
	<tr>
		<td width="140">Street:</td>
		<td><input type="text" name="address1" size="50" value="<bean:write name="customer" property="address1" />"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="address2" size="50" value="<bean:write name="customer" property="address2" />"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="text" name="address3" size="50" value="<bean:write name="customer" property="address3" />"></td>
	</tr>		
	<tr>
		<td>City:</td>
		<td>
			<input type="text" name="city" value="<bean:write name="customer" property="city" />">
			&nbsp;&nbsp;State:&nbsp;
			<input type="text" name="state" size="3" value="<bean:write name="customer" property="state" />">
			&nbsp;&nbsp;Zip:&nbsp;
			<input type="text" name="zip" size="5" value="<bean:write name="customer" property="zip" />">
		</td>
	</tr>
	
	<tr>
		<td>Fax:</td>
		<td><input type="text" name="faxNumber" value="<bean:write name="customer" property="faxNumber" />"></td>
	</tr>		
	<tr>
		<td>Blanket PO:</td>
		<td><input type="text" name="blanketPO" value="<bean:write name="customer" property="blanketPO" />"></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Primary Contact:</td>
		<td>
			<input type="text" name="primaryContactFirstName" value="<bean:write name="customer" property="primaryContactFirstName" />">
			&nbsp;&nbsp;
			<input type="text" name="primaryContactLastName" value="<bean:write name="customer" property="primaryContactLastName" />">
		</td>
	</tr>	
	<tr>
		<td>Title:</td>
		<td><input type="text" name="primaryContactTitle" value="<bean:write name="customer" property="primaryContactTitle" />"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td>
			<input type="text" name="primaryContactPhoneNumber" value="<bean:write name="customer" property="primaryContactPhoneNumber" />">
			&nbsp;ext:
			<input type="text" name="primaryContactPhoneExtension" value="<bean:write name="customer" property="primaryContactPhoneExtension" />" size="4" maxlength="4">
		</td>
	</tr>	
	<tr>
		<td>Email:</td>
		<td><input type="text" name="primaryContactEmailAddress" size="50" value="<bean:write name="customer" property="primaryContactEmailAddress" />"></td>
	</tr>		
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Secondary Contact:</td>
		<td>
			<input type="text" name="secondaryContactFirstName" value="<bean:write name="customer" property="secondaryContactFirstName" />">
			&nbsp;&nbsp;
			<input type="text" name="secondaryContactLastName" value="<bean:write name="customer" property="secondaryContactLastName" />" >
		</td>
	</tr>	
	<tr>
		<td>Title:</td>
		<td><input type="text" name="secondaryContactTitle" value="<bean:write name="customer" property="secondaryContactTitle" />"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td>
			<input type="text" name="secondaryContactPhoneNumber" value="<bean:write name="customer" property="secondaryContactPhoneNumber" />">
			&nbsp;ext:
			<input type="text" name="secondaryContactPhoneExtension" value="<bean:write name="customer" property="secondaryContactPhoneExtension" />" size="4" maxlength="4">
		</td>
	</tr>	
	<tr>
		<td>Email:</td>
		<td><input type="text" name="secondaryContactEmailAddress" size="50" value="<bean:write name="customer" property="secondaryContactEmailAddress" />"></td>
	</tr>		
	<tr>
		<td></td>
		<td><input type="submit" value="Save"</td>
	</tr>
</table><br>
</form>
<jsp:include page="customer_bottom.jsp" flush="true" />
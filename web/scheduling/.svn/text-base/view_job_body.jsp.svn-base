<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<bean:define name="job" property="service" id="service" />
<bean:define name="service" property="serviceType" id="serviceType" />
<bean:define name="service" property="location" id="location" />
<bean:define name="location" property="customer" id="customer" />
<bean:define name="job" property="roadTechnician" id="roadTechnician" />
<bean:define name="service" property="serviceMonth" id="serviceMonth" />
<bean:define name="service" property="serviceFrequency" id="serviceFrequency" />
<table border="0" cellspacing="2" cellpadding="2">
	<tr>
		<td width="150">&nbsp;</td>
		<td width="*"></td>
	</tr>
	<tr>
		<td colspan="2"><b>Job Information</b></td>
	</tr>	
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>	
	<tr>
		<td width="100">Customer:&nbsp;</td>
		<td><bean:write name="customer" property="name" /></td>
	</tr>
	<tr>
		<td>Location:&nbsp;</td>
		<td><bean:write name="location" property="name" /></td>
	</tr>
	<tr>
		<td>Service Type:&nbsp;</td>
		<td><bean:write name="serviceType" property="name" /></td>
	</tr>
	<tr>
		<td>Service Month:&nbsp;</td>
		<td><bean:write name="serviceMonth" property="name" /></td>
	</tr>
	<tr>
		<td>Service Frequency:&nbsp;</td>
		<td><bean:write name="serviceFrequency" property="description" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td colspan="2"><b>Service</b></td>
	</tr>
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>		
	<tr>
		<td>Road Tech:</td>
		<td>
			<bean:write name="roadTechnician" property="firstName" />
			<bean:write name="roadTechnician" property="lastName" />
		</td>
	</tr>	
	<tr>
		<td>Date in Road Tech Queue:&nbsp;</td>
		<td><bean:write name="job" property="dateInRoadTechQueue" format="MM/dd/yyyy" /></td>
	</tr>

	<tr><td>&nbsp;</td></tr>
	<tr>
		<td colspan="2"><b>Shop Work</b></td>
	</tr>
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>	
	<tr>
		<td>Shop Tech:&nbsp;</td>
		<td>
			<logic:present name="job" property="shopTechnician" >
				<bean:define name="job" property="shopTechnician" id="shopTechnician" />
				<bean:write name="shopTechnician" property="firstName" />
				<bean:write name="shopTechnician" property="lastName" />
			</logic:present>
		</td>
	<tr>
		<td>Date in Shop Tech Queue:&nbsp;</td>
		<td>
			<logic:present name="job" property="dateInShopTechQueue" >
				<bean:write name="job" property="dateInShopTechQueue" format="MM/dd/yyyy" /></td>
			</logic:present>
		</td>
	</tr>
	<tr>
		<td>Date Shop Work Complete:&nbsp;</td>
		<td>
			<logic:present name="job" property="dateReadyForReturn" >
				<bean:write name="job" property="dateReadyForReturn" format="MM/dd/yyyy" /></td>
			</logic:present>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td colspan="2"><b>Return</b></td>
	</tr>
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>		
	<tr>
		<td>Return Tech:&nbsp;</td>
		<td>
			<logic:present name="job" property="returnTechnician" >
				<bean:define name="job" property="returnTechnician" id="returnTechnician" />
				<bean:write name="returnTechnician" property="firstName" />
				<bean:write name="returnTechnician" property="lastName" />
			</logic:present>
		</td>
	</tr>		
	<tr>
		<td>Date in Return Tech Queue:&nbsp;</td>
		<td>
			<logic:present name="job" property="dateInReturnTechQueue" >
				<bean:write name="job" property="dateInReturnTechQueue" format="MM/dd/yyyy" /></td>
			</logic:present>
		</td>
	</tr>		
	<tr>
		<td>Date Returned:&nbsp;</td>
		<td>
			<logic:present name="job" property="dateCompleted" >
				<bean:write name="job" property="dateCompleted" format="MM/dd/yyyy" /></td>
			</logic:present>
		</td>
	</tr>			
	<tr>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td colspan="2"><b>Invoice</b></td>
	</tr>
	<tr height="1">
		<td colspan="2"><table width="440" border="0" cellspacing="0" cellpadding="0"><tr height="1"><td class="colorMain"></td></tr></table></td>
	</tr>			
	<tr>
		<td>Credited Tech:</td>
		<td>
			<logic:present name="job" property="creditedTechnician" >
				<bean:define name="job" property="creditedTechnician" id="creditedTechnician" />
				<bean:write name="creditedTechnician" property="firstName" />
				<bean:write name="creditedTechnician" property="lastName" />
			</logic:present>			
		</td>
	</tr>
	<tr>
		<td>Date Invoiced:&nbsp;</td>
		<td>
			<logic:present name="job" property="dateBilled" >
				<bean:write name="job" property="dateBilled" format="MM/dd/yyyy" /></td>
			</logic:present>
		</td>
	</tr>		
	<tr>
		<td>Invoice Amount:</td>
		<td>
			<logic:present name="job" property="invoiceAmount" >
				<logic:notEqual name="job" property="invoiceAmount" value="0" >
					<bean:write name="job" property="invoiceAmount" />
				</logic:notEqual>
			</logic:present>
		</td>
	</tr><tr>
		<td>Invoice Number:</td>
		<td>
			<logic:present name="job" property="invoiceNumber" >
					<bean:write name="job" property="invoiceNumber" />
			</logic:present>
		</td>
	</tr>
</table>

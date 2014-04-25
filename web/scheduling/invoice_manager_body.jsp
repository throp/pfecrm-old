<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>


<br>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<th valign="top" width="170" colspan="2">Customer</th>
		<th valign="top" width="">Location</th>
		<th valign="top" width="">Type</th>
		<th valign="top" width="" colspan="2">Service</th>
		<th valign="top" width="170" colspan="2">Shop Work</th>
		<th width="20"></th>
	</tr>
	<logic:iterate name="ndg.report" property="currentPage" id="job" >
		<bean:define name="job" property="service" id="service" />
		<bean:define name="service" property="serviceType" id="serviceType" />
		<bean:define name="service" property="location" id="location" />
		<bean:define name="location" property="customer" id="customer" />
		<bean:define name="job" property="roadTechnician" id="roadTechnician" />			
	<tr height="22">
		<td width="20">							
			<a href="/CRM/GoToBillJobAction.do?jobId=<bean:write name="job" property="id" />" border="0"><img src="/CRM/images/right_arrow.jpg" border="0"/></a>
		</td>			
		<td>
			<a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" />"><bean:write name="customer" property="name" /></a>	
		</td>
		<td>
			<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />"><bean:write name="location" property="name" /></a>
		</td>		
		<td>
			<bean:write name="serviceType" property="abbreviation" />
		</td>
			<td align="left" width="50">
			<logic:present name="job" property="dateInRoadTechQueue">
				<bean:write name="job" property="dateInRoadTechQueue" format="MM/dd" />
			</logic:present>
			&nbsp;
		</td>		
		<td >
			<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="roadTechnician" property="id" />"><bean:write name="roadTechnician" property="lastName" /></a>
		</td>		

		<logic:present name="job" property="dateInShopTechQueue">		
		<td class="textSmall" align="left" width="100">
				<bean:write name="job" property="dateInShopTechQueue" format="MM/dd" />
			&nbsp;-&nbsp;
			<bean:write name="job" property="dateReadyForReturn" format="MM/dd" />
		</td>				
		<td class="textSmall" >
			<logic:present name="job" property="shopTechnician" >
				<bean:define name="job" property="shopTechnician" id="shopTechnician" />
				<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="shopTechnician" property="id" />"><bean:write name="shopTechnician" property="lastName" /></a>
			</logic:present>
		</td>		
		</logic:present>		
			
		<logic:notPresent name="job" property="dateInShopTechQueue">
			<td class="textSmall" colspan="2">
			</td>
		</logic:notPresent>		
		<td>
			<a href="/CRM/ViewJobAction.do?jobId=<bean:write name="job" property="id" />" border="0"><img src="/CRM/images/edit.jpg" border="0" /></a>
		</td>			
	</tr>

	<tr height="1"><td colspan="9" class="colorXSubtle"></td></tr>	
	</logic:iterate>
	<tr><th height="1" colspan="9"></th></tr>
</table>

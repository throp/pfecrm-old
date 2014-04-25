<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>


<bean:define name="ndg.report" property="parameters" id="reportParameters" />
<form action="/CRM/ReportQuery.do">
<bean:define name="ndg.report" property="parameters" id="reportParameters" />
<input type="hidden" name="reportKey" value="RevenueManager" />
<table border="0" cellspacing="0" cellpadding="0" width="800" class="colorXSubtle">
	<tr height="1">
		<td class="colorMain" width="1" rowspan="500">
		<td class="colorMain" width="4">
		<td class="colorMain" width="790">
		<td class="colorMain" width="4">
		<td class="colorMain" width="1" rowspan="500">
	</tr>
	<tr height="50">
		<td></td>
		<td valign="top">
			<table width="790">
				<tr>
					<td colspan="5">
						<b>Filter</b>			
					</td>
				</tr>
				<tr>
					<td>
						<select name="serviceTypeId" >
							<option value="0">--all--</option>
							<logic:iterate name="serviceTypes" id="lServiceType" >
								<option value="<bean:write name="lServiceType" property="id" />"
									<bean:define id="selectedServiceTypeId" value="0" type="java.lang.String" />
									<logic:present name="reportParameters" property="serviceTypeId" >
										<bean:define name="reportParameters" property="serviceTypeId" id="selectedServiceTypeId" type="java.lang.String" />		
									</logic:present>										
									<logic:equal name="lServiceType" property="id" value="<%= selectedServiceTypeId %>" >
										selected
									</logic:equal>									
									>
									<bean:write name="lServiceType" property="name" />
								</option>
							</logic:iterate>
						</select>
						<input type="submit" value="Filter>">
					</td>
				</tr>
				
			</table>
		</td>
		<td></td>
	</tr>
	<tr height="1">
		<td class="colorMain"></td>
		<td class="colorMain"></td>
		<td class="colorMain"></td>
	</tr>
</table>
</form>


<br>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<td align="right">
			<b>Total Invoiced:</b> &nbsp;<bean:write name="ndg.report" property="header" />
		</td>
	</tr>
</table>
<br>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<th valign="top" width="170">Customer</th>
		<th valign="top" width="">Location</th>
		<th valign="top" width="">Service</th>
		<th>Tech</th>
		<th>Invoice Date</th>
		<th style="text-align: right">Invoice Amount&nbsp;&nbsp;</th>
		<th width="20"></th>
	</tr>
	<logic:iterate name="ndg.report" property="currentPage" id="job" >
		<bean:define name="job" property="service" id="service" />
		<bean:define name="service" property="serviceType" id="serviceType" />
		<bean:define name="service" property="location" id="location" />
		<bean:define name="location" property="customer" id="customer" />
		<bean:define name="job" property="creditedTechnician" id="creditedTechnician" />			
	<tr height="22">
		<td>
			<a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" />"><bean:write name="customer" property="name" /></a>	
		</td>
		<td>
			<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />"><bean:write name="location" property="name" /></a>
		</td>		
		<td>
			<bean:write name="serviceType" property="abbreviation" />
		</td>
		<td>
			<bean write name="creditedTechnician" property="lastName" />
		</td>

		<td>
			<bean:write name="job" property="dateBilled" format="MM/yy" />
		</td>
		<td align="right">
			<bean:write name="job" property="invoiceAmount" />&nbsp;&nbsp;
		</td>		
		<td>
			<a href="/CRM/ViewJobAction.do?jobId=<bean:write name="job" property="id" />" border="0"><img src="/CRM/images/edit.jpg" border="0" /></a>
		</td>			
	</tr>

	<tr height="1"><td colspan="9" class="colorXSubtle"></td></tr>	
	</logic:iterate>
	<tr><th height="1" colspan="9"></th></tr>
</table>

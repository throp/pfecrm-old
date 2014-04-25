<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
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
			<b>Filter</b><br>
			<form action="/CRM/ReportQuery.do">
			<input type="hidden" name="reportKey" value="WorkReport">
			<bean:define name="ndg.report" property="parameters" id="reportParameters" />
			
			Month: 
			<select name="serviceMonth">
				<option value=""></option>
				<logic:iterate name="months" id="month">
					<option 
					<logic:equal name="reportParameters" property="serviceMonth" value="<%=((com.usi.crm.type.Month) month).getNumber() + "" %>" >		
						selected
					</logic:equal>		
					value="<bean:write name="month" property="number" format="#" />">
						<bean:write name="month" property="name" />
					</option>
				</logic:iterate>		
			</select>			
			<input type="submit" value="Filter">
			<input type="button" value="Reset" onClick="top.document.location.href='/CRM/ReportQuery.do?reportKey=WorkReport';">
		</td>
		<td></td>
	</tr>
	<tr height="1">
		<td class="colorMain"></td>
		<td class="colorMain"></td>
		<td class="colorMain"></td>
		
	</tr>
</table>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<th>Customer</th>
		<th>Location</th>
		<th>Service Month</th>
		<th>Service Frequency</th>
		<th>Serviced</th>
		<th></th>
	</tr>
	<logic:iterate name="ndg.report" property="currentPage" id="location">
	<tr height="22">
		<td>
			<bean:define name="location" property="customer" id="customer" />
			<a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" format="#" />"><bean:write name="customer" property="name" />
		</td>
		<td><a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" format="#" />"><bean:write name="location" property="name" /></a></td>
		<td>
			
			<bean:define name="location" property="serviceMonth" id="serviceMonth" />
			<bean:write name="serviceMonth" property="name" />
		</td> 
		<td>
			<bean:define name="location" property="serviceFrequency" id="serviceFrequency" />
			<bean:write name="serviceFrequency" property="description" />
		</td>
		<td>
			No
		</td>
		<td>
			<a href="">Done</a>
		</td>
	</tr>
	<tr height="1" class="colorXSubtle"><td colspan="50"></td></tr>	
	</logic:iterate>
	<tr>
		<th colspan="40"></th>
	</tr>
</table>
<table border="0" width="800">
	<tr>
		<td align="right">
							<report:page pageActionHref="/CRM/ReportPage.do" reportKey="Customer" />
		</td>
	</tr>
</table>
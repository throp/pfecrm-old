<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<logic:notPresent name="location" >
	<logic:present name="ndg.report">
		<bean:define name="ndg.report" property="header" id="location" />
	</logic:present>
</logic:notPresent>	
<table border="0" cellspacing="0" cellpadding="0" width="700" class="colorXSubtle">
	<tr height="1">
		<td class="colorMain" width="1" rowspan="500">
		<td class="colorMain" width="4">
		<td class="colorMain" width="690">
		<td class="colorMain" width="4">
		<td class="colorMain" width="1" rowspan="500">
	</tr>
	<tr height="30">
		<td></td>
		<td valign="middle">
			<table border="0" width="690">
				<tr height="3"><td></td></tr>							
				<tr>
					<td width="50">
						<b>Links:</b>
					</td>
					<td  width="50" align="left">
						<a href="/CRM/ReportQuery.do?reportKey=LocationNotes&locationId=<bean:write name="location" property="id" />">Notes</a>&nbsp;&nbsp;|&nbsp;
					</td>
					<td  width="100" align="left">
						&nbsp;<a href="/CRM/ViewServiceCallsAction.do?locationId=<bean:write name="location" property="id" />">Service Calls</a>&nbsp;&nbsp;|&nbsp;
					</td>
					<td width="50" align="left">
						&nbsp;<a href="/CRM/ViewServicesAction.do?locationId=<bean:write name="location" property="id" />">Services</a>
					</td>
					<td width="*"></td>
				</tr>
			</table>
		</td>
	</tr>			
	<tr height="3"><td></td></tr>
	<tr height="1">
		<td class="colorMain"></td>
		<td class="colorMain"></td>
		<td class="colorMain"></td>
	</tr>
</table>
<table border="0"><tr height="7"><td></td></tr></table>

<br>
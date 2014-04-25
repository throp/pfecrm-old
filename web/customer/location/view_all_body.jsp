<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>
<jsp:include page="top.jsp" >
	<jsp:param name="title" value="View All" />
</jsp:include>


<div id="dlgFilter"  class="dialog" >
<table class="dialog">
	<tr>							
		<th>Filter</th>
		<th class="closeDialog"><a href="javascript:void(0);" class="closeDialog"><img src="/CRM/images/close.gif" class="dialog"  onClick="hideFilter();" /></th>
	</tr>		
	<tr height="50">
		<td></td>
		<td valign="top">
			<form action="/CRM/ReportQuery.do">
			<input type="hidden" name="reportKey" value="Location">
			<input type="hidden" name="id" value="<bean:write name="customer" property="id" format="#" />" />
			<table>
				<tr>
					<td>
						Name: 
					</td>
					<td>
						<input name="name" type="text" value="<bean:write name="reportParameters" property="name" />" size="50"> 
					</td>
				</tr>
				<tr>
					<td>
						Address: 
					</td>
					<td>
						<input type="text" name="address1" value="<bean:write name="reportParameters" property="address1" />" size="50">
						<input type="submit" value="Filter">
						<input type="button" value="Reset" onClick="top.document.location.href='/CRM/ReportQuery.do?reportKey=Location&id=<bean:write name="customer" property="id" format="#" />';">
					</td>
				</tr>
				<tr height="3"><td></td></tr>
			</table>
			</form>
		</td>
		<td></td>
	</tr>
	<tr height="1">
		<td class="colorMain"></td>
		<td class="colorMain"></td>
		<td class="colorMain"></td>
		
	</tr>
</table>
</div>
<br>

<table border="0" cellspacing="0" class="data" width="700">
	<tr>
		<th>&nbsp;Location</th>
		<th>Phone</th>
		<th>Address</th>
		<th></th>
		<th></th>
	</tr>
	<logic:empty name="ndg.report" >
	<tr>
		<td colspan="3">-no locations entered-</td>
	</tr>
	</logic:empty>
	<logic:iterate name="ndg.report" id="location" >	
	<tr>
		<td>
			<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" format="#" />"><bean:write name="location" property="name" /></a>
		</td>
		<td>
				<bean:write name="location" property="contactPhoneNumber" />
		</td>	
		<td>
			<bean:write name="location" property="address1" />
		</td>
		<td>

		</td> 
		<td>
			<a href="/CRM/GoToDeleteLocationAction.do?name=<bean:write name="location" property="name" />&id=<bean:write name="location" property="id" format="#" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
		</td>
	</tr>	
	</logic:iterate>
	<tfoot>
	<tr height="1">
		<td colspan="5" ></td>
	</tr>
	</tfoot>
</table>
<br>

	<br>
<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>
<jsp:include page="top.jsp" >
	<jsp:param name="title" value="Name" />
	<jsp:param name="secondTitle" value="Add Service" />
</jsp:include>

	<form action="/CRM/AddServiceAction.do" method="POST" >
	<input type="hidden" name="locationId" value="<bean:write name="location" property="id" format="#" />">
	<input type="hidden" name="serviceTypeId" value="<bean:write name="serviceType" property="id" />">
	<table>
		<tr>
			<td>Service:&nbsp;</td>
			<td><bean:write name="serviceType" property="name" /></td>
		</tr>
		<tr>
			<td>Service Month:&nbsp;</td>
			<td>
				<select name="serviceMonth">
					<option value=""></option>
					<logic:iterate name="months" id="month">
						<option value="<bean:write name="month" property="number" format="#" />">
							<bean:write name="month" property="name" />
						</option>
					</logic:iterate>		
				</select>
			</td>
		</tr>
		<tr>
			<td>Service Frequency:&nbsp;</td>
			<td>
				<select name="serviceFrequency">
					<option value=""></option>
					<logic:iterate name="monthlyFrequencies" id="month">
						<option value="<bean:write name="month" property="id" format="#" />">
							<bean:write name="month" property="description" />
						</option>
					</logic:iterate>		
				</select>
			</td>
		</tr>
		<tr>
			<td valign="top">
				Notes:&nbsp;
			</td>
			<td>
				<textarea cols="90" rows="8" name="notes"></textarea>
			</td>
		</tr>				
		<tr>
			<td></td>
			<td><input type="submit" value="Add Service" /></td>
		</tr>
	</table>
	</form>
	<br>
	<jsp:include page="link_bar.jsp" flush="true" />
<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />	
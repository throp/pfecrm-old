<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>
<jsp:include page="../top.jsp" >
	<jsp:param name="title" value="Name" />
	<jsp:param name="secondTitle" value="Service Calls" />
</jsp:include>

<table border="0" cellspacing="0" cellpadding="0" width="700" class="colorXSubtle">
	<tr height="1">
		<td class="colorMain" width="1" rowspan="500">
		<td class="colorMain" width="4">
		<td class="colorMain" width="690">
		<td class="colorMain" width="4">
		<td class="colorMain" width="1" rowspan="500">
	</tr>
	<tr height="50">
		<td></td>
		<td valign="top">
			<b>Add Service Call</b><br>
			<script language="javascript" src="/CRM/js/validation.js" ></script>
			<script language="javascript">
				function validateServiceCall()
				{
					if(isEmpty(frmServiceCall.note, 'Note', 'true')) {
						return false;
					}
					
					return true;
				}
			</script>
			<form name="frmServiceCall" action="/CRM/AddServiceCallAction.do" method="POST" onSubmit="return validateServiceCall();">
			<input type="hidden" name="locationId" value="<bean:write name="location" property="id" />">
			<table border="0" width="690">
				<tr>
					<td valign="top">Service:</td>
					<td>
						<select name="serviceId">
							<logic:iterate name="services" id="service" >
								<option value="<bean:write name="service" property="id" />">
									<bean:define name="service" property="serviceType" id="serviceType" />
									<bean:write name="serviceType" property="name" />
								</option>
							</logic:iterate>
						</select>
					</td>
				</tr>
				<tr>
					<td valign="top">Note:</td>
					<td>
						<textarea name="note" cols="90" rows="2"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add>"></td>
				</tr>
			</table>
			<br>
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
<br>
<br>
	
<jsp:include page="../bottom.jsp" flush="true" />
<jsp:include page="../../customer_bottom.jsp" flush="true" />
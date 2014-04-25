<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<jsp:include page="top.jsp" flush="true" >
	<jsp:param name="section" value="revenue" />
</jsp:include>

<table border="0" cellspacing="0" cellpadding="0" width="700">
	<tr>
		<td align="right">
			<b>Total:</b>&nbsp;
			<logic:present name="total" >
				<bean:write name="total" />
			</logic:present>
		</td>
	</tr>
</table>
<br>
<br>
			
<table border="0" cellspacing="0" cellpadding="0" width="700">
	<tr>
		<th width="200">Location</th>
		<th width="150">Service</th>		
		<th width="120">&nbsp;Date</th>
		<th width="150">Invoice</th>
		<th width="20"></td>		
		<th width="90" style="text-align: right">Amount</span></th>
	</tr>
	<logic:empty name="jobs" >
	<tr>
		<td<i>--no jobs--</i></td>
	</tr>
	</logic:empty>
	<logic:present name="jobs" >
	<logic:iterate name="jobs" id="job" >
	<bean:define name="job" property="service" id="service" />
	<bean:define name="service" property="serviceType" id="serviceType" />
	<bean:define name="service" property="location" id="location" />		
	<tr height="2"><td colspan="5"></td></tr>	
	<tr height="23">
		<td>
			<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />">
				<bean:write name="location" property="name" />
			</a>
		</td>
		<td><bean:write name="serviceType" property="name" /></td>		
		<td><bean:write name="job" property="dateBilled" format="MM/yy" /></td>
		<td><bean:write name="job" property="invoiceNumber" /></td>
		<td></td>
		<td align="right"><bean:write name="job" property="invoiceAmount" format="$00.00" /></td>

	</tr>
	<tr height="2"><td colspan="6"></td></tr>
	<tr height="1"><td colspan="6" class="colorXSubtle"></td></tr>
	</logic:iterate>
	</logic:present>
	<tr height="2"><td colspan="6"></td></tr>	

	<tr height="2"><td colspan="6"></td></tr>	
	
	<tr>
		<th colspan="6"></th>
	</tr>
</table>
<br>

	<br>
	
<jsp:include page="customer_bottom.jsp" flush="true" />
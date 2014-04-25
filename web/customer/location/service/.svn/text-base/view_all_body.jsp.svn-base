<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<jsp:include page="../../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>

<jsp:include page="../top.jsp" >
	<jsp:param name="title" value="Name" />
	<jsp:param name="secondTitle" value="Services" />
</jsp:include>
	<br>
<table cellspacing="0" width="690" class="data">
	<tr>
		<th>Service</th>
		<th>Month</th>
		<th>Frequency</th>
		<th></th>
	</tr>
	<tbody>
	<logic:empty name="services">
		<tr>
			<td><i>no services defined</td>
		</tr>
	</logic:empty>
	<logic:iterate name="services" id="service" >
		<tr height="23">
			<td>
				<bean:define name="service" property="serviceType" id="serviceType" />
			<a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />"><bean:write name="serviceType" property="name" /></a>
			</td>
			<td>
				<bean:define name="service" property="serviceMonth" id="serviceMonth" />
				<bean:write name="serviceMonth" property="name" />
			</td>
			<td>
				<bean:define name="service" property="serviceFrequency" id="serviceFrequency" />
				<bean:write name="serviceFrequency" property="description" />
			</td>
			<td>
				<a href="javascript:showDeleteService(<bean:write name="service" property="id" />);" border="0"><img src="/CRM/images/trash.gif" border="0"/></a>
			</td>
		</tr>
	</logic:iterate>
	</tbody>
	<tfoot>
	<tr height="1">
		<td colspan="4" ></td>
	</tr>
	</tfoot>
</table>
<br>
<br>
<form action="/CRM/GoToAddServiceAction.do" >
<input type="hidden" name="locationId" value="<bean:write name="location" property="id" />">
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
					<td valign="middle" width="100">
						<b>Add Service:</b>
					</td>
					<td>
						<select name="serviceTypeId">
						<logic:iterate name="serviceTypes" id="serviceType">
							&nbsp;&nbsp; 
							<bean:define id="hasServiceType" value="no" />
							<logic:iterate name="services" id="service">
								<bean:define name="service" property="serviceType" id="locationServiceType" />							
								<logic:equal name="locationServiceType" property="name" value="<%= ((com.pfe.crm.domain.type.ServiceType) serviceType).getName() %>" >
									<bean:define id="hasServiceType" value="yes" />
								</logic:equal>
							</logic:iterate>
							<logic:equal name="hasServiceType" value="no" >
								<option value="<bean:write name="serviceType" property="id" />"><bean:write name="serviceType" property="name" /></option>
							</logic:equal>
						</logic:iterate>
						</select>
						&nbsp;&nbsp;
						<input type="submit" value="Add Service" />
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
<br>

<jsp:include page="../link_bar.jsp" />
<jsp:include page="../bottom.jsp" flush="true" />						
<jsp:include page="../../customer_bottom.jsp" flush="true" />	
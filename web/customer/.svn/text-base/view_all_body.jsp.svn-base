<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>


<br>
<logic:greaterThan name="totalRecords" value="50" >
Displaying <bean:write name="recordsShown" /> of <bean:write name="totalRecords" /> customers meeting filter criteria.  Please use filters to narrow result set.
<br>
<br>
</logic:greaterThan>
<table cellspacing="0" width="800" class="data">
	<thead>
	<tr>
		<th>Customer Name</th>
		<th>Phone</th>
		<th>Address</th>
		<th>Zip</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<logic:empty name="ndg.report" >
		<tr>
			<td colspan="5">--no customers--</td>
		</tr>
	</logic:empty>
	<bean:define id="lastCustomerName" value="blah" type="java.lang.String" />
	
	<!-- Case 1: Location address not empty -->
	<logic:notEmpty name="reportParameters" property="locationAddress" >
		<logic:iterate name="ndg.report"  id="location" >
			<bean:define name="location" property="customer" id="customer" />
			<logic:notEqual name="customer" property="name" value="<%= lastCustomerName %>" >
				<bean:define id="lastCustomerName" name="customer" property="name" type="java.lang.String" />
				
				<tr>  
					<td><a href="/CRM/ViewLocationsAction.do?id=<bean:write name="customer" property="id" format="#" />">&nbsp;<bean:write name="customer" property="name" /></a></td>
					<td>
							<bean:write name="customer" property="primaryContactPhoneNumber" />
					</td>					
					<td><bean:write name="customer" property="address1" /></td>
					<td><bean:write name="customer" property="zip" /></td>
					<td><a href="/CRM/GoToDeleteCustomerAction.do?name=<bean:write name="customer" property="name" />&id=<bean:write name="customer" property="id" format="#" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a></td>
				</tr>	
			</logic:notEqual>
			<tr>  
				<td>&nbsp;&nbsp;&nbsp;<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />">&nbsp;<bean:write name="location" property="name" /></a></td>
				<td>
					<bean:write name="location" property="contactPhoneNumber" />
				</td>					
				<td><bean:write name="location" property="address1" /></td>
				<td><bean:write name="location" property="zip" /></th>
			</tr>
		</logic:iterate>
	</logic:notEmpty>
	
	
	<!-- Case 2: Location name not empty -->
	<logic:notEmpty name="reportParameters" property="locationName" >
	<logic:iterate name="ndg.report"  id="location" >
	<bean:define name="location" property="customer" id="customer" />
	<logic:notEqual name="customer" property="name" value="<%= lastCustomerName %>" >
		<bean:define id="lastCustomerName" name="customer" property="name" type="java.lang.String" />
			
		<tr>  
			<td><a href="/CRM/ViewLocationsAction.do?id=<bean:write name="customer" property="id" format="#" />">&nbsp;<bean:write name="customer" property="name" /></a></td>
			<td>
				<bean:write name="customer" property="primaryContactPhoneNumber" />
			</td>			
			<td><bean:write name="customer" property="address1" /></td>
			<td><bean:write name="customer" property="zip" /></th>
			<td><a href="/CRM/GoToDeleteCustomerAction.do?name=<bean:write name="customer" property="name" />&id=<bean:write name="customer" property="id" format="#" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a></td>
		</tr>	
	</logic:notEqual>
	<tr>  
		<td>&nbsp;&nbsp;&nbsp;<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />">&nbsp;<bean:write name="location" property="name" /></a></td>
		<td>
				<bean:write name="location" property="contactPhoneNumber" />
		</td>		
		<td><bean:write name="location" property="address1" /></td>
		<td><bean:write name="location" property="zip" /></th>
	</tr>
	</logic:iterate>
	</logic:notEmpty>	
	
	
	<!-- Case 3: Both Location name and address are empty -->
	<logic:empty name="reportParameters" property="locationName">
	<logic:empty name="reportParameters" property="locationAddress">
		<logic:iterate name="ndg.report"  id="customer" >
			
				<tr>  
					<td><a href="/CRM/ViewLocationsAction.do?id=<bean:write name="customer" property="id" format="#" />">&nbsp;<bean:write name="customer" property="name" /></a></td>
					<td>
						<bean:write name="customer" property="primaryContactPhoneNumber" />
					</td>
					<td><bean:write name="customer" property="address1" /></td>
					<td><bean:write name="customer" property="zip" /></th>
					<td><a href="/CRM/GoToDeleteCustomerAction.do?name=<bean:write name="customer" property="name" />&id=<bean:write name="customer" property="id" format="#" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a></td>
					
				</tr>
		</logic:iterate>
	</logic:empty>
	</logic:empty>
	</tbody>
	<tfoot>
	<tr height="1">
		<td colspan="5" ></td>
	</tr>
	</tfoot>
</table>


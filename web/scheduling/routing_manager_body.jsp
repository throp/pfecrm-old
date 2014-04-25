<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<script src="/CRM/js/positioning.js" language="javascript"></script>
<script src="/CRM/js/dialog_box.js" language="javascript"></script>
<script src="/CRM/js/ajax.js" language="javascript"></script>
<script src="/CRM/js/validation.js" language="javascript"></script>
<script src="/CRM/scheduling/routing_manager.js" language="javascript"></script>

<!-- Service Calls ------------------------------------------ -->
<logic:notEmpty name="ndg.report" property="subHeader">
<table cellspacing="3" cellpadding="2" width="125" class="colorAlert"><tr><td class="textInverse">&nbsp;<b>Service Calls</b></td></tr></table>
<table border="0" cellspacing="0" cellpadding="0" width="800" class="colorXSubtle">
	<tr height="1">
		<td class="colorAlert" width="1" rowspan="500"></td>
		<td class="colorAlert" width="4"></td>
		<td class="colorAlert" width="790"></td>
		<td class="colorAlert" width="4"></td>
		<td class="colorAlert" width="1" rowspan="500"></td>
	</tr>
	<tr height="50">
		<td></td>
		<td valign="top">
			<table border="0" cellspacing="0" cellpadding="0" width="790">
				<tr height="3"><td width="10" rowspan="100"></td></tr>	
				<tr>
					<th colspan="2">
						<b>Customer</b>				
					</th>
					<th><b>Location</b></th>
					<th><b>Date</b></th>
					<th><b>Emp</b></th>				
					<th><b>Notes</b></th>											
				</tr>
				<tr height="3"><td colspan="6"></td></tr>
				<logic:notEmpty name="ndg.report" property="subHeader">
				<logic:iterate name="ndg.report" property="subHeader" id="job">
						<bean:define name="job" property="service" id="service" />
						<bean:define name="service" property="serviceType" id="serviceType" />
						<bean:define name="service" property="location" id="location" />
						<bean:define name="location" property="customer" id="customer" />			
						<bean:define name="job" property="serviceCall" id="serviceCall" />		
						<bean:define name="serviceCall" property="employee" id="employee" />
					<tr valign="middle" height="24">
						<td width="20" valign="top">
							<a href="javascript:void(0);" border="0"><img id="img<bean:write name="job" property="id" />" onClick="showAssignRoadTech(<bean:write name="job" property="id" />, 'dlgAssignRoadTech')" src="/CRM/images/right_arrow.jpg" border="0"/></a>
						</td>
						<td width="200" valign="top">
							<a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" />"><bean:write name="customer" property="name" /></a>
						</td>
						<td width="" valign="top">
							<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />"><bean:write name="location" property="name" />	</a>
						</td>

						<td valign="top"><bean:write name="serviceCall" property="datePlaced" format="MM/dd" /></td>
						<td valign="top">
							<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="employee" property="id" />">
									<bean:write name="employee" property="lastName" />
							</a>
						</td>		

						<td valign="top" width="300"><bean:write name="serviceCall" property="notes" /></td>													
					</tr>					
				</logic:iterate>
				</logic:notEmpty>
				<tr height="1"><th colspan="6"></th></td>
				<tr height="13"><td></td></tr>	
			
			</table>

		</td>
		<td></td>
	</tr>
	<tr height="1">
		<td class="colorAlert"></td>
		<td class="colorAlert"></td>
		<td class="colorAlert"></td>
	</tr>
</table>
<br>
<br>
</logic:notEmpty>

<!-- Returns -------------------------------------------------- -->
<logic:notEmpty name="ndg.report" property="header" >
<table cellspacing="3" cellpadding="2" width="125" class="colorAlternateAlert"><tr><td class="textInverse">&nbsp;<b>Returns</b></td></tr></table>
<table border="0" cellspacing="0" cellpadding="0" width="800" class="colorXSubtle">
	<tr height="1">
		<td class="colorAlternateAlert" width="1" rowspan="500"></td>
		<td class="colorAlternateAlert" width="4"></td>
		<td class="colorAlternateAlert" width="790"></td>
		<td class="colorAlternateAlert" width="4"></td>
		<td class="colorAlternateAlert" width="1" rowspan="500"></td>
	</tr>
	<tr height="50">
		<td></td>
		<td valign="top">
			<table border="0" cellspacing="0" cellpadding="0" width="790">
				<tr height="3"><td width="10" colspan="11"rowspan="100"></td></tr>	
				<tr>
					<th colspan="2">Customer</th>
					<th>Location</th>
					<th>Type</th>
					<td rowspan="500" width="1" bgcolor="black"></td>						
					<th colspan="2">&nbsp;Service</th>
					<td rowspan="500" width="1" bgcolor="black"></td>
					<th colspan="2">&nbsp;Shop Work</th>
				</tr>
				<logic:notEmpty name="ndg.report" property="header" >
						<logic:iterate name="ndg.report" property="header" id="returnJob" >
						<bean:define name="returnJob" property="service" id="service" />
						<bean:define name="service" property="serviceType" id="serviceType" />
						<bean:define name="service" property="location" id="location" />
						<bean:define name="location" property="customer" id="customer" />
						<bean:define name="returnJob" property="roadTechnician" id="roadTechnician" />	
						<bean:define name="returnJob" property="shopTechnician" id="shopTechnician" />													
						<tr height="25">
							<td>							
								<a href="javascript:void(0)" border="0"><img id="img<bean:write name="returnJob" property="id" />" onClick="showAssignReturnTech(<bean:write name="returnJob" property="id" />)" src="/CRM/images/right_arrow_grey.gif" border="0"/></a>
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
							<td>
								&nbsp;<bean:write name="returnJob" property="dateInRoadTechQueue" format="MM/dd" />
							</td>
							<td>
								&nbsp;<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="roadTechnician" property="id" />"><bean:write name="roadTechnician" property="lastName" /></a>
							</td>
							<td>
								&nbsp;
								<bean:write name="returnJob" property="dateInShopTechQueue" format="MM/dd" />
								&nbsp;-&nbsp;
								<bean:write name="returnJob" property="dateReadyForReturn" format="MM/dd" />
							</td>
							<td>
									<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="shopTechnician" property="id" />"><bean:write name="shopTechnician" property="lastName" /></a>
							</td>		
						</tr>
					</logic:iterate>
				</logic:notEmpty>					
				<tr height="1"><td colspan="10" bgcolor="black"></td></tr>
			</table>
		</td>
		<td></td>
	</tr>
	<tr height="4">
		<td class=""></td>
		<td></td>
		<td class=""></td>
	</tr>
	<tr height="1">
		<td class="colorAlternateAlert"></td>
		<td class="colorAlternateAlert"></td>
		<td class="colorAlternateAlert"></td>
	</tr>
</table>
<br>
<br>
</logic:notEmpty>



<table cellspacing="0" width="800" class="data">
	<thead>
	<tr height="23">
		<th colspan="2">
			Customer							
		</th>
		<th>Location</th>
		<th>Type</th>
		<th>Address</th>
		<th>Zip</th>
		<th>Ann</th>
		<th style="text-align: right;"># Inv&nbsp;&nbsp;</th>
		<th>Frequency</th>
	</tr>
	</thead>
	<tr height="3"><td></td></tr>	
	<bean:define id="currentServiceTypeName" value="blah" />
	<logic:iterate name="ndg.report" property="currentPage" id="job">
	<bean:define name="job" property="service" id="service" />
	<bean:define name="service" property="serviceType" id="serviceType" />
	<bean:define name="service" property="location" id="location" />
	<bean:define name="location" property="customer" id="customer" />	
		<div id="job<bean:write name="job" property="id" />" >
		<tr>
			<td class="textSmall" width="20">							
				<a href="javascript:void(0);" border="0"><img id="img<bean:write name="job" property="id" />" onClick="showAssignRoadTech(<bean:write name="job" property="id" />, 'dlgAssignRoadTech')" src="/CRM/images/right_arrow.jpg" border="0"/></a>
			</td>		
			<td class="textSmall">
				<span title="<bean:write name="customer" property="name" />">
					<a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" />"><bean:write name="customer" property="nameAbbreviation" /></a>
				</span>
			</td>
			<td>
				<span title="<bean:write name="location" property="name" />">
					<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />"><bean:write name="location" property="nameAbbreviation" /></a>
				</span>
			</td>
			<td class="textSmall">
				<a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />"><bean:write name="serviceType" property="abbreviation" /></a>
			</td>	
			<td class="textSmall">
				<span title="<bean:write name="location" property="address1" />">
					<bean:write name="location" property="address1Abbreviation" />
				</span>
			</td>
			<td class="textSmall">
				<bean:write name="location" property="zip" />&nbsp;
			</td>
		<td class="textSmall">
			<bean:define name="service" property="serviceMonth" id="serviceMonth" />
			<bean:write name="serviceMonth" property="name" />
		</td>
		<td align="right">
			<a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />">
				<bean:write name="service" property="numInventoryItems" />
			</a>
			&nbsp;&nbsp;
		</td>
		<td>
			<bean:define name="service" property="serviceFrequency" id="serviceFrequency" />
			<bean:write name="serviceFrequency" property="description" />
		</td>							
		</tr>
		</div>
	</logic:iterate>
	<tfoot>
	<tr height="1">
		<td colspan="9" ></td>
	</tr>
	</tfoot>

</table>

<div class="page"> 
		<report:page pageActionHref="/CRM/ReportPage.do" reportKey="RoutingManager" />
</div>

<!-- Assign Road Tech Dialog Box ------------------------------- -->
<jsp:include page="/includes/dialog_top.jsp" >
	<jsp:param name="title" value="Assign Road Tech" />
	<jsp:param name="dialogBoxId" value="dlgAssignRoadTech" />
</jsp:include>
<table border="0" cellspacing="2" cellpadding="2" >
	<tr>
		<td>&nbsp;&nbsp;Technician: </td>
		<td>
			<select id="assignRoadTechEmployeeId" name="assignRoadTechEmployeeId">
				<option value="">-</option>
				<logic:iterate name="employees" id="employee" >
					<bean:define name="employee" property="employeeType" id="employeeType" />
					<logic:equal name="employeeType" property="description" value="Road Technician">
					<option value="<bean:write name="employee" property="id" />"	>
						<bean:write name="employee" property="firstName" />
						<bean:write name="employee" property="lastName" />		
					</option>
					</logic:equal>				
				</logic:iterate>
			</select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="Assign" onClick="assignRoadTech()"/></td>
	</tr>
</table>
<jsp:include page="/includes/dialog_bottom.jsp" />


<!-- Assign Return Tech Dialog Box ------------------------------- -->
<jsp:include page="/includes/dialog_top.jsp" >
	<jsp:param name="title" value="Assign Return Tech" />
	<jsp:param name="dialogBoxId" value="dlgAssignReturnTech" />
</jsp:include>
<table border="0" cellspacing="2" cellpadding="2" >
	<tr>
		<td>&nbsp;&nbsp;Technician: </td>
		<td>
			<select id="assignReturnTechEmployeeId" name="assignReturnTechEmployeeId">
				<option value="">-</option>
				<logic:iterate name="employees" id="employee" >
					<bean:define name="employee" property="employeeType" id="employeeType" />
					<logic:equal name="employeeType" property="description" value="Road Technician">
					<option value="<bean:write name="employee" property="id" />"	>
						<bean:write name="employee" property="firstName" />
						<bean:write name="employee" property="lastName" />		
					</option>
					</logic:equal>				
				</logic:iterate>
			</select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" value="Assign" onClick="assignReturnTech()"/></td>
	</tr>
</table>
<jsp:include page="/includes/dialog_bottom.jsp" />

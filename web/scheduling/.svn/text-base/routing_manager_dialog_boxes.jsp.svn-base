<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>


<div id="dlgFilter"  class="dialog" >
<form name="frmFilters" action="/CRM/ReportQuery.do" onSubmit="return validateFilters();">
<input type="hidden" name="reportKey" value="RoutingManager" />
<bean:define name="ndg.report" property="parameters" id="reportParameters" />
<input type="hidden" name="isAdvanced" value="<bean:write name="reportParameters" property="isAdvanced" />" >
<table class="dialog">
	<tr>							
		<th>Filter</th>
		<th class="closeDialog"><a href="javascript:void(0);" class="closeDialog"><img src="/CRM/images/close.gif" class="dialog"  onClick="hideFilter();" /></th>
	</tr>			
	<tr>
		<td valign="top">
			<table >
				<tr>
					<td width="120">Customer Name:&nbsp;</td>
					<td>
						<input type="text" size="35" name="customerName" value="<bean:write name="reportParameters" property="customerName" />" />
					</td>
				</tr>
				<tr>
					<td width="90">Service Type:&nbsp;</td>
					<td width="200">
						<bean:define id="serviceTypeId" value="0" type="java.lang.String" />
						<logic:present name="reportParameters" property="serviceTypeId" >
							<bean:define name="reportParameters" property="serviceTypeId" id="serviceTypeId" type="java.lang.String" />
						</logic:present>
						<select name="serviceTypeId" >
							<option value="0"></option>
							<logic:iterate name="serviceTypes" id="serviceType" >
								<option value="<bean:write name="serviceType" property="id" />"
									<logic:notEqual name="serviceTypeId" value="0" >
									<logic:equal name="serviceType" property="name" value="<%= com.pfe.crm.domain.type.ServiceType.getInstance(Integer.parseInt(serviceTypeId)).getName() %>">
										selected
									</logic:equal>
									</logic:notEqual>
								>
									<bean:write name="serviceType" property="name" />
								</option>
							</logic:iterate>
						</select>
					</td>
				</tr>
				<tr>
					<td width="50">Month:&nbsp;</td>
					<td>
						<bean:define id="monthId" value="1" type="java.lang.String" />
						<logic:present name="reportParameters" property="monthId" >
							<bean:define name="reportParameters" property="monthId" id="monthId" type="java.lang.String" />		
						</logic:present>
						<select name="monthId">
							<logic:iterate name="months" id="month">
								<option value="<bean:write name="month" property="number" format="#" />"
								<logic:equal name="month" property="name" value="<%= com.pfe.crm.domain.type.Month.getInstance(Integer.parseInt(monthId)).getName() %>" >
									selected
								</logic:equal>
								>
									<bean:write name="month" property="name" />
								</option>
							</logic:iterate>		
						</select>
						&nbsp;&nbsp;
						Year:&nbsp;
					
						<bean:define id="yearId" value="1" type="java.lang.String" />
						<logic:present name="reportParameters" property="yearId" >
							<bean:define name="reportParameters" property="yearId" id="yearId" type="java.lang.String" />		
						</logic:present>						
						<select name="yearId">
							<option value="">-</option>						
							<logic:iterate name="years" id="year">
								<option value="<bean:write name="year" property="year" />"
								<logic:equal name="year" property="name" value="<%= com.pfe.crm.domain.type.Year.getInstance(Integer.parseInt(yearId)).getName() %>" >
									selected
								</logic:equal>									
									>
									<bean:write name="year" property="year" />
								</option>
							</logic:iterate>
						</select>
					</td>
				</tr>
				<tr>
					<td >Month (also):</td>
					<td>
						<bean:define id="monthId2" value="1" type="java.lang.String" />
						<logic:present name="reportParameters" property="monthId2" >
							<bean:define name="reportParameters" property="monthId2" id="monthId2" type="java.lang.String" />		
						</logic:present>
						<select name="monthId2">
							<option value=""> - </option>
							<logic:iterate name="months" id="month">
								<option value="<bean:write name="month" property="number" format="#" />"
								<logic:notEqual name="monthId2" value="0" >									
								<logic:equal name="month" property="name" value="<%= com.pfe.crm.domain.type.Month.getInstance(Integer.parseInt(monthId2)).getName() %>" >
									selected
								</logic:equal>
								</logic:notEqual>
								>
									<bean:write name="month" property="name" />
								</option>
							</logic:iterate>		
						</select>
						&nbsp;&nbsp;
						Year:&nbsp;
					
						<bean:define id="yearId2" value="1" type="java.lang.String" />
						<logic:present name="reportParameters" property="yearId2" >
							<bean:define name="reportParameters" property="yearId2" id="yearId2" type="java.lang.String" />		
						</logic:present>						
						<select name="yearId2">
							<option value="">-</option>						
							<logic:iterate name="years" id="year">
								<option value="<bean:write name="year" property="year" />"
								<logic:notEqual name="yearId2" value="0" >	
								<logic:equal name="year" property="name" value="<%= com.pfe.crm.domain.type.Year.getInstance(Integer.parseInt(yearId2)).getName() %>" >
									selected
								</logic:equal>								
								</logic:notEqual>	
									>
									<bean:write name="year" property="year" />
								</option>
							</logic:iterate>
						</select>
					</td>
				</tr>
				<tr>
					<td width="50">Office:&nbsp;</td>
					<td align="left">
						<bean:define id="officeId" value="1" type="java.lang.String" />
						<logic:present name="reportParameters" property="officeId" >
							<bean:define name="reportParameters" property="officeId" id="officeId" type="java.lang.String" />		
						</logic:present>					
						<select name="officeId">
							<option value="">-</option>
							<logic:iterate name="offices" id="office" >
								<option value="<bean:write name="office" property="id" />"
									<logic:equal name="office" property="id" value="<%= officeId %>" >
										selected
									</logic:equal>
								>
									<bean:write name="office" property="name" />
								</option>
							</logic:iterate>
						</select>
					</td>
				</tr>
				<tr>
					<td width="45">Zip:&nbsp;</td>
					<td width="50">
						<logic:present name="reportParameters" property="zip" >
							<input type="text" name="zip" size="5" value="<bean:write name="reportParameters" property="zip" />"/>
						</logic:present>
						<logic:notPresent name="reportParameters" property="zip" >
							<input type="text" name="zip" size="5" value="">
						</logic:notPresent>
					</td>
				</tr>

				<tr>					
					<td ></td>					
					<td>
						<input type="submit" value="Filter">
						&nbsp;
							<input type="button" value="Refresh" onClick="top.document.location.href='/CRM/ReportQuery.do?reportKey=RoutingManager';">
						<br><br>
					</td>
				</tr>
			</table>			
		</td>
	</tr>
</table>
</form>
	
</div>
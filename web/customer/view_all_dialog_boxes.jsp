<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>

<div id="dlgFilter"  class="dialog" >
<form action="/CRM/ViewCustomersAction.do">
	<table class="dialog">
		<tr>							
			<th>Filter</th>
			<th class="closeDialog"><a href="javascript:void(0);" class="closeDialog"><img src="/CRM/images/close.gif" class="dialog"  onClick="hideFilter();" /></th>
		</tr>				
		<tr height="50">
			<td valign="top">
				<input type="hidden" name="isAdvanced" value="<bean:write name="reportParameters" property="isAdvanced" />" >
				<table >
					<tr>
						<td>
							Office:
						</td>
						<td>
							<bean:define id="officeId" value="0" type="java.lang.String" />
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
						<td>
							
							Customer Name: 
						</td>
						<td>
							<input type="text" name="customerName" value="<bean:write name="reportParameters" property="customerName" />" size="70"> 
						</td>
						<td width="15"></td>
					</tr>
					<tr>
						<td>
							Customer Address: 
						</td>
						<td>
							<input type="text" name="customerAddress" value="<bean:write name="reportParameters" property="customerAddress" />" size="70">
						</td>
					</tr>
	
					<tr>
						<td>
							Customer Zip:
						</td>
						<td>
							<input type="text" name="customerZip" value="<bean:write name="reportParameters" property="customerZip" />" />
						</td>
					</tr>				
					<tr>
						<td>Customer Status</td>
						<td>
												<bean:define name="reportParameters" property="status" id="statusId" />
							<select name="status">
							<option value=""></option>
							<logic:iterate name="customerStatuses" id="status">
								<option 
									<logic:equal name="status" property="id" value="<%= statusId + "" %>" >
										selected
									</logic:equal>
									value="<bean:write name="status" property="id" format="#" />">
									<bean:write name="status" property="description" />
								</option>
							</logic:iterate>
							</select>
						</td>
					</tr>				
					<tr>
						<td>
							Location Name: 
						</td>
						<td>
							<input type="text" name="locationName" value="<bean:write name="reportParameters" property="locationName" />" size="70" />
						</td>
					</tr>
					<tr>
						<td>
							Location Address: 
						</td>
						<td>
							<input type="text" name="locationAddress" size="70" value="<bean:write name="reportParameters" property="locationAddress" />" />
						</td>
					</tr>				
	
					<tr>
						<td></td>
						<td colspan="2">
							<input type="submit" value="Filter">
							<input type="button" value="Reset" onClick="top.document.location.href='/CRM/ViewCustomersAction.do';">			
						</td>
					</tr>
					<tr height="3"><td></td></tr>
				</table>
			</td>
		</tr>
	</table>
</div>
</form>
<table border="0" cellspacing="0" cellpadding="0" width="800" class="colorXSubtle">
	<tr height="1">
		<td class="colorMain" width="1" rowspan="500">
		<td class="colorMain" width="4">
		<td class="colorMain" width="790">
		<td class="colorMain" width="4">
		<td class="colorMain" width="1" rowspan="500">
	</tr>
	<tr height="50">
		<td></td>
		<td valign="top">
			<form action="/CRM/ViewCustomersAction.do">
			<input type="hidden" name="isAdvanced" value="<bean:write name="reportParameters" property="isAdvanced" />" >
			<table width="790">
				<tr>
					<td>
						<b>Filter</b>			
					</td>
					<td colspan="500" align="right">
						<logic:equal name="reportParameters" property="isAdvanced" value="true" >
							(<a href="/CRM/ViewCustomersAction.do?isAdvanced=false&customerName=<bean:write name="reportParameters" property="customerName" />&customerAddress=<bean:write name="reportParameters" property="customerAddress" />">basic</a>)	&nbsp;&nbsp;
						</logic:equal>
						<logic:notEqual name="reportParameters" property="isAdvanced" value="true" >
							(<a href="/CRM/ViewCustomersAction.do?isAdvanced=true&customerName=<bean:write name="reportParameters" property="customerName" />&customerAddress=<bean:write name="reportParameters" property="customerAddress" />&locationAddress=<bean:write name="reportParameters" property="locationName" />&locationAddress=<bean:write name="reportParameters" property="locationAddress" />&status=<bean:write name="reportParameters" property="status" />">advanced</a>)	&nbsp;&nbsp;
						</logic:notEqual>
					</td>
				</tr>
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

				<logic:equal name="reportParameters" property="isAdvanced" value="true" >
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

				</logic:equal>
				<tr>
					<td></td>
					<td colspan="2">
						<input type="submit" value="Filter">
						<logic:equal name="reportParameters" property="isAdvanced" value="true" >
							<input type="button" value="Reset" onClick="top.document.location.href='/CRM/ViewCustomersAction.do?isAdvanced=true';">
						</logic:equal>
						<logic:notEqual name="reportParameters" property="isAdvanced" value="true" >
							<input type="button" value="Reset" onClick="top.document.location.href='/CRM/ViewCustomersAction.do';">
						</logic:notEqual>						
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
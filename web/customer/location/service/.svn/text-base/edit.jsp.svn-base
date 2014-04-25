<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>

			<script language="javascript" src="/CRM/js/validation.js" ></script>
			<script language="javascript" src="/CRM/customer/location/fire_extinguisher/validation.js"></script>
			<form action="/CRM/EditServiceAction.do" >
			<input type="hidden" name="serviceId" value="<bean:write name="service" property="id" />">		
			<bean:define name="service" property="serviceType" id="serviceType" />
			<input type="hidden" name="serviceTypeId" value="<bean:write name="serviceType" property="id" />">
			<table border="0">
				<tr height="30">
					<td>
						Service Month:&nbsp;
					</td>
					<td>
						<bean:define name="service" property="serviceMonth" id="serviceMonth" />
						<select name="serviceMonth">
							<logic:iterate name="months" id="month">
								<option value="<bean:write name="month" property="number" format="#" />"
								<logic:equal name="month" property="name" value="<%= ((com.pfe.crm.domain.type.Month) serviceMonth).getName() %>" >
									selected
								</logic:equal>
								>
									<bean:write name="month" property="name" />
								</option>
							</logic:iterate>		
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Service Frequency:&nbsp;
					</td>
					<td>
							<bean:define name="service" property="serviceFrequency" id="serviceFrequency" />
			
							<select name="serviceFrequency">
								<logic:iterate name="monthlyFrequencies" id="frequency">
									<option value="<bean:write name="frequency" property="id" format="#" />"
									<logic:equal name="frequency" property="description" value="<%= ((com.pfe.crm.domain.type.MonthlyFrequency) serviceFrequency).getDescription() %>" >
										selected
									</logic:equal>
									>
										<bean:write name="frequency" property="description" />
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
						<textarea cols="90" rows="8" name="notes"><bean:write name="service" property="notes" /></textarea>
					</td>
				</tr>				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Save>">
					</td>
				</tr>
			</table>
			</form>
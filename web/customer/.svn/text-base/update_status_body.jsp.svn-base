<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/struts-html" prefix="html" %>


<form action="/CRM/UpdateCustomerStatusAction.do">
<input type="hidden" name="customerId" value="<bean:write name="customer" property="id" />" />
<table border="0">
	<tr>
		<td>
			Status:
		</td>
		<td>
			<bean:define name="customer" property="status" id="status" />
			<select name="customerStatusId">
				<logic:iterate name="customerStatuses" id="customerStatus">
					<option value="<bean:write name="customerStatus" property="id" />"
					<logic:equal name="customerStatus" property="description" value="<%= ((com.pfe.crm.domain.type.CustomerStatus) status).getDescription() %>" >
						selected
					</logic:equal>
					>
					
						<bean:write name="customerStatus" property="description" />
					</option>
				</logic:iterate>
			</select>
		</td>
	</tr>
	<tr height="4"><td></td></tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="Save">
			&nbsp;&nbsp;
			<input type="button" value="Cancel" onClick="history.back()" />			
		</td>
	</tr>
</table>
</form>
	
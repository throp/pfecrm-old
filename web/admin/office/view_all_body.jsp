<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<th>Name</th>
		<th></th>
	</tr>
	<logic:iterate name="offices" id="office">
	<tr height="22">
		<td>
			<bean:write name="office" property="name" />
		</td>
	</tr>
	<tr height="1" class="colorXSubtle"><td colspan="50"></td></tr>		
	</logic:iterate>
	<tr>
		<th colspan="100"></th>
	</tr>
</table>
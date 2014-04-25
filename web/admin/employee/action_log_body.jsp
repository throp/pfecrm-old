<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<bean:define name="ndg.report" property="header" id="employee" />
Employee: <bean:write name="employee" property="firstName" />
<br>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<th width="75">Date</th>
		<th width="75">Time</th>
		<th>Description</th>
	</tr>
	<logic:empty name="ndg.report" property="currentPage" >
		<tr>
			<td colspan="3"><i>--no actions--</i></td>
		</tr>
	</logic:empty>
	<logic:iterate name="ndg.report" property="currentPage" id="actionLog" >
		<tr height="23">
			<td>
				<bean:write name="actionLog" property="date" format="M/d/yy" />
			</td>
			<td>
				<bean:write name="actionLog" property="time" format="hh:mm a" />
			</td>
			<td>
				<bean:write name="actionLog" property="description" />
			</td>
		</tr>
		<tr height="1"><td colspan="3" class="colorXSubtle"></td></tr>
	</logic:iterate>
	<tr>
		<th height="1" colspan="3"></th>
	</tr>
</table>
<br>
<jsp:include page="link_bar.jsp" flush="true" />
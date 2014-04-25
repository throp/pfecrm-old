<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>
<jsp:include page="top.jsp">
	<jsp:param name="title" value="Delete Location" />
</jsp:include>

<table border="0">
	<tr>
		<td>
			Are you sure you want to delete the <a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="id" />"><bean:write name="name"  /></a> location and related information?
		</td>
	</tr>
	<tr height="15"><td></td></tr>
	<tr>
		<td align="center">
			<form action="/CRM/DeleteLocationAction.do" method="POST">
				<input type="hidden" name="id" value="<bean:write name="id" />">
				<input type="hidden" name="name" value="<bean:write name="name" />">
				<input type="submit" value="Yes">

			&nbsp;&nbsp;
			<input type="button" value="No" onClick="history.back()" />
			</form>			
		</td>
	</tr>
</table>
<br>
<br>
<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />
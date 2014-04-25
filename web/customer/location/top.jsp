<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>

<table border="0" cellspacing="0" cellpadding="0" width="700">
	<tr>
		<td>
			<b>
				<logic:notPresent name="location" >
					<logic:equal parameter="title" value="Name" >
						<logic:present name="ndg.report">
							<bean:define name="ndg.report" property="header" id="service" />
							<bean:define name="service" property="location" id="location" />
						</logic:present>
					</logic:equal>
				</logic:notPresent>	
				<logic:equal parameter="title" value="Name">
					<logic:present parameter="secondTitle">
						<a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />">
					</logic:present>
					<bean:write name="location" property="name" />
					<logic:present parameter="secondTitle">
						</a>
					</logic:present>
				</logic:equal>
				<logic:notEqual parameter="title" value="Name">
					<%= request.getParameter("title") %>
				</logic:notEqual>
			</b>
			<logic:present parameter="secondTitle" >
					> &nbsp;
					<logic:present parameter="thirdTitle" >
						<logic:equal parameter="secondTitle" value="Services">
							<a href="/CRM/ViewServicesAction.do?locationId=<bean:write name="location" property="id" />">
						</logic:equal>
					</logic:present>
					<%= request.getParameter("secondTitle") %>
					<logic:present parameter="thirdTitle" >
						<logic:equal parameter="secondTitle" value="Services">
							</a>
						</logic:equal>
					</logic:present>	
					&nbsp;				
			</logic:present>
			<logic:present parameter="thirdTitle" >
					> &nbsp; 
					<logic:present parameter="fourthTitle" >
						<a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />"><%= request.getParameter("thirdTitle") %></a>
					</logic:present>
					<logic:notPresent parameter="fourthTitle" >
						<%= request.getParameter("thirdTitle") %>
					</logic:notPresent>
			</logic:present>
			<logic:present parameter="fourthTitle" >
					> &nbsp; <%= request.getParameter("fourthTitle") %>
			</logic:present>
		</td>
		<td align="right">
			<jsp:include page="options.jsp" flush="true" />
		</td>
	</tr>
</table>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="700">
	<tr>
		<td>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<table border="0" cellspacing="0" cellpadding="0" width="902" align="center">
	<tr height="1">
		<td class="colorMain" width="1" rowspan="100"></td>
		<td class="colorMain" width="900">
		</td>
		<td class="colorMain" width="1" rowspan="100"></td>		
	</tr>
	<tr height="25">
		<td bgcolor="white">
			<table border="0"  cellspacing="0" cellpadding="0" width="900">
				<tr>
					<td width="300">
						&nbsp;&nbsp;<a href="/CRM/" border="0"><img src="/CRM/images/logo_small.jpg" border="0" vspace="3" /></a>
					</td>
					<td width="300" align="right" valign="top">
			
					</td>
					<td width="300" align="right" valign="top" class="userBar">
						<logic:present name="employee">	
							Welcome
							<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="employee" property="id" />">
							<bean:write name="employee" property="firstName" />				
							<bean:write name="employee" property="lastName" /></a>.
							(<a href="/CRM/user/logout.jsp">Logout</a>)
							
						</logic:present>
						<logic:notPresent name="employee">
							not logged in.
						</logic:notPresent>							
						&nbsp;					
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


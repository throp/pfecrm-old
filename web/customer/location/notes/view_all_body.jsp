<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>

<bean:define name="ndg.report" property="header" id="location" />
<table border="0" cellspacing="0" cellpadding="0" width="700">
	<tr>
		<td>
			<b><a href="/CRM/ViewLocationAction.do?locationId=<bean:write name="location" property="id" />"><bean:write name="location" property="name" /></a></b>
			&nbsp;> Notes
		</td>
		</td>
		<td align="right">
			<jsp:include page="../options.jsp" flush="true" />
		</td>
	</tr>
</table>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="700">
	<tr>
		<td>


	<table border="0" cellspacing="0" cellpadding="0" width="700">
		<tr>
			<th width="100">&nbsp;Date</th>
			<th width="100">Employee</th>
			<th width="400">Note</th>
			<th width="100"></th>
		</tr>
		<tr height="2"><td colspan="4"></td></tr>		
		<logic:empty name="ndg.report" property="currentPage" >
		<tr>
			<td colspan="5">-no location notes-</td>
		</tr>
		</logic:empty>
		<logic:iterate name="ndg.report" property="currentPage" id="note">
		<tr height="2"><td colspan="4"></td></tr>		
		<tr height="25">
			<td valign="top">
				&nbsp;
				<bean:write name="note" property="enteredDate" format="M/dd/yy" />
			</td>
			<td valign="top">
				<bean:define name="note" property="employee" id="employee" />
				<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="employee" property="id" />"><bean:write name="employee" property="firstName" />
				<bean:write name="employee" property="lastName" /></a>
			</td>
			<td valign="top">
				<bean:write name="note" property="note" />
			</td>
			<td align="right" valign="top">
				<a href="/CRM/GoToDeleteLocationNoteAction.do?locationId=<bean:write name="location" property="id" />&id=<bean:write name="note" property="id" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
			</td>									
		</tr>
		<tr height="1" class="colorXSubtle"><td colspan="5"></td></tr>			
		</logic:iterate>
		<tr height="1"><th colspan="4"></th></tr>
	</table>
<br>
<br>

<table border="0" cellspacing="0" cellpadding="0" width="700" class="colorXSubtle">
	<tr height="1">
		<td class="colorMain" width="1" rowspan="500">
		<td class="colorMain" width="4">
		<td class="colorMain" width="690">
		<td class="colorMain" width="4">
		<td class="colorMain" width="1" rowspan="500">
	</tr>
	<tr height="50">
		<td></td>
		<td valign="top">
			<b>Add Note</b><br>
			<script language="javascript" src="/CRM/js/validation.js" ></script>
			<script language="javascript">
				function validateLocationNote()
				{
					if(isEmpty(frmLocationNote.note, 'Note', 'true')) {
						return false;
					}
					
					return true;
				}
			</script>
			<form name="frmLocationNote" action="/CRM/AddLocationNoteAction.do" method="POST" onSubmit="return validateLocationNote();">
			<input type="hidden" name="locationId" value="<bean:write name="location" property="id" />">
			<table border="0" width="690">
				<tr>
					<td valign="top">Note:</td>
					<td>
						<textarea name="note" cols="90"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add>"></td>
				</tr>
			</table>
			<br>
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
<br>
	
	
<jsp:include page="../bottom.jsp" flush="true" />
<jsp:include page="../../customer_bottom.jsp" flush="true" />
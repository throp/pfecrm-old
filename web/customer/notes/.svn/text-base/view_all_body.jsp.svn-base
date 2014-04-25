<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="notes" />
</jsp:include>
<jsp:include page="top.jsp" >
	<jsp:param name="title" value="View All" />
</jsp:include>

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
			<td colspan="5">-no customer notes-</td>
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
				<a href="/CRM/GoToDeleteCustomerNoteAction.do?id=<bean:write name="note" property="id" />" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
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
				function validateCustomerNote()
				{
					if(isEmpty(frmCustomerNote.note, 'Note', 'true')) {
						return false;
					}
					
					return true;
				}
			</script>
			<form name="frmCustomerNote" action="/CRM/AddCustomerNoteAction.do" method="POST" onSubmit="return validateCustomerNote();">
			<input type="hidden" name="customerId" value="<bean:write name="customer" property="id" />">
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

<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />
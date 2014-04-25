<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../top.jsp" flush="true" >
	<jsp:param name="section" value="notes" />
</jsp:include>
<jsp:include page="top.jsp" >
	<jsp:param name="title" value="Add" />
</jsp:include>
	

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
<table border="0" width="700">
	<tr>
		<td valign="top">Note:</td>
		<td>
			<textarea name="note" cols="90"></textarea>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Add Note>"></td>
	</tr>
</table>
<br>
</form>
<jsp:include page="bottom.jsp" flush="true" />
<jsp:include page="../customer_bottom.jsp" flush="true" />
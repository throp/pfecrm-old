<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<script>
	var serviceId;
	function showDeleteService(sId) {
		serviceId = sId;
		showDialogBox("dlgDelete");
	}
</script>


<div id="dlgDelete"  class="dialog" >
	<table class="dialog" width="400">
		<tr>							
			<th>Delete Service</th>
			<th class="closeDialog"><a href="javascript:void(0);" class="closeDialog"><img src="/CRM/images/close.gif" class="dialog"  onClick="hideDialogBox('dlgDelete');" /></th>
		</tr>					
		<tr>
			<td align="left">
		Are you sure you'd like to delete this service and all related inventory?
			</td>
		</tr>
		<tr>
			<td align="center">
					<input type="button" value="Delete" onClick="top.document.location.href='/CRM/DeleteServiceAction.do?serviceId=' + serviceId" />
					<input type="button" value="Cancel" onClick="javascript:hideDialogBox('dlgDelete');" />
				</form>
			</td>
		</tr>
	</table>
</div>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<script>
	var fireExtinguisherId;
	function showDelete(fId) {
		fireExtinguisherId = fId;
		showDialogBox("dlgDelete");
	}
</script>


<div id="dlgDelete"  class="dialog" >
	<table class="dialog" width="400">
		<tr>							
			<th>Delete Fire Extinguisher</th>
			<th class="closeDialog"><a href="javascript:void(0);" class="closeDialog"><img src="/CRM/images/close.gif" class="dialog"  onClick="hideDialogBox('dlgDelete');" /></th>
		</tr>					
		<tr>
			<td align="left">
		Are you sure you'd like to delete this fire extinguisher?  
			</td>
		</tr>
		<tr>
			<td align="center">
					<input type="button" value="Delete" onClick="top.document.location.href='/CRM/DeleteFireExtinguisherAction.do?inventoryItemId=' + fireExtinguisherId + '&locationId=<bean:write name="location" property="id" />';" />
					<input type="button" value="Cancel" onClick="javascript:hideDialogBox('dlgDelete');" />
				</form>
			</td>
		</tr>
	</table>
</div>
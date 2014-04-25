<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<script>
	var weightId;
	function showDeleteWeight(wId) {
		weightId = wId;
		showDialogBox("dlgDelete");
	}
</script>


<div id="dlgDelete"  class="dialog" >
	<table class="dialog" width="400">
		<tr>							
			<th>Delete Weight</th>
			<th class="closeDialog"><a href="javascript:void(0);" class="closeDialog"><img src="/CRM/images/close.gif" class="dialog"  onClick="hideDialogBox('dlgDelete');" /></th>
		</tr>					
		<tr>
			<td align="left">
		Are you sure you'd like to delete or de-activate this weight?  
			</td>
		</tr>
		<tr>
			<td align="center">
					<input type="button" value="Delete" onClick="top.document.location.href='/CRM/DeleteWeightAction.do?weightId=' + weightId" />
					<input type="button" value="Cancel" onClick="javascript:hideDialogBox('dlgDelete');" />
				</form>
			</td>
		</tr>
	</table>
</div>
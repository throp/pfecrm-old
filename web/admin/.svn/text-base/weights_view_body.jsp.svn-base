<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<table cellspacing="0" class="data" align="center">
	<thead>
	<tr>
		<th>Lbs</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<logic:iterate name="weights" id="weight" >
	<tr	
		<logic:equal name="weight" property="isActive" value="false">
			class="inactive"
		</logic:equal>				
		>
		<td>&nbsp;<bean:write name="weight" property="pounds" format="##.##"/></td>
		<td align="right">
		<logic:equal name="weight" property="isActive" value="true">
			<a href="javascript:showDeleteWeight(<bean:write name="weight" property="id" />)" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
		</logic:equal>		
		<logic:equal name="weight" property="isActive" value="false">

		</logic:equal>					
		</td>
	</tr>	
	</logic:iterate>
	</tbody>
	<tfoot>
	<tr height="1">
		<td colspan="2" ></td>
	</tr>
	</tfoot>
</table>
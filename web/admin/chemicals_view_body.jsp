<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<table cellspacing="0" class="data" align="center">
	<thead>
	<tr>
		<th>Name</th>
		<th>Abbreviation</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<logic:iterate name="chemicals" id="chemical" >
	<tr	
		<logic:equal name="chemical" property="isActive" value="false">
			class="inactive"
		</logic:equal>				
		>
		<td><bean:write name="chemical" property="name" /></td>
		<td><bean:write name="chemical" property="abbreviation" /></td>			
		<td align="right">
		<logic:equal name="chemical" property="isActive" value="true">
			<a href="javascript:showDeleteChemical(<bean:write name="chemical" property="id" />)" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
		</logic:equal>		
		<logic:equal name="chemical" property="isActive" value="false">

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
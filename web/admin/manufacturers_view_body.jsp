<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<table cellspacing="0" class="data" align="center">
	<thead>
	<tr>
		<th>Name</th>
		<th>Abbreviation</th>
		<th>Fire Extinguisher</th> 
		<th></th>
	</tr>
	</thead>
	<tbody>
	<logic:iterate name="manufacturers" id="manufacturer" >
	<tr	
		<logic:equal name="manufacturer" property="isActive" value="false">
			class="inactive"
		</logic:equal>				
		>
		<td><bean:write name="manufacturer" property="name" /></td>
		<td><bean:write name="manufacturer" property="abbreviation" /></td>
		<td align="left">
			<logic:equal name="manufacturer" property="isFireExtinguisher" value="true" >
				Yes
			</logic:equal>
		</td>
		<td align="right">
		<logic:equal name="manufacturer" property="isActive" value="true">
			<a href="javascript:showDeleteManufacturer(<bean:write name="manufacturer" property="id" />)" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
		</logic:equal>		
		<logic:equal name="manufacturer" property="isActive" value="false">

		</logic:equal>					
		</td>		
	</tr>
	</logic:iterate>
	</tbody>
	<tfoot>
	<tr height="1">
		<td colspan="4" ></td>
	</tr>
	</tfoot>
</table>
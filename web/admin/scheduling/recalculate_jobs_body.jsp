<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>

<span class="textDisclaimer">Important Note: &nbsp; This is an advanced feature.  Do not do this unless you know what you are doing.</span>
<br>
<br>
<form method="POST" action="/CRM/CalculateJobScheduleAction.do" >
<table border="0" cellpadding="2" cellspacing="2">
	<tr>
		<td>Year:&nbsp;</td>
		<td>
			<select name="year">
				<logic:iterate name="years" id="year" >
					<option value="<bean:write name="year" />"><bean:write name="year" /></option>
				</logic:iterate>
			</select>	
		</td>
		<td>
			<input type="submit" value="Recalculate" />
		</td>
	</tr>
</table>
</form>
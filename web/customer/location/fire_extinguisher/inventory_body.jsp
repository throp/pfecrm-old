<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/ndg-report" prefix="report" %>
<jsp:include page="../../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>

<jsp:include page="../top.jsp" >
	<jsp:param name="title" value="Name" />
	<jsp:param name="secondTitle" value="Services" />
	<jsp:param name="thirdTitle" value="Fire Extinguisher" />
</jsp:include>

<%@ include file="../service/edit.jsp" %>

<br>
<br><table border="0" cellpadding="0" cellspacing="0" width="700">

	<tr>
		<th width="45"><a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />&sortBy=f.year">Year</a></th>
		<th width="85"><a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />&sortBy=m.name">Manuf.</a></th>
		<th width="70"><a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />&sortBy=w.pounds">Weight</a></th>
		<th width="60"><a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />&sortBy=c.name">Chem</a></th>
		<th width="170"><a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />&sortBy=f.floor">Location</a></th>
		<th width="45"><a href="/CRM/ViewServiceAction.do?serviceId=<bean:write name="service" property="id" />&sortBy=f.testYear">Test Year</a></th>
		<th width="45">Test Type</th>
		<th width="50">Lckd</th>
		<th width="70">Serviced</th>		
		<th width="60"></th>
	</tr>
	<logic:empty name="fireExtinguishers">
		<tr>
			<td colspan="10">-No inventory added-</td>
		</tr>
	</logic:empty>
	<logic:iterate name="fireExtinguishers" id="fireExtinguisher">
	<tr height="25">
		<td class="textSmall">
			<bean:define name="fireExtinguisher" property="year" id="year" />
			<bean:write name="year" property="year" />
		</td>
		<td class="textSmall">
			<bean:define name="fireExtinguisher" property="manufacturer" id="manufacturer" />
			<span title="<bean:write name="manufacturer" property="name" />">
				<bean:write name="manufacturer" property="abbreviation" />
			</span>
		</td>
		<td class="textSmall">
			<bean:define name="fireExtinguisher" property="weight" id="weight" />
			<bean:write name="weight" property="pounds"  format="##.##"/>
			lbs
		</td>
		<td class="textSmall">
			<bean:define name="fireExtinguisher" property="chemical" id="chemical" />
			<span title="<bean:write name="chemical" property="name" />">
				<bean:write name="chemical" property="abbreviation" />
			</span>
		</td>
		<td class="textSmall">
			<bean:define name="fireExtinguisher" property="floor" id="floor" />
			<logic:notEqual name="floor" property="number" value="-1" >
				<bean:write name="floor" property="description" />, 
			</logic:notEqual>
			<bean:write name="fireExtinguisher" property="location" />
		</td>
		<td>
			<logic:notEmpty name="fireExtinguisher" property="testYear" >
				<bean:define name="fireExtinguisher" property="testYear" id="testYear" />
				<bean:write name="testYear" property="year" />
			</logic:notEmpty>
		</td>
		<td class="textSmall">
			<logic:notEmpty name="fireExtinguisher" property="testType" >
				<bean:define name="fireExtinguisher" property="testType" id="testType" />
				<bean:write name="testType" property="abbreviation" />
			</logic:notEmpty>
		</td>
		<td align="center" class="textSmall">
			<input type="checkbox"
				<logic:equal name="fireExtinguisher" property="isLocked" value="true">
					checked
				</logic:equal>
			>
		</td>	
		<td>
			<logic:notEmpty name="fireExtinguisher" property="serviceType" >
				<bean:define name="fireExtinguisher" property="serviceType" id="serviceType" />
				<bean:write name="serviceType" property="abbreviation" />
			</logic:notEmpty>			
		</td>
		<td align="right">
			<a href="/CRM/ViewFireExtinguisherAction.do?fireExtinguisherId=<bean:write name="fireExtinguisher" property="id" />" border="0"><img src="/CRM/images/edit.jpg" border="0"></a>
			<a href="javascript:showDelete(<bean:write name="fireExtinguisher" property="id" format="#" />);" border="0"><img src="/CRM/images/trash.gif" border="0"></a>
		</td>
	</tr>
	<tr height="1" class="colorXSubtle"><td colspan="10"></td></tr>
	</logic:iterate>
	<tr>
		<th colspan="10"></th>
	</tr>
	<tr height="3"><td colspan="10"></td></tr>
	
	<form action="/CRM/AddFireExtinguisherAction.do" name="frmExtinguisher" method="POST" onSubmit="return validateFireExtinguisher();">
	<input type="hidden" name="serviceId" value="<bean:write name="service" property="id" />">	
	<tr>
		<td valign="top" > 
			<input type="text" name="year" size="4" id="year" />
		</td>
		<td valign="top"  class="textSmall">
			<select name="manufacturerId">
				<option></option>
				<logic:iterate name="manufacturers" id="manufacturer" scope="application">
					<option value="<bean:write name="manufacturer" property="id" />">
						<bean:write name="manufacturer" property="abbreviation" />
					</option>
				</logic:iterate>
			</select>
		</td>
		<td valign="top"  class="textSmall">
				<select name="weightId">
					<option></option>
					<logic:iterate name="weights" id="weight">
						<option value="<bean:write name="weight" property="id"/>">
							<bean:write name="weight" property="pounds" format="##.##" /> lbs
						</option>
					</logic:iterate>
				</select>		
		</td>
		<td valign="top"  class="textSmall">
			<select name="chemicalId">
				<option></option>
				<logic:iterate name="chemicals" id="chemical" scope="application">
					<option value="<bean:write name="chemical" property="id" />">
						<bean:write name="chemical" property="abbreviation" />
					</option>
				</logic:iterate>
			</select>					
		</td>
		<td valign="top"  class="textSmall">
			<input type="text" name="floor" size="1"> floor,

			&nbsp;
			<input type="text" name="location" size="10">
		</td>
		<td class="textSmall">
			<input type="text" name="testYear" size="3" />
		</td>
		<td>
			<select name="testType">
				<option></option>
				<logic:iterate name="fireExtinguisherTestTypes" id="testType" scope="application">
					<option value="<bean:write name="testType" property="id" />">
						<bean:write name="testType" property="abbreviation" />
					</option>
				</logic:iterate>
			</select>
		</td>
		<td valign="top" align="center" class="textSmall">
			<input type="checkbox" name="isLocked" />
		</td>		
		<td valign="top" colspan="2" class="textSmall">
			<select name="serviceType">
				<option></option>
				<logic:iterate name="fireExtinguisherServiceTypes" id="serviceType" scope="application">
					<option value="<bean:write name="serviceType" property="id" />">
						<bean:write name="serviceType" property="abbreviation" />
					</option>
				</logic:iterate>
			</select>		
			<input type="submit" value="+">
		</td>
	</tr>
	</form>	
</table>
<br>
<br>
<jsp:include page="link_bar.jsp" flush="true" />
<br>
<a name="bottom">&nbsp;</a>
<jsp:include page="../bottom.jsp" flush="true" />						
<jsp:include page="../../customer_bottom.jsp" flush="true" />					
	
<script language="javascript">
	<logic:equal name="isAdd" value="yes" >
		location="#bottom";
		var txtYear = top.document.getElementById('year');
		txtYear.focus();		
		txtYear.select();
	</logic:equal>
</script>
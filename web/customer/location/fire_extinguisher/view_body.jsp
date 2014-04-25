<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<jsp:include page="../../top.jsp" flush="true" >
	<jsp:param name="section" value="locations" />
</jsp:include>

<jsp:include page="../top.jsp" >
	<jsp:param name="title" value="Name" />
	<jsp:param name="secondTitle" value="Services" />
	<jsp:param name="thirdTitle" value="Fire Extinguisher" />
	<jsp:param name="fourthTitle" value="Edit" />
</jsp:include>

	<form action="/CRM/AddFireExtinguisherAction.do" >
	<input type="hidden" name="fireExtinguisherId" value="<bean:write name="fireExtinguisher" property="id" />">
	<table border="0" cellspacing="3" cellpadding="3">
		<tr>
			<td>Year:</td>
			<td>
				<logic:empty name="fireExtinguisher" property="year">
					<input type="text" name="year" value="" size="5" maxlength="4" />
				</logic:empty>
				<logic:notEmpty name="fireExtinguisher" property="year">
					<bean:define name="fireExtinguisher" property="year" id="year" />
					<input type="text" name="year" value="<bean:write name="year" property="year" />" size="5">			
				</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<td>Manufacturer:&nbsp;</td>
			<td>
				<bean:define name="fireExtinguisher" property="manufacturer" id="feManufacturer" />
				<select name="manufacturerId">
					<logic:iterate name="manufacturers" id="manufacturer">
						<option value="<bean:write name="manufacturer" property="id" />"
						<logic:equal name="manufacturer" property="name" value="<%= ((com.pfe.crm.domain.entity.Manufacturer) feManufacturer).getName() %>" >
							selected
						</logic:equal>
						>
							<bean:write name="manufacturer" property="name" />
						</option>
					</logic:iterate>
				</select>					
			</td>
		</tr>
		<tr>
			<td>Weight:</td>
			<td>
				<bean:define name="fireExtinguisher" property="weight" id="feWeight" />
				<select name="weightId">
					<logic:iterate name="weights" id="weight">
						<option value="<bean:write name="weight" property="id" />"
						<logic:equal name="weight" property="description" value="<%= ((com.pfe.crm.domain.entity.Weight) feWeight).getDescription() %>" >
							selected
						</logic:equal>
						>
							<bean:write name="weight" property="pounds" />
						</option>
					</logic:iterate>
				</select>	
			</td>
		</tr>
		<tr>
			<td>Chemical:</td>
			<td>
				<bean:define name="fireExtinguisher" property="chemical" id="feChemical" />
				<select name="chemicalId">
					<logic:iterate name="chemicals" id="chemical">
						<option value="<bean:write name="chemical" property="id" />"
						<logic:equal name="chemical" property="name" value="<%= ((com.pfe.crm.domain.entity.Chemical) feChemical).getName() %>" >
							selected
						</logic:equal>
						>
							<bean:write name="chemical" property="name" />
						</option>
					</logic:iterate>
				</select>	
			</td>
		</tr>
		<tr>
			<td>Location:</td>
			<td>
				<input type="text" name="location" value="<bean:write name="fireExtinguisher" property="location" />" size="50"/>
			</td>
		</tr>
		<tr>
			<td>Test Year:</td>
			<td>
				<logic:empty name="fireExtinguisher" property="testYear">
					<input type="text" name="testYear" value="" size="5" maxlength="4" />
				</logic:empty>
				<logic:notEmpty name="fireExtinguisher" property="testYear">
					<bean:define name="fireExtinguisher" property="testYear" id="testYear" />
					<input type="text" name="testYear" value="<bean:write name="testYear" property="year" />" size="5">			
				</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<td>Test Type:</td>
			<td>
				<logic:empty name="fireExtinguisher" property="testType">
					<select name="testType">
						<option></option>
						<logic:iterate name="fireExtinguisherTestTypes" id="testType" scope="application">
							<option value="<bean:write name="testType" property="id" />">
								<bean:write name="testType" property="abbreviation" />
							</option>
						</logic:iterate>
					</select>					
				</logic:empty>
				<logic:notEmpty name="fireExtinguisher" property="testType">
					<bean:define name="fireExtinguisher" property="testType" id="feTestType" />
					<select name="testType">
						<logic:iterate name="fireExtinguisherTestTypes" id="testType">
							<option value="<bean:write name="testType" property="id" />"
							<logic:equal name="testType" property="name" value="<%= ((com.pfe.crm.domain.type.FireExtinguisherTestType) feTestType).getName() %>" >
								selected
							</logic:equal>
							>
								<bean:write name="testType" property="name" />
							</option>
						</logic:iterate>
					</select>		
				</logic:notEmpty>			
			</td>
		</tr>
		<tr>
			<td>Locked:</td>
			<td>
				<logic:equal name="fireExtinguisher" property="isLocked" value="true" >
					<input type="checkbox" name="isLocked" CHECKED />
				</logic:equal>
				<logic:notEqual name="fireExtinguisher" property="isLocked" value="true" >
					<input type="checkbox" name="isLocked"  />
				</logic:notEqual>				
			</td>
		</tr>
		<tr>
			<td>Serviced:</td>
			<td>				
				<logic:empty name="fireExtinguisher" property="serviceType">
					<select name="serviceType">
						<option></option>
						<logic:iterate name="fireExtinguisherServiceTypes" id="serviceType" scope="application">
							<option value="<bean:write name="serviceType" property="id" />">
								<bean:write name="serviceType" property="abbreviation" />
							</option>
						</logic:iterate>
					</select>		
				</logic:empty>
				<logic:notEmpty name="fireExtinguisher" property="serviceType">				
					<bean:define name="fireExtinguisher" property="serviceType" id="feServiceType" />
					<select name="serviceType">
						<logic:iterate name="fireExtinguisherServiceTypes" id="serviceType">
							<option value="<bean:write name="serviceType" property="id" />"
							<logic:equal name="serviceType" property="name" value="<%= ((com.pfe.crm.domain.type.FireExtinguisherServiceType) feServiceType).getName() %>" >
								selected
							</logic:equal>
							>
								<bean:write name="serviceType" property="name" />
							</option>
						</logic:iterate>
					</select>		
				</logic:notEmpty>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="Update Fire Extinguisher" />
			</td>
		</tr>
	</table>
	<br>

	</form>
	<jsp:include page="link_bar.jsp" flush="true" />
	<br>
<jsp:include page="../bottom.jsp" flush="true" />						
<jsp:include page="../../customer_bottom.jsp" flush="true" />				
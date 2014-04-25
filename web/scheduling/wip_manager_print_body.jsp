<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>



<table border="0" cellspacing="0" cellpadding="0">
	<tr><td>&nbsp;</td></tr>
<logic:iterate name="ndg.report" property="currentPage" id="job" >
<bean:define name="job" property="service" id="service" />
<bean:define name="service" property="serviceType" id="serviceType" />
<bean:define name="service" property="location" id="location" />
<bean:define name="location" property="customer" id="customer" />
<bean:define name="job" property="roadTechnician" id="roadTechnician" />
	<tr height="1"><td colspan="3" bgcolor="black"></td></tr>
	<tr>
		<td width="300" class="textH2"><bean:write name="customer" property="name" /></td>
		<td width="300" class="textH2"><bean:write name="location" property="name" /></td>
		<td width="200" class="textH2"><bean:write name="serviceType" property="name" /></td>
	</tr>
	<tr height="1"><td colspan="3" bgcolor="black"></td></tr>	
	<tr>
		<td colspan="3"> 
			<br>
			<table border="0" width="800">
				<tr>
					<td rowspan="500" width="50"></td>
					<td valign="top">
						<table>
							<tr>
								<td valign="top">
									<table width="350">
										<tr>
											<td valign="top"><i>Address</i>:</td>
											<td>
												<bean:write name="location" property="address1" />
												<bean:write name="location" property="address2" />
												<br>
												<bean:write name="location" property="city" />
												, <bean:write name="location" property="state" />
												<bean:write name="location" property="zip" />
											</td>
										</tr>
									</table>
								</td>
								<td valign="top">
									<table width="350">
										<tr>
											<td  valign="top" width="130"><i>Customer Contact</i>: </td>
											<td width="*">
												<bean:write name="customer" property="primaryContactFirstName" />
												<bean:write name="customer" property="primaryContactLastName" />
													<logic:notEmpty name="customer" property="primaryContactTitle" >
														<br>
														(<bean:write name="customer" property="primaryContactTitle" />)
													</logic:notEmpty>
													-
													<bean:write name="customer" property="primaryContactPhoneNumber" />
											</td>
										</tr>
										<tr>
											<td><i>Location Contact</i>: </td>
											<td>
												<bean:write name="location" property="contactFirstName" />
												<bean:write name="location" property="contactLastName" />
													<logic:notEmpty name="location" property="contactTitle" >
														<br>
														(<bean:write name="location" property="contactTitle" />)
													</logic:notEmpty>
													-
													<bean:write name="location" property="contactPhoneNumber" />							
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td><i>Serviced</i>:</td>
								<td>
									&nbsp;
									<bean:write name="job" property="dateInRoadTechQueue" format="MM/dd/yyyy" />,
									<bean:write name="roadTechnician" property="firstName" />
									<bean:write name="roadTechnician" property="lastName" />
								</td>
							</tr>
							<tr>
								<td><i>Shop Work</i>:</td>
								<td>
									&nbsp;
									<logic:present name="job" property="dateInShopTechQueue" >
										<bean:write name="job" property="dateInShopTechQueue" format="MM/dd/yyyy" /> - 
									</logic:present>
									<logic:present name="job" property="dateReadyForReturn" >
										<bean:write name="job" property="dateReadyForReturn" format="MM/dd/yyyy" />,
									</logic:present>									
									<logic:present name="job" property="shopTechnician" >
										<bean:define name="job" property="shopTechnician" id="shopTechnician" />
										<bean:write name="shopTechnician" property="firstName" />
										<bean:write name="shopTechnician" property="lastName" />
									</logic:present>									
						</table>
					</td>
				</tr>
			</table>
			<br>
			<br>
		</td>
	</tr>

</logic:iterate>
</table>
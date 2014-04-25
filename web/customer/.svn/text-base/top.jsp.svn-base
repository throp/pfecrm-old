<%@ taglib uri="/struts-html" prefix="html" %>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %> 
					<table border="0" cellspacing="0" cellpadding="0" width="800">
						<tr>
							<td valign="top" align="center">
								
								<br>
								<table border="0" cellspacing="0" cellpadding="0" width="800" bgcolor="gainsboro">
									<tr>
										<td width="1" class="colorMain" rowspan="500"></td>
										<td width="120" class="colorMain"></td>
										<td width="1" class="colorMain" rowspan="500"></td>
										<td width="120" class="colorMain"></td>
										<td width="1" class="colorMain" rowspan="500"></td>										
										<td width="120" class="colorMain"></td>
										<td width="1" class="colorMain" rowspan="500"></td>										
										<td width="120" class="colorMain"></td>
										<td width="1" class="colorMain" rowspan="500"></td>										
										<td width="120" class="colorMain"></td>
										<td width="1" class="colorMain" rowspan="500"></td>										
										<td width="120" class="colorMain"></td>
										<td width="1" class="colorMain" rowspan="500"></td>																				
										<td width="72" class="colorMain"></td>	
										<td width="1" class="colorMain" rowspan="500"></td>												
									</tr>
									<tr height="20">
										<!-- Contact -->
										<logic:equal parameter="section" value="billing">
										<td bgcolor="white" align="center"><a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" format="#" />"><span class="textH3">Billing</span></a></td>
										</logic:equal>
										<logic:notEqual parameter="section" value="billing">
										<td align="center"><a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" format="#" />"><span class="textH3">Billing</span></a></td>
										</logic:notEqual>												
										
										<!-- Locations -->
										<logic:equal parameter="section" value="locations">
										<td bgcolor="white" align="center"><a href="/CRM/ViewLocationsAction.do?id=<bean:write name="customer" property="id" format="#" />"><span class="textH3">Locations</span></a></td>
										</logic:equal>
										<logic:notEqual parameter="section" value="locations">
										<td align="center"><a href="/CRM/ViewLocationsAction.do?id=<bean:write name="customer" property="id" format="#" />"><span class="textH3">Locations</span></a></td>
										</logic:notEqual>	
										
										<!-- Revenue -->
										<logic:equal parameter="section" value="revenue">
										<td bgcolor="white" align="center"><a href="/CRM/ViewCustomerRevenueAction.do?customerId=<bean:write name="customer" property="id" />"><span class="textH3">Revenue</span></a></td>
										</logic:equal>
										<logic:notEqual parameter="section" value="revenue">
										<td align="center"><a href="/CRM/ViewCustomerRevenueAction.do?customerId=<bean:write name="customer" property="id" />"><span class="textH3">Revenue</span></a></td>
										</logic:notEqual>			
										
																		
										<!-- Notes -->
										<logic:equal parameter="section" value="notes">
										<td bgcolor="white" align="center"><a href="/CRM/ReportQuery.do?reportKey=CustomerNotes&id=<bean:write name="customer" property="id" />"><span class="textH3">Notes</span></a></td>
										</logic:equal>
										<logic:notEqual parameter="section" value="notes">
										<td align="center"><a href="/CRM/ReportQuery.do?reportKey=CustomerNotes&id=<bean:write name="customer" property="id" />"><span class="textH3">Notes</span></a></td>
										</logic:notEqual>		
										
										<!-- Investments -->
										<logic:equal parameter="section" value="investments">
										<td bgcolor="white" align="center"><a href="/CRM/customer/investments.jsp"><span class="textH3">Investments</span></a></td>
										</logic:equal>
										<logic:notEqual parameter="section" value="investments">
										<td align="center"><a href="/CRM/customer/investments.jsp"><span class="textH3">Investments</span></a></td>
										</logic:notEqual>	
										
										<!-- Sales -->
										<logic:equal parameter="section" value="sales">
										<td bgcolor="white" align="center"><a href="/CRM/customer/sales.jsp"><span class="textH3">Sales</span></a></td>
										</logic:equal>
										<logic:notEqual parameter="section" value="sales">
										<td align="center"><a href="/CRM/customer/sales.jsp"><span class="textH3">Sales</span></a></td>
										</logic:notEqual>	
										<td align="center"></td>
									</tr>	
									
									
									<tr>
										<!-- Contact -->
										<logic:equal parameter="section" value="billing">
										<td bgcolor="white"></td>										
										</logic:equal>
										<logic:notEqual parameter="section" value="billing">
										<td class="colorMain"></td>
										</logic:notEqual>			
																		
										<!-- Locations -->
										<logic:equal parameter="section" value="locations">
										<td bgcolor="white"></td>										
										</logic:equal>
										<logic:notEqual parameter="section" value="locations">
										<td class="colorMain"></td>
										</logic:notEqual>						
																
										<!-- Revenue -->
										<logic:equal parameter="section" value="revenue">
										<td bgcolor="white"></td>										
										</logic:equal>
										<logic:notEqual parameter="section" value="revenue">
										<td class="colorMain"></td>
										</logic:notEqual>		
										
										
										<!-- Notes -->
										<logic:equal parameter="section" value="notes">
										<td bgcolor="white"></td>										
										</logic:equal>
										<logic:notEqual parameter="section" value="notes">
										<td class="colorMain"></td>
										</logic:notEqual>		
										
										<!-- Investments -->
										<logic:equal parameter="section" value="investments">
										<td bgcolor="white"></td>										
										</logic:equal>
										<logic:notEqual parameter="section" value="investments">
										<td class="colorMain"></td>
										</logic:notEqual>		
										
										<!-- Sales -->
										<logic:equal parameter="section" value="sales">
										<td bgcolor="white"></td>										
										</logic:equal>
										<logic:notEqual parameter="section" value="sales">
										<td class="colorMain"></td>
										</logic:notEqual>		
										
										<td class="colorMain"></td>
										<td class="colorMain"></td>
									</tr>										
								</table>
								<table border="0" cellspacing="0" cellpadding="0" width="800">
									<tr height="">
										<td width="1" class="colorMain">
										<td width="798" align="center">
											<br>
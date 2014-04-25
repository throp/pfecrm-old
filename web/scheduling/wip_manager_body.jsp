<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<script src="/CRM/js/positioning.js" language="javascript"></script>
<script src="/CRM/js/dialog_box.js" language="javascript"></script>
<script src="/CRM/js/ajax.js" language="javascript"></script>

<script language="javascript" src="/CRM/js/validation.js" ></script>

<script>
	
	function setImageToCompleted(imgId) { 
		var imgJob = document.getElementById(imgId);
		imgJob.src = "/CRM/images/green_check.jpg";
	}
		
	function validate()
	{
		if(!isEmpty(frmFilter.shopTechEmployeeId, 'Shop Tech', false) && 
		   !isEmpty(frmFilter.roadTechEmployeeId, 'Road Tech', false)) 
		{
			alert('You cannot filter by shop tech and road tech simultaneously.');
			return false;
		}
	}
	var currentDialogBox;
	
	function readyForReturn() { 
		sendRequest("/CRM/UpdateJobReadyForReturnAction.do?jobId=" + currentDialogBox.dataId);

		setImageToCompleted("img" + currentDialogBox.dataId);		
		currentDialogBox.hide();
		currentDialogBox = null;
	}

	function showShopWorkComplete(jobId) { 		
		if(currentDialogBox != null) { 
			currentDialogBox.hide();
		}
		
		var imgJob = document.getElementById("img" + jobId);
		if(imgJob.src.indexOf("green_check") <= 0) {
			var imgJobTop = getImageTop(imgJob);
			var imgJobLeft = getImageLeft(imgJob);
			
			currentDialogBox = new DialogBox();
			currentDialogBox.id = "dlgShopWorkComplete";
			currentDialogBox.top = imgJobTop - 85;
			currentDialogBox.left = imgJobLeft + 15;
			currentDialogBox.dataId = jobId;
			currentDialogBox.show();
		}
	}		
	
	function readyToBill() { 
		sendRequest("/CRM/UpdateJobReadyToBillAction.do?jobId=" + currentDialogBox.dataId);

		setImageToCompleted("img" + currentDialogBox.dataId);		
		currentDialogBox.hide();
		currentDialogBox = null;
	}

	function showReturnComplete(jobId) { 		
		if(currentDialogBox != null) { 
			currentDialogBox.hide();
		}
		
		var imgJob = document.getElementById("img" + jobId);
		if(imgJob.src.indexOf("green_check") <= 0) {
			var imgJobTop = getImageTop(imgJob);
			var imgJobLeft = getImageLeft(imgJob);
			
			currentDialogBox = new DialogBox();
			currentDialogBox.id = "dlgReturnComplete";
			currentDialogBox.top = imgJobTop - 62;
			currentDialogBox.left = imgJobLeft + 15;
			currentDialogBox.dataId = jobId;
			currentDialogBox.show();
		}
	}	
	
	function release() { 
		sendRequest("/CRM/UpdateJobReleaseAction.do?jobId=" + currentDialogBox.dataId);

		setImageToCompleted("img" + currentDialogBox.dataId);		
		currentDialogBox.hide();
		currentDialogBox = null;
	}

	function assignShopTech() { 
		var employeeId = document.getElementById("assignShopTechEmployeeId");
		if(isEmpty(employeeId, 'Employee', 'true')) { 
			return false;
		}

		sendRequest("/CRM/UpdateJobAssignShopTechAction.do?jobId=" + currentDialogBox.dataId + "&employeeId=" + employeeId.value);
		setImageToCompleted("img" + currentDialogBox.dataId);		
		currentDialogBox.hide();		
		currentDialogBox = null;
	}

	function showServiceComplete(jobId) { 		
		if(currentDialogBox != null) { 
			currentDialogBox.hide();
		}
		
		var imgJob = document.getElementById("img" + jobId);
		if(imgJob.src.indexOf("green_check") <= 0) {
			var imgJobTop = getImageTop(imgJob);
			var imgJobLeft = getImageLeft(imgJob);
			
			currentDialogBox = new DialogBox();
			currentDialogBox.id = "dlgServiceComplete";
			currentDialogBox.top = imgJobTop - 110;
			currentDialogBox.left = imgJobLeft + 15;
			currentDialogBox.dataId = jobId;
			currentDialogBox.show();
		}
	}		
</script>

<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<td align="right"><a href="/CRM/ReportRedirect.do?reportKey=WiPManager&alternateForward=WiPManagerPrint">Print Queue</a></td>
	</tr>
</table>
<br>
<table border="0" cellspacing="0" cellpadding="0" width="800">
	<tr>
		<th valign="top" colspan="2">Customer</th>
		<th valign="top" >Location</th>
		<th valign="top" >Type</th>
		<td valign="top" width="1" bgcolor="black"></td>
		<th valign="top" colspan="2">&nbsp;Service</th>
		<td valign="top" width="1" bgcolor="black"></td>
		<th valign="top" colspan="3">&nbsp;Shop Work</th>
		<td valign="top" width="1" bgcolor="black"></td>
		<th valign="top" colspan="2">&nbsp;Return</th>		
		<td valign="top" width="1" bgcolor="black"></td>
		<th valign="top"  width="40" style="text-align: right">&nbsp;Days</th>
		<th width="15"></th>
	</tr>
	<logic:iterate name="ndg.report" property="currentPage" id="job" >
	<bean:define name="job" property="service" id="service" />
	<bean:define name="service" property="serviceType" id="serviceType" />
	<bean:define name="service" property="location" id="location" />
	<bean:define name="location" property="customer" id="customer" />
	<bean:define name="job" property="roadTechnician" id="roadTechnician" />
	<bean:define id="bgcolor" value="white" />
		<tr height="23">
			<td class="textSmall" width="20">							
				<logic:equal name="job" property="isBeingServiced" value="true" >
							<a href="javascript:void(0);" border="0"><img id="img<bean:write name="job" property="id" />" onClick="showServiceComplete(<bean:write name="job" property="id" />, 'dlgServiceComplete')" src="/CRM/images/right_arrow.jpg" border="0"/></a>
				</logic:equal>
				<logic:equal name="job" property="isInShop" value="true" >
							<a href="javascript:void(0);" border="0"><img id="img<bean:write name="job" property="id" />" onClick="showShopWorkComplete(<bean:write name="job" property="id" />, 'dlgShopWorkComplete')" src="/CRM/images/right_arrow.jpg" border="0"/></a>
				</logic:equal>
				<logic:equal name="job" property="isBeingReturned" value="true" >
							<a href="javascript:void(0);" border="0"><img id="img<bean:write name="job" property="id" />" onClick="showReturnComplete(<bean:write name="job" property="id" />, 'dlgReturnComplete')" src="/CRM/images/right_arrow.jpg" border="0"/></a>
				</logic:equal>	
				
			</td>		
			<td class="textSmall">
				<a href="/CRM/ViewBillingAction.do?id=<bean:write name="customer" property="id" />"><bean:write name="customer" property="name" /></a>
			</td>
			<td>
				<a href="/CRM/ViewLocationAction.do?id=<bean:write name="location" property="id" />"><bean:write name="location" property="name" /></a>
			</td>
			<td class="textSmall">
				<bean:write name="serviceType" property="abbreviation" />
			</td>			
			<td bgcolor="black"></td>
			<logic:equal name="job" property="isBeingServiced" value="true" >
				<bean:define id="bgcolor" value="#cccccc" />
			</logic:equal>
			<logic:equal name="job" property="isBeingServiced" value="false" >
				<bean:define id="bgcolor" value="white" />
			</logic:equal>
			<td align="left" width="50" class="textSmall" bgcolor="<bean:write name="bgcolor" />">
			&nbsp;
			<logic:present name="job" property="dateInRoadTechQueue">
				<bean:write name="job" property="dateInRoadTechQueue" format="MM/dd" />
			</logic:present>
			&nbsp;
		</td>		
		<td class="textSmall" bgcolor="<bean:write name="bgcolor" />">
			<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="roadTechnician" property="id" />"><bean:write name="roadTechnician" property="lastName" /></a>
		</td>		

		<td bgcolor="black"></td>		
		<logic:equal name="job" property="isInShop" value="true" >
			<bean:define id="bgcolor" value="#cccccc" />
		</logic:equal>
		<logic:equal name="job" property="isInShop" value="false" >
			<bean:define id="bgcolor" value="white" />
		</logic:equal>		
		<logic:present name="job" property="dateInShopTechQueue" >
		<td class="textSmall" align="left" width="60" bgcolor="<bean:write name="bgcolor" />">
			&nbsp;
			<logic:present name="job" property="dateInShopTechQueue">
				<bean:write name="job" property="dateInShopTechQueue" format="MM/dd" />
			</logic:present>	
			&nbsp;-&nbsp;
		</td>				

		<logic:present name="job" property="dateReadyForReturn">		
		<td class="textSmall" align="left" width="50" bgcolor="<bean:write name="bgcolor" />">
				<bean:write name="job" property="dateReadyForReturn" format="MM/dd" />
		</td>
		</logic:present>
		<logic:notPresent name="job" property="dateReadyForReturn">
		<td class="textSmall" align="left" width="50" bgcolor="<bean:write name="bgcolor" />">
				??
		</td>
		</logic:notPresent>
		<td class="textSmall"  bgcolor="<bean:write name="bgcolor" />">
			<logic:present name="job" property="shopTechnician" >
				<bean:define name="job" property="shopTechnician" id="shopTechnician" />
				<a href="/CRM/ViewEmployeeAction.do?employeeId=<bean:write name="shopTechnician" property="id" />"><bean:write name="shopTechnician" property="lastName" /></a>
			</logic:present>
		</td>	
		</logic:present>	
		<logic:notPresent name="job" property="dateInShopTechQueue">
		<td colspan="3" bgcolor="<bean:write name="bgcolor" />">
			
		</td>
		</logic:notPresent>

		<td bgcolor="black"></td>		
		<logic:equal name="job" property="isBeingReturned" value="true" >
			<bean:define id="bgcolor" value="#cccccc" />
		</logic:equal>
		<logic:equal name="job" property="isBeingReturned" value="false" >
			<bean:define id="bgcolor" value="white" />
		</logic:equal>			
		<td class="textSmall" align="left" width="55" bgcolor="<bean:write name="bgcolor" />">
			&nbsp;
			<logic:present name="job" property="dateInReturnTechQueue">
				<bean:write name="job" property="dateInReturnTechQueue" format="MM/dd" />
			</logic:present>
		</td>
		<td class="textSmall"  bgcolor="<bean:write name="bgcolor" />">
			<logic:present name="job" property="returnTechnician" >
				<bean:define name="job" property="returnTechnician" id="returnTechnician" />
				<a href="/CRM/ViewEmployeeAciton.do?employeeId=<bean:write name="returnTechnician" property="id" />"><bean:write name="returnTechnician" property="lastName" /></a>
			</logic:present>
		</td>
		<td bgcolor="black"></td>				
		<td>
			&nbsp;&nbsp;&nbsp;<bean:write name="job" property="daysInProgress" />
		</td>
		<td>
			<a href="/CRM/ViewJobAction.do?jobId=<bean:write name="job" property="id" />" border="0"><img src="/CRM/images/edit.jpg" border="0" /></a>
		</td>
	</tr>
	<tr height="1">
		<td colspan="4" class="colorXSubtle"></td>
		<td bgcolor="black"></td>
		<td colspan="2" class="colorXSubtle"></td>
		<td bgcolor="black"></td>
		<td colspan="3" class="colorXSubtle"></td>
		<td bgcolor="black"></td>		
		<td colspan="2" class="colorXSubtle"></td>
		<td bgcolor="black"></td>		
		<td colspan="2" class="colorXSubtle"></td>				
	</tr>	
	</logic:iterate>
	<tr height="1">
		<td colspan="17" bgcolor="black"> </td>
	</tr>
</table>
</form>

<!-- Ready for billing dialog Box ------------------------------- -->
<jsp:include page="/includes/dialog_top.jsp" >
	<jsp:param name="title" value="Return Complete" />
	<jsp:param name="dialogBoxId" value="dlgReturnComplete" />
</jsp:include>
<table border="0" cellspacing="2" cellpadding="2">
	<tr>
		<td align="middle" width="280">
			<input type="button" onClick="readyToBill()" value="Return complete, ready to bill>" />
		</td>
	</tr>
</table>
<jsp:include page="/includes/dialog_bottom.jsp" />
	
<!-- Ready to be returned ------------------------------- -->
<jsp:include page="/includes/dialog_top.jsp" >
	<jsp:param name="title" value="Shop Work Complete" />
	<jsp:param name="dialogBoxId" value="dlgShopWorkComplete" />
</jsp:include>
<table border="0" cellspacing="2" cellpadding="2">
	<tr>
		<td align="middle" width="280">
			<input type="button" onClick="readyForReturn()" value="Shop work done, ready to be returned>" />
		</td>
	</tr>
</table>
<jsp:include page="/includes/dialog_bottom.jsp" />
	
	
<!-- Dialog box for after service ------------------------------- -->
<jsp:include page="/includes/dialog_top.jsp" >
	<jsp:param name="title" value="Service Complete" />
	<jsp:param name="dialogBoxId" value="dlgServiceComplete" />
</jsp:include>
<table border="0" cellspacing="2" cellpadding="2">
	<tr>
		<td align="left">
			&nbsp;1)&nbsp; <input type="button" onClick="release()" value="Release>" />
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;2)&nbsp;
				<select name="assignShopTechEmployeeId" id="assignShopTechEmployeeId">
				<option value="">-</option>
				<logic:iterate name="employees" id="employee" >
					<bean:define name="employee" property="employeeType" id="employeeType" />
					<logic:equal name="employeeType" property="description" value="Shop Technician">
					<option value="<bean:write name="employee" property="id" />">
						<bean:write name="employee" property="firstName" />
						<bean:write name="employee" property="lastName" />		
					</option>
					</logic:equal>
				</logic:iterate>
				</select>
				<input type="button" onClick="assignShopTech()" value="Assign Shop Tech>" />
		</td>
	</tr>			
	<tr>
		<td>
			&nbsp;3)&nbsp;
			<input type="button" onClick="readyToBill()" value="Ready to bill>" />
		</td>
	</tr>		
</table>
<jsp:include page="/includes/dialog_bottom.jsp" />
	

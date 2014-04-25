<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>


<script>	
	function hide<%= request.getParameter("dialogBoxId") %>() { 
		var techPopUp = document.getElementById("<%= request.getParameter("dialogBoxId") %>");
		techPopUp.style.visibility = 'hidden';
	}
</script>
<div id="<%= request.getParameter("dialogBoxId") %>"  style="visibility: hidden; position: absolute; left: 40%; top: 40%;" >
	<table border="0"  width="<%= request.getParameter("width") == null ? "300" : request.getParameter("width") %>" cellspacing="0" cellpadding="0">
		<tr height="1">
			<td width="1" class="colorMain" rowspan="500"></td>
			<td width="4" class="colorMain"></td>
			<td width="" class="colorMain"></td>
			<td width="14" class="colorMain"></td>
			<td width="1" class="colorMain" rowspan="500"></td>
		</tr>
		<tr height="26">							
			<td class="colorMain"></td>
			<td class="colorMain" >
				<b>
					<span style="color: white">
					<%= request.getParameter("title") %>
					</span>
				</b>
			</td>
			<td class="colorMain"  align="right"  valign="top" ><a href="javascript:void(0);" border="0"><img src="/CRM/images/close.gif" vspace="2" hspace="2" onClick="hide<%= request.getParameter("dialogBoxId") %>();" border="0"/></td>
		</tr>
		<tr height="5"><td colspan="3" class="colorXSubtle"></td></tr>
		<tr>
			<td  colspan="3" class="colorXSubtle">
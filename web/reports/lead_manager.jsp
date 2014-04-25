<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="reportsLayout" >
	<tiles:put name="page_title" value="Lead Manager" type="string" />
	<tiles:put name="body" value="/reports/lead_manager_body.jsp" />
</tiles:insert>

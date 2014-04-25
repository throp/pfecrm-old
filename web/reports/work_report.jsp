<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="reportsLayout" >
	<tiles:put name="page_title" value="Work Report" type="string" />
	<tiles:put name="body" value="/reports/work_report_body.jsp" />
</tiles:insert>

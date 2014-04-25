<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Employee > Action Log" type="string" />
	<tiles:put name="body" value="/admin/employee/action_log_body.jsp" />
	<tiles:put name="page_options" value="/admin/employee/options.jsp" />		
</tiles:insert>

<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Deactivate Employee" type="string" />
	<tiles:put name="body" value="/admin/employee/delete_body.jsp" />
	<tiles:put name="page_options" value="/admin/employee/options.jsp" />	
</tiles:insert>

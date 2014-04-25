<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Employee" type="string" />
	<tiles:put name="body" value="/admin/employee/view_all_body.jsp" />
	<tiles:put name="page_options" value="/admin/employee/options.jsp" />
</tiles:insert>

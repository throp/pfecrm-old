<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Add Office" type="string" />
	<tiles:put name="body" value="/admin/office/add_body.jsp" />
	<tiles:put name="page_options" value="/admin/office/options.jsp" />
</tiles:insert>

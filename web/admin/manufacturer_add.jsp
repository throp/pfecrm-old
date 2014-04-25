<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Add Manufacturer" type="string" />
	<tiles:put name="body" value="/admin/manufacturer_add_body.jsp" />
</tiles:insert>

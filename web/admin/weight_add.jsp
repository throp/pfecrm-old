<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Add Weight" type="string" />
	<tiles:put name="body" value="/admin/weight_add_body.jsp" />
</tiles:insert>

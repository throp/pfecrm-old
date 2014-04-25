<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Calculate Future Jobs" type="string" />
	<tiles:put name="body" value="/admin/scheduling/success_body.jsp" />
</tiles:insert>

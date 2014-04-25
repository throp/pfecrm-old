<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="schedulingLayout" >
	<tiles:put name="page_title" value="Revenue Manager" type="string" />
	<tiles:put name="body" value="/scheduling/revenue_manager_body.jsp" />
</tiles:insert>

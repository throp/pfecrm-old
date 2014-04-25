<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="schedulingLayout" >
	<tiles:put name="page_title" value="Invoice Manager" type="string" />
	<tiles:put name="body" value="/scheduling/invoice_manager_body.jsp" />
</tiles:insert>

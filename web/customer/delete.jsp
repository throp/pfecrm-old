<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="customerLayout" >
	<tiles:put name="page_title" value="Delete Customer" type="string" />
	<tiles:put name="body" value="/customer/delete_body.jsp" />
</tiles:insert>
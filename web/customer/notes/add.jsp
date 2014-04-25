<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="customerLayout" >
	<tiles:put name="page_title" value="/customer/customer_name.jsp" />
	<tiles:put name="body" value="/customer/notes/add_body.jsp" />
</tiles:insert>


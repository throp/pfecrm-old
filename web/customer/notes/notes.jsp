<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="customerLayout" >
	<tiles:put name="page_title" value="View Customer" type="string" />
	<tiles:put name="body" value="/customer/notes_body.jsp" />
</tiles:insert>
<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="customerLayout" >
	<tiles:put name="page_title" value="/customer/customer_name.jsp" />
	<tiles:put name="body" value="/customer/location/suppression_systems/inventory_body.jsp" />
</tiles:insert>
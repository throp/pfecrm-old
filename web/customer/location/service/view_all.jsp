<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="customerLayout" >
	<tiles:put name="page_title" value="/customer/customer_name.jsp" />
	<tiles:put name="body" value="/customer/location/service/view_all_body.jsp" />
	<tiles:put name="dialogBoxes" value="/customer/location/service/view_all_dialog_boxes.jsp" />
</tiles:insert>
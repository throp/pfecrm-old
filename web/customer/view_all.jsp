<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="customerLayout" >
	<tiles:put name="page_title" value="/customer/view_all_title.jsp" />
	<tiles:put name="body" value="/customer/view_all_body.jsp" />
	<tiles:put name="dialogBoxes" value="/customer/view_all_dialog_boxes.jsp" />	
</tiles:insert>
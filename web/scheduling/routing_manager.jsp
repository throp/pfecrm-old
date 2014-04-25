<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="schedulingLayout" >
	<tiles:put name="page_title" value="/scheduling/routing_manager_title.jsp" />
	<tiles:put name="body" value="/scheduling/routing_manager_body.jsp" />
	<tiles:put name="dialogBoxes" value="/scheduling/routing_manager_dialog_boxes.jsp" />	
</tiles:insert>

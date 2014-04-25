<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="schedulingLayout" >
	<tiles:put name="page_title" value="/scheduling/wip_manager_title.jsp" />
	<tiles:put name="body" value="/scheduling/wip_manager_body.jsp" />
	<tiles:put name="dialogBoxes" value="/scheduling/wip_manager_dialog_boxes.jsp" />
</tiles:insert>

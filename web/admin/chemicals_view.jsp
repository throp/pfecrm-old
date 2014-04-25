<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="Chemicals" type="string" />
	<tiles:put name="body" value="/admin/chemicals_view_body.jsp" />
	<tiles:put name="page_options" value="/admin/chemicals_options.jsp" />
	<tiles:put name="dialogBoxes" value="/admin/chemicals_dialog_boxes.jsp" />
</tiles:insert>

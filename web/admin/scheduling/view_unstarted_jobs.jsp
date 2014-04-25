<%@ taglib uri="/struts-tiles" prefix="tiles" %>

<tiles:insert definition="adminLayout" >
	<tiles:put name="page_title" value="View Unstarted Jobs" type="string" />
	<tiles:put name="body" value="/admin/scheduling/view_unstarted_jobs_body.jsp" />
</tiles:insert>

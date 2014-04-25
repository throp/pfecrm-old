<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/ndg-message" prefix="message" %>
<html>
<tiles:insert attribute="head" />
<body>
	
<span class="textH1Inverse"><tiles:insert attribute="page_title" /></span>
<table border="0" cellspacing="0" cellpadding="0" width="800"><tr height="2"><td bgcolor="black"></td></tr></table>

<tiles:insert attribute="body" />

</body>
</html>

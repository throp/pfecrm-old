<%@ taglib uri="/struts-bean" prefix="bean" %>
<bean:write name="customer" property="name"  />
<bean:define name="customer" property="status" id="status" />
<bean:define name="customer" property="office" id="office" />
<br>
&nbsp;&nbsp;
<span class="textSmall">
(<b>Office:</b> <bean:write name="office" property="name" />
&nbsp;&nbsp;
<b>Status:</b> <bean:write name="status" property="description" />
<a href="/CRM/GoToUpdateCustomerStatusAction.do"><img src="/CRM/images/edit.jpg" border="0"></a>
)
</span>
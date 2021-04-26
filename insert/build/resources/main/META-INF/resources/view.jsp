<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />

<liferay-ui:tabs names="Home page,Insertion,Update,Delete" refresh="false" value="${selectedTab}">

    <liferay-ui:section>
        <%@ include file="Home.jsp" %>
    </liferay-ui:section>
    
    <liferay-ui:section>
       <%@ include file="insert.jsp" %>
    </liferay-ui:section>
    
    <liferay-ui:section>
    	<%@ include file="update.jsp" %>
    </liferay-ui:section>
    
    <liferay-ui:section>
    	<%@ include file="delete.jsp" %>
    </liferay-ui:section>
 
</liferay-ui:tabs>
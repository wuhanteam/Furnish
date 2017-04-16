<%@ page trimDirectiveWhitespaces="true"  import="org.apache.shiro.SecurityUtils" %>
<%@ page import="com.softeem.utils.Constants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="view" uri="/WEB-INF/softeem-view.tld"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="loginUser" value="<%=SecurityUtils.getSubject().getPrincipal()%>"/>
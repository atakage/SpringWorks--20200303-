<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<%@ include file="/WEB-INF/views/include/include-head.jspf" %>




</head>
<body>
<header>
	<h2>MY READ BOOK</h2>
</header>


<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<%@ include file="/WEB-INF/views/rbooks/list-body.jsp" %>

<section>
	<div id="main-button">
		<button id="btn-write" class="biz-blue flex-right">독서록 작성</button>
	</div>
</section>

</body>
</html>
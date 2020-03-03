<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 JSP 홈페이지</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
	<a href="${rootPath}/login">로그인</a>
</sec:authorize>



<!-- 
	csrf.parameter
		cross site request forgery 교차사이트 공격을 방어하기 위해서 security에서 web브라우저에게 유효한 token을 내려보내주고 반드시 POST로 서버에 데이터를 전송할 경우는
		해당값을 같이 묶어서 전송해야 함
		그렇지 않으면 권한없음(403)오류가 나고 데이터를 전송할 수 없음
 -->
<sec:authorize access="isAuthenticated()">
	<form action="${rootPath}/logout" method="post">
	
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
		<button type="submit">로그아웃</button>
	
	</form>
</sec:authorize>


<sec:authorize access="hasRole('ADMIN')">
	<p>여기는 관리자 페이지
</sec:authorize>

<sec:authorize access="hasRole('USER')">
	<p>여기는 일반 페이지
</sec:authorize>

</body>
</html>
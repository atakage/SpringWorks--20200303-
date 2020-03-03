<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>



<nav>

	<ul>
	
		<c:if test="${!empty MENUS}">
			
			<c:forEach var="MENU" items="${MENUS}">
				
				<c:choose>
				
					<c:when test="${empty MENU.drop_menus}">
						<li><a href="${MENU.menu.href}">${MENU.menu_title}</a></li>
					</c:when>
					
					<c:otherwise>
					
						<ul class="nav">
						<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
						<li class="nav-item justify-content-end"><a class="nav-link" href="/member/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/member/join">회원가입</a></li>
						</ul>
											
					
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			
		</c:if>
	
	</ul>

</nav>
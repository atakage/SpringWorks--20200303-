<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	
	
	<c:choose>
	
	<c:when test="${INCLUDEPAGE == 'insert'}">
	
	<div class="inputBox">
	
	
	
	<form:form action="${rootPath}/friend/insert" modelAttribute="friendVO">
	
	<form:input path="fr_code" readonly="readonly" value="${fr_code}"/><br>
	
	이름:<form:input path="fr_name"/><br>
	번호:<form:input path="fr_number" maxlength="11"/><br>
	주소:<form:input path="fr_address"/><br>
	취미:<form:input path="fr_hobby"/><br>
	관계:<form:input path="fr_relative"/><br>
	
	<form:button>등록</form:button>
	
	</form:form>
	
	</div>
	
	</c:when>
	
	<c:otherwise>
	
	<div class="inputBox">
	
	<form:form action="${rootPath}/friend/update" modelAttribute="friendVO">
	
	<form:input path="fr_code" readonly="readonly" value="${fr_code}"/><br>
	
	이름:<form:input path="fr_name"/><br>
	번호:<form:input path="fr_number"/><br>
	주소:<form:input path="fr_address"/><br>
	취미:<form:input path="fr_hobby"/><br>
	관계:<form:input path="fr_relative"/><br>
	
	<form:button>수정</form:button>
	
	</form:form>
	
	

	
	</div>
	
		</c:otherwise>
	
	</c:choose>
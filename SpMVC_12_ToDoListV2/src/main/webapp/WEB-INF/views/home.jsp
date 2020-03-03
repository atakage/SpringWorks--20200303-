<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>나의 JSP 홈페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>

<script>
$(function(){
	
	$("#login").click(function(){
		
		$("#myModal").css("display", "block")
			
		
	})
	
})
</script>
<style>
	*{
		margin:0;
		padding:0;
		box-sizing: border-box;
	 }
	 
	 header{
	 	padding:2rem 1rem;
	 	margin-bottom:2rem;
	 	background-color: #E9ECEF;
	 	border-radius: 0.3rem;
	 }
	 
	 table{
	 	border-collapse: collapse;
	 	width:95%;
	 	margin: 0 auto;
	 	border: 1px solid gray;
	 }
	 
	 
	 table.input tr, table.input td, table.input th{
	 	padding: 10px;
	 
	 }
	 
	 
	 table.list tr, table.list td, table.list th{
	 	border: 1px solid gray;
	 	padding: 5px;
	 
	 }
	 
	 .line-through{
	 
	 	text-decoration: line-through;		/* 취소선 */
	 
	 }
	 
	 li#login{
	 
	 	cursor: pointer;
	 	display: inline-block;
	 	padding: 10px 20px;
	 
	 }
	 
	 li#login:hover{
	 	background-color: #ddd;
	 }
	 
</style>

</head>
<body>
<header>
	<h3>to do list</h3>
</header>
<nav>

	<ul>
	
		<li id="login">login</li>
		
	</ul>

</nav>
<section>
	<article id="input">
		<form method="post">
		
		<input type="hidden"
		name="td_complete"
		value="${todoDTO.td_complete}">
		
		<input type="hidden"
		name="td_seq"
		value='<c:out value='${todoDTO.td_seq}' default="0" />'>
		
		<input type="hidden"
		name="td_date"
		value="${todoDTO.td_date}">
		
		<input type="hidden"
		name="td_time"
		value="${todoDTO.td_time}">
		
			<table class="input">
			
				
				<tr>
				
					
					
					<td>
					<label for="td_flag"> 중요도</label>
					<input id="td_flag" type="number" min="1" max="5" name="td_flag" value='<c:out value="${todoDTO.td_flag}" default='1'/>'>
					</td>
					
					<td>
					<input type="text" name="td_subject" value="${todoDTO.td_subject}">
					</td>
					
					<td>
					<input type="checkbox" id="tdAlaram" name="td_alaram" <c:if test="${todoDTO.td_alaram == 'Y'}"> checked="checked" </c:if> value="Y">
					<label for="tdAlaram">알람설정</label>
					</td>
					
					<td>
					<button>저장</button>
					<a href="${rootPath}/">새로작성</a>
					</td>
					
				</tr>
				
			</table>
		</form>
		</article>
		<article id="list">
			<c:if test="${!empty TODOLIST}">
			<table class="list">
				<tr>
					<th>no</th>
					<th>Flag</th>
					<th>제목</th>
					<th>완성</th>
					<th>알람</th>
					<th>명령</th>
				</tr>
				<c:forEach items="${TODOLIST}" var="todo" varStatus="index">
					<tr>
					<td>${index.count}</td>
					<td>${todo.td_flag}</td>
					<td <c:if test="${todo.td_complete == 'Y'}">class="line-through"</c:if>>${todo.td_subject}</td>
					
					<td>
						<a href="${rootPath}/complete?tdSeq=${todo.td_seq}&tdComplete=${todo.td_complete}"> ${todo.td_complete}</a>
					</td>
					
					<td><a href="${rootPath}/alaram?tdSeq=${todo.td_seq}&tdAlaram=${todo.td_alaram}">${todo.td_alaram}</a></td>
					<td><a href="${rootPath}/update?tdSeq=${todo.td_seq}">수정</a></td>
					<td><a href="${rootPath}/delete?tdSeq=${todo.td_seq}">삭제</a></td>
					</tr>
				
				</c:forEach>
			</table>
			</c:if>
		</article>
		
	

</section>
<%@ include file="/WEB-INF/views/modal-box.jsp" %>
</body>
</html>
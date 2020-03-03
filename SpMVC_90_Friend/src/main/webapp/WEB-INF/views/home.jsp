<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 JSP 홈페이지</title>
</head>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



<style>

*{
	margin: 0 auto;
	

}

body{

	width:978px;
	height: 100%;
	

}


header{

width:100%;
text-align: center;
height: 100px;
background: lightcoral;
font-size: x-large;

}


.tableListBox{

display: block;
font-size: large;
text-align: center;

}


.mainListTable{

	
 width:80%;
 border: 1px solid black;
 border-collapse: collapse;
 padding:10px;

}


.trClass:hover{

 
 cursor: pointer;
 background: lightcoral;

}
</style>


<script>

$(function(){
	
	
	
	$('#selectBoxClass').change(function(){
		
		var optionVal = $('#selectBoxClass option:selected').val()
		
		
		
		alert(optionVal)
		
		
		
		if(optionVal == 'fr_number'){
			
			$('#searchVal').attr('type', 'number')
			
		}else if(optionVal == 'fr_name'){
			
			$('#searchVal').attr('type', 'text')
		}
		
		
	})
	
	/*
	if(optionVal == 'fr_number'){
		
		$('#searchVal').attr('type', 'number')
		
	}
	
	*/
	
	
	
	
	$('#searchButton').click(function(){
		
		
		
		var optionVal = $('#selectBoxClass option:selected').val()
		var searchVal = $('#searchVal').val()
		
		
		
	
		
		if($('#searchVal').val().length == 0){
		
				alert('검색어를 입력하시오')
				return false;
		
			}
		
		/*
		
		if(optionVal == 'fr_number' && !$('#searchVal').val().isNumeric()){
			
			
			alert('숫자만 입력가능합니다')
			return false;
			
			
		}
		
		*/
		
		
		document.location.href="${rootPath}/friend/search?optionVal="+optionVal+"&searchVal="+searchVal
		
		
	})
	
	
})



</script>


<body>
<header>친구목록</header>


<div class="menuBox">

	<ul style="list-style: none;">
	
	<li><a class="insertMenu" href="${rootPath}/" style="text-decoration: none; font-weight: bold; color:red;">리스트보기</a></li>
	<li><a class="insertMenu" href="${rootPath}/friend/insert" style="text-decoration: none; font-weight: bold; color:red;">등록하기</a></li>
		
	
	</ul>

</div>

<br><br><br><br>

<c:if test="${INCLUDEPAGE == 'mainList'}">

<div class="searchBox" style="float: right; margin-bottom: 5%">

	<select id="selectBoxClass">
		<option id="optionClass" value="fr_name">이름</option>
		<option id="optionClass" value="fr_number">전화번호</option>
	</select>
	<input id="searchVal" maxlength="10" placeholder="최대11자">
	<button id="searchButton" type="button">검색</button>

</div>

</c:if>


<c:if test="${INCLUDEPAGE == 'mainList'}">

			<div class="tableListBox">
			
			
			<c:choose>
			
			<c:when test="${empty FRIENDLIST}">
			
			<table class="mainListTable">
			<tr>
				<th>이름</th>
				<th>번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>관계</th>
			</tr>
			
			<tr>
				<td colspan="5">데이터 없음</td>
			</tr>
			
			</table>
			
			</c:when>
			
			<c:otherwise>
			
			<table class="mainListTable">
			<tr>
				<th>이름</th>
				<th>번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>관계</th>
			</tr>
			
			<c:forEach items="${FRIENDLIST}" var="fl">
			<tr class="trClass" onclick="document.location.href='${rootPath}/friend/update?fr_code=${fl.fr_code}'">
				<td style="display: none;">${fl.fr_code}</td>
				<td>${fl.fr_name}</td>
				<td>${fl.fr_number}</td>
				<td>${fl.fr_address}</td>
				<td>${fl.fr_hobby}</td>
				<td>${fl.fr_relative}</td>
			</tr>
			</c:forEach>
			
			</table>
			
			
			
			</c:otherwise>
			
			</c:choose>
			
			
			</div>

</c:if>



<c:if test="${INCLUDEPAGE == 'insert' || INCLUDEPAGE == 'update'}">

	<%@ include file="/WEB-INF/views/include/insert.jsp" %>

</c:if>



</body>
</html>
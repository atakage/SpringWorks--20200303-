<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script>

$(function(){
	
	
	$('#update_button').click(function(){
		
		var ems_seq = $('#hidden_seq').val()
		
		document.location.href="${rootPath}/ems/update/"+ems_seq
		
	})
	
	
})


</script>



<style>



.viewBox{

	width:40%;
	margin: 100px auto;
	border: 1px solid black;
	border-radius: 4px;

}

.in-box2{
	display:flex;
	margin:30px;
	/* border:1px solid ; */
}

.content{
	width:70%;
	margin-left: auto;
}

.title{
	background: olive;
	text-align: center;
	width:30%;
}

.button_set{
	
	float:right;

}

.button{
	cursor:pointer;
	border:none;
	color:white;
	padding:10px;
}

</style>


<fieldSet class="viewBox">
<form:form modelAttribute="emailVO">

	<div class="in-box2">
		<div class="title"><b>보내는 Email</b></div>
		<div class="content">${emailVO.fromEmail}</div>
	</div>
	
	<div class="in-box2">
		<div class="title"><b>받는 Email</b></div>
		<div class="content">${emailVO.to_email}</div>
	</div>
		
	<div class="in-box2">
		<div class="title"><b>작성일자</b></div>
		<div class="content">${emailVO.sendDate}</div>
		<div class="title"><b>작성시각</b></div>
		<div class="content">${emailVO.sendTime}</div>
	</div>



	<div class="in-box2">
		<div class="title"><b>작성자</b></div>
		<div class="content">${emailVO.fromName}</div>
	</div>
	
	<div class="in-box2">
		<div class="title"><b>받는사람</b></div>
		<div class="content">${emailVO.to_name}</div>
	</div>
	
	<div class="in-box2">
		<div class="title"><b>제목</b></div>
		<div class="content">${emailVO.subject}</div>
	</div>
	
	<div class="in-box2">
		<div class="content_main">${emailVO.content}</div>
	</div>
	
	<input id="hidden_seq" type="hidden" value="${emailVO.emsSeq}">
	
	<div class="button_set">
	<button id="update_button" class="button" type="button" style="color: green">수정</button>
	<button class="button" type="button" style="color: red">삭제</button>
	<button class="button" type="button" style="color: black" onclick="location.href='${rootPath}/'">홈으로</button>
	</div>
</form:form>

</fieldSet>



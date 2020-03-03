<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/views/include/include-head.jspf" %>

<script>

$(function(){
	
	
	
	$("#btn-write").click(function(){
		
		
		if($('#rb_bcode').val() == ""){
		
			alert('도서 코드는 반드시 입력해야 함')
			$('#rb_bcode').focus()
			return false;
			
		}
		
		
		if(parseInt($('#rb_rtime').val()) < 1){
			alert('독서 시간은 반드시 입력해야 함')
			$('#rb_rtime').focus()
			return false;
		}
		
		if($('#rb_subject').val() == ""){
			alert('한줄평 반드시 입력')
			$('#rb_subject').focus()
			return false;
		}
		
		$('form').submit() // 버튼을 클릭하면 submit을 실행
		
	})
	
	
	/*
		input box에 내용이 있을 때 focus()가 위치하면 내용을 전체 설정하여 다른 글자를 입력하면 내용이 삭제되는 기능
	*/
	$('#rb_bname, #rb_rtime, #rb_bcode, #rb_subject').focus(function(){
		
		$(this).select()
		
	})
	
	
	$('#rb_bname').keypress(function(event){
		
		//document.location.href = "${rootPath}/book/write"
		if(event.keyCode == 13){
			
			let strText = $(this).val()
			if(strText == ""){
				alert("도서 이름을 입력한 후 Enter")
				return false;
			}

			$('#modal-box').css('display', 'block')
			$.post("${rootPath}/book/search", {strText} , function(result){
				
				$("#modal-content").html(result)
				
			})
		}
		
	})
	
	
	$(".modal-header span").click(function(){
		$('#modal-box').css('display', 'none')
	})
	
	
	
	var toolbar = [
		
		['style', ['bold', 'italic', 'underline'] ], ['fontsize', ['fontsize']], ['font Style', ['fontname']], ['color', ['color']], ['para', ['ul', 'ol', 'paragraph']],
		['height', ['height']], ['table', ['table']], ['insert', ['link', 'hr']], ['view', ['fullscreen', 'picture' , 'codeview']]
		
	]
	
	
	
	
	$("#tb_text").summernote({
		lang:'ko-KR',
		placeholder: '본문을 입력하세요', width:'100%', toolbar:toolbar, height:'200px', disableDragAndDrop: true
	})
	
	$('#rb_star').change(function(){
		
		let star = $(this).val()
		star= star * 10
		$('span.star-red').css('width', star + "%")
		
	})
	
	$("#btn_img_up").click(function(){
		document.location.href="${rootPath}/image/upload"
	})
	
	$("#d_d_box").on('dragover', function(e){
		
		$("#d_d_box h3").text("파일을 내려 놓으세요")
		return false;
		
	})
	
	
	
})

</script>

<style>

.input-box{
	display:flex;
	width: 80%;
	margin: 5px auto;
	
}

.input-box input{

	color:black;
	border:none;
	border-bottom: 1px solid rgb(52,152,219);
	display:block;
	font-size: 0.9rem;
	width: 100%;
	padding: 8px;
	
}


#rb_bcode{

	width:50%;
	margin-right: 5px;
	
}

#rb_star{
	width:60%;
}



span.star-box{
	width:100px;
	margin-left:20px;
}

span.star-box, span.star-red{
	display:inline-block;
	height: 20px;
	overflow:hidden;
	background: url("${rootPath}/img/star.png") no-repeat;
	
	/* 배경이미지를 width:자동 height:40px */
	background-size: 100px 40px;
	
}

span.star-red{

/* 배경 이미지를 채울 때 왼쪽 아래 꼭짓점을 기준으로 배치 */
	background-position: left bottom;
	line-height: 0;
	vertical-align: top;
	width: 50%;
}


</style>

</head>
<body>
<header>
	<h2>MY READ BOOK</h2>
</header>


<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>













<%

/*

	글쓰기를 시작할 때
	controller에 get로 path를 받았을 때 현재 view를 보여주고
	input box에 데이터를 입력한 후 submit button을 클릭하면 controller에 post로 데이터가 전송됨
	
	path는 view를 열 때 사용했던 path가 그대로 적용됨
	
	그렇게 사용하지 않을 경우에는 별도로 action을 지정해야 함
	
	/rbooks/book/insert path를 실행하면 
	controller의 GET method가 이를 수신하여 현재 input.jsp를 보여주고 데이터를 입력한 후 저장 button을 클릭하면
	/rbooks/book/insert path의 POST method로 데이터가 전송 
	
	특별히 action을 지정하지 않으면 위와 같은 매커니즘으로 사용됨
	기본값으로 사용하지 않을 경우 action을 지정하여 사용할 수 있음
	
	spring form tag를 사용할 경우 기본 method가 POST이고
	html form tag는 기본 method가 GET
	button은 type을 지정하지 않으면 type="submit"이 기본값이고
	버튼을 클릭하면 form에 입력한 데이터를 서버로 전송하는 기능을 함
	
	button에 특별히 이벤트를 적용하고 싶으면 type="button"으로 지정할 수 있음
	
	
	button에는 세 가지 type이 있음
	
	submit: 기본값이고 form 안에 있는 경우 form에 담긴 데이터를 서버로 전송하는 기능, input box가 1개만 있을 경우 Enter키에 반응하여 버튼을 클릭한 것처럼 동작
	button: 모든 기능을 제거하고 별도의 event를 설정해야 함
	reset: form안에 있는 경우 form의 input box에 임의로 작성한 데이터를 모두 초기화하는 기능
	
	
	
	중첩된 form의 action.. 나중에 생각

*/

%>
<section id="main-writer">
	<article>
	
		<form:form modelAttribute="rBookVO">
			<div class="input-box">
			<form:input type="text" path="rb_bcode"  placeholder="도서 코드"/>
			<form:input path="rb_bname"  placeholder="도서이름을 입력한 후 enter..."/>
			</div>
			
			
			<div class="input-box">
			<form:input type="date" path="rb_date"  placeholder="독서일자"/>
			</div>
			<div class="input-box">
			<form:input type="time" path="rb_stime"  placeholder="독서시작시간"/>
			</div>
			<div class="input-box">
			<form:input type="text" path="rb_rtime"  placeholder="독서시간"/>
			</div>
			<div class="input-box">
			<form:input type="text" path="rb_subject"  placeholder="한줄평"/>
			</div>
			<div class="input-box">
			<form:input type="range" path="rb_star" min="1" max="10" placeholder="별점"/>
			
			<span class="star-box">
		<span class="star-red"></span>
	</span>
			
			
			</div>
			<div class="input-box">
			<form:textarea path="tb_text"/><br>
			</div>
			
			
				<div id="main-button">
		<button id="btn-write" class="biz-orange flex-right" type="button">독서록 저장</button>
		<button id="btn-clear" class="biz-blue" type="reset">새로작성</button>
		<button id="btn-list" class="biz-red" type="button">리스트로 가기</button>
	</div>
			
			
		</form:form>
	
	</article>


</section>


<div id="modal-box">
	<div class="modal-header">
		<span>&times;</span>
	</div>
	<div id="modal-content">
		
	</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style>
.contentBox {
	border: 1px solid black;
}

.divHead {
	display: block;
	float: left;
	background-color: beige;
}

.innerDiv {
	display: inline-block;
	/* float: left; */
	background-color: white;
}

.button-group {
	float: right;
}
</style>




<script>
 
 $(function(){
	 
	 // 현재 페이지가 몯 그려진 후 바로 실행
	 $.post("${rootPath}/bbs/cmt_list", {cmt_p_id:"${bbsVO.bbs_id}"}, 
	 function(result){
		 $("#cmt_list").html(result)
	 })
	 
	 
	
	 
	 
	 $('button.btn-c-save').click(function(){
		 
		 let cmt_writer = $("#cmt_writer").val()
		 let cmt_text = $("#cmt_text").val()
		 
		 if(cmt_writer == ""){
			 alert("댓글 작성자를 입력하시오")
			 $("#cmt_writer").focus
			 return false;
		 }
		 
		 if(cmt_text == ""){
			 alert("댓글을 입력하시오")
			 $("#cmt_text").focus
			 return false;
		 }
		 
		 
		 // json 형태로 데이터 생성
		 let cmt_data = {cmt_p_id:'${bbsVO.bbs_id}' , cmt_writer:cmt_writer, cmt_text:cmt_text}    
		 
		 
		 $.ajax({
			
			 
			 url: '${rootPath}/bbs/comment/write', data:cmt_data, method:'POST',
			 success:function(result){
				 
				// alert(result)
				
				
				$("#cmt_list").html(result)
				 
			 }, error:function(){
				 alert('서버와의 통신 오류')
			 }
			 
		 })
		 
	 })
	 
	 
	
	 
 })
 
 
 </script>


<form:form action="${rootPath}/bbs/reply" modelAttribute="bbsVO">




	<div class="contentBox">

		<div class="divHead">

			글번호
			<div class="innerDiv">${bbsVO.bbs_id}</div>

		</div>
		<br>

		<div class="divHead">
			날짜
			<div class="innerDiv">${bbsVO.bbs_date}</div>

		</div>

		<div class="divHead">
			시간
			<div class="innerDiv">${bbsVO.bbs_time}</div>
		</div>
		<br>

		<div class="divHead">
			작성자
			<div class="innerDiv">${bbsVO.bbs_writer}</div>
		</div>
		<br>

		<div class="divHead">
			제목
			<div class="innerDiv">${bbsVO.bbs_subject}</div>
		</div>
		<br>

		<div class="divHead">
			<div class="innerDiv">${bbsVO.bbs_content}</div>
		</div>


		<br>
		<br>





		<div class="button-group">

			<button type="button" class="btn btn-primary">리스트보기</button>
			<button type="button" class="btn btn-success">수정</button>
			<button type="button" class="btn btn-warning">삭제</button>


		</div>






		<br>
		<br>
		<br>




		<div class="form-group bg-info">

			<div id="cmt_list" class="form-group bg-white">
			댓글 리스트 보기
		</div>

		</div>







		<div class="container-fluid bg-info">

			<div class="form-group">

				<input id="cmt_writer" name="cmt_writer" class="form-control"
					placeholder="작성자">

			</div>

			<div class="form-group">
				<input id="cmt_text" name="cmt_text" class="form-control">
				<button class="btn btn-dark btn-c-save" type="button">저장</button>
			</div>


		</div>










		<c:if test="${bbsVO.bbs_p_id == 0}">
			<script>
 		$(function(){
 			
 			$('button.btn-r-save').click(function(){
 				
 			
		 			
		 			let bbs_writer = $('#bbs_writer').val()
		 			let bbs_content = $('#bbs_content').val()
		 			
		 			if(bbs_writer == ''){
		 				alert('작성자를 입력하세요')
		 				$('#bbs_writer').focus()
		 				return false;
		 			}
		 			
		 			if(bbs_content == ""){
		 				alert('답글 본문을 입력하세요')
		 				$('#bbs_content').focus()
		 				return false;
		 			}
		 			
		 			
		 			$('form').submit()
		 			
 			
 			})
 		})
 	
 	</script>

			<div class="form-group">
				<input class="form_control" id="bbs_writer" name="bbs_writer"
					placeholder="답글작성자" value="" />
				<!-- controller넘어갈 때 id아닌 name으로 value추적? id는 유효성검사용? -->
			</div>


			<textarea id="bbs_content" name="bbs_content"></textarea>
			<button class="btn btn-info btn-r-save" type="button">답글저장</button>

		</c:if>


	</div>
</form:form>
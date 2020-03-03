<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
.in-errors {
	color:red;
	font-size:8px;
}
/*
	col-md-7 col-12
	해상도가 768보다 크면 7칸만 차지하고
	그 이하이면 12칸을 차지하여 풀 width 로 보여라
*/
tr,td,th {
	white-space: nowrap;
}
.pro-list {
	overflow: auto;
}
.p_name {
 	display:inline-block;
 	width:150px;
 	padding: 0 5px;
 	overflow: hidden;
 	text-overflow: ellipsis;
 	white-space: nowrap;
}
</style>





<article class="mt-5 row">

	<article class="col-7 bg-light pro-input">
		<form>
		
		
			<div class="container-fluid form-group row">
				<select class="custom-select-sm col-6">
					<option>공산품</option>
					<option>농산물</option>
					<option>수산물</option>
				</select>
				<select class="custom-select-sm col-6">
					<option>대덕물산</option>
					<option>삼성농산</option>
					<option>목포수산</option>
				</select>
			</div>
		
		
		
		
			<div class="form-group">
				<input class="form-control" placeholder="상품코드">
			</div>
			
			<div class="form-group">
				<input class="form-control" placeholder="상품이름">
			</div>
			
			<div class="container-fluid form-group row">
				<input class="form-control" placeholder="매입단가">
				<input class="form-control" placeholder="판매단가">
			</div>
			
			<div class="form-group">
				<textarea rows="" cols="" placeholder="상세정보"></textarea>
			</div>
		</form>
	
	</article>

	<article class="col-md-4 col-12 bg-light pro-list">
		<%@ include file="/WEB-INF/views/admin/product_list.jsp" %>
	</article>

</article>
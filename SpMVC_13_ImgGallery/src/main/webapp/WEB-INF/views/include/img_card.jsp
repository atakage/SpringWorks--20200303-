<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<div class="img_card img_panel" data-file="${img.img_file}" data-seq="${img.img_seq}">

<c:if test="${empty img.img_file}">
<img src="${rootPath}/images/noimage.png"  width="100%" height="80%">
</c:if>

<c:if test="${!empty img.img_file}">
<img src="${rootPath}/images/${img.img_file}" width="100%"  height="80%">
</c:if>
	<div class="img_title">
		<h4>${img.img_title}</h4>
	</div>
</div>
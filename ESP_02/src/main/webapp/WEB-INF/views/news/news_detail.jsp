<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업지원정보 - 소식 세부사항</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
<link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/table.css?ver=20191121001" type="text/css">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
	
	<section>
        <article class="body_title">
            <p> 소식 </p>
        </article>
        <article class="news_detail">
            <table border="1">
                <tr>
                    <th>제목</th>
                    <td colspan="3">제목이 나올 곳</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>작성자 나올 곳</td>
                    <th>등록일</th>
                    <td>등록일 나올 곳</td>
                </tr>
            </table>
            <div>
                대통령의 임기연장 또는 중임변경을 위한 헌법개정은 그 헌법개정 제안 당시의 대통령에 대하여는 효력이 없다. 대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 존중함을 기본으로 한다. 국회의원이 회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한 국회의 요구가 있으면 회기중 석방된다.

국회의원은 현행범인인 경우를 제외하고는 회기중 국회의 동의없이 체포 또는 구금되지 아니한다. 제2항의 재판관중 3인은 국회에서 선출하는 자를, 3인은 대법원장이 지명하는 자를 임명한다. 나는 헌법을 준수하고 국가를 보위하며 조국의 평화적 통일과 국민의 자유와 복리의 증진 및 민족문화의 창달에 노력하여 대통령으로서의 직책을 성실히 수행할 것을 국민 앞에 엄숙히 선서합니다.

헌법에 의하여 체결·공포된 조약과 일반적으로 승인된 국제법규는 국내법과 같은 효력을 가진다. 제안된 헌법개정안은 대통령이 20일 이상의 기간 이를 공고하여야 한다. 대통령은 국가의 원수이며, 외국에 대하여 국가를 대표한다. 의원을 제명하려면 국회재적의원 3분의 2 이상의 찬성이 있어야 한다. 모든 국민은 건강하고 쾌적한 환경에서 생활할 권리를 가지며, 국가와 국민은 환경보전을 위하여 노력하여야 한다.
            </div>
            <table border="1">
                <tr class="news_detail_file">
                    <th>첨부파일</th>
                    <td>파일 링크</td>
                </tr>
            </table>
            <article class="news_page_button">
                <a href="${rootPath}/news"><button>목록</button></a>
            </article>
        </article>
    </section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
	
</body>
</html>

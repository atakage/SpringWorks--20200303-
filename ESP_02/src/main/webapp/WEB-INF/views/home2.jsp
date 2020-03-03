<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업정책지원사이트</title>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/main.css?ver=2019-11-30-002">
</head>
<style>
@charset "UTF-8";
@media screen and (max-width: 978px) {

    html{   
        margin: 0;
        padding: 0;
    }
    ul.notice{
        padding-left: 0 !important;
    }
    article{
        flex-flow: column;
    }
    video{
        margin: 10px;
        width: 100%;
        height: 10%;
    }
    #main-menu{
        padding-left: 0 !important;
    }
    table{
      padding: 0 !important;
    }

}
h3{
	text-align: center;
	margin: 1rem 0;
	margin-bottom:0;
}
h3 a{
	color: black;	
	text-decoration: none;
}

#main-menu{
	border: 1px solid gray;
	background-color: rgb(47,79,79);
	display: flex;
	list-style: none;
	margin: 1rem 0;
	padding-left: 30%;
}
#main-menu li a{
	text-decoration: none;
	color: white;
}
#main-menu li{
	padding: 1rem;
}

#main-menu .login{
	margin-left: auto;
}
#main-menu li:hover{
	font-weight: bold;
}

/* drop down */
.menu2, .menu3 {
list-style:none;
  background-color: rgb(47,79,79);
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}
.menu2 a, .menu3 a{
	text-decoration:none;
    color: white;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.menu2:hover, .menu3:hover {
  background-color: #3e8e41;
}
ul.notice {
    margin: 0 ;
    padding-left: 8%;    
}
article{
    height: 100%;
    width: 100%;
    display: flex;;
}

video{
    margin-left: auto;
    margin-right: 8%;
    display: inline-block;
    border-radius: 2px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

/* 공지사항 , 소식 */

body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: rgb(47,79,79);
  color: white;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 15px 15px;
  border: 1px solid #ccc;
  border-top: none;
  list-style: none;
  
  height: 200px;
  text-align: left;
  font-size: 15px;
}
.tabcontent li{
    padding: 0.6rem;
}
.tabcontent span{
	margin: 0 2rem;
    font-size: 11px;
}
.tabcontent a{
    text-decoration: none;
}

image{
    margin: 10px 0;
}


/* footer */
footer{
  width: 100%;
  
}
footer ul, #footer-bottom{
  margin: 0;
  background-color: #dbdbdb;
  width: 100%;
  padding: 10px;
  display: flex;
  justify-content: center;
  position: relative;
  top: 3rem;
  list-style: none;
}

footer ul a{
  padding: 2rem;
  margin: 1rem;
  text-decoration: none;
  font-family: Arial, Helvetica, sans-serif;
  color: black;
  cursor: pointer;
  font-size: 12px;
}

#footer-bottom{
  background-color: white;
  height: 5rem;
  border: 1px solid tomato;
}

/* 한번에 보는 정책 정보 */
table{
  margin: 10px 0;
  width: 100%;
}
table,tr {
    padding: 10px 100px;
    font-family: "Malgun gothic","맑은고딕",sans-serif;
}
td {
    text-align: center;
    font-family: "Malgun gothic","맑은고딕",sans-serif;
    padding: 1rem;
    
}
.tr1 #simple-info {
    background-color: darkslategray;
    color: white;
    border: none;
    border-radius: 3px;
}
.tr2 {
    background-color: rgb(209,216,232);
    border-radius: 3px;
}
.tr3 > td {
    width: 1rem;
    background-color: rgb(233,237,247);
    border-radius: 3px;
}
.tr4 > td {
    height: 8rem;
    border: 1px solid grey;
    border-radius: 3px;
}

</style>
<body>
	
	<h3><a href="#">취업지원정책정보</a></h3>
<section>	
	<ul id="main-menu">
		<li class="menu1"><a href="#">사이트소개</a></li>
		<div class="dropdown">
            <li class="menu2"><a href="#">대상별정책</a></li>
              <div class="dropdown-content">
                  <a href="#">청년</a>
                  <a href="#">여성</a>	
                  <a href="#">중장년</a>
                  <a href="#">장애인</a>
                  <a href="#">외국인</a>
              </div>
        </div>
        <div class="dropdown">
            <li class="menu3"><a href="#">지역별정책</a></li>
              <div class="dropdown-content">
                  <a href="#">광역시별</a>
                  <a href="#">도별</a>	
              </div>
        </div>
		<li class="menu4"><a href="#">소식</a></li>
		<li class="menu5"><a href="#">정책자료실</a></li>
		<li class="login"><a href="#">로그인</a></li>
		<li class="join"><a href="#">회원가입</a></li>
	</ul>
</section>	


<article>
    <ul class="notice">
        
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'noti')" id="defaultOpen">공지사항</button>
            <button class="tablinks" onclick="openCity(event, 'news')">정책소식</button>
            
            
        </div>
        
        <div id="noti" class="tabcontent">
            <li><a href="#">[공지] 이상의 사라지지 든 이것이다. 열매를 같으며, 바이며, 것이다.</a><span>2019.11.30</span></li>
            <li><a href="#">[공지] 이상의 사라지지 든 이것이다. 열매를 같으며, 바이며, 것이다.</a><span>2019.11.30</span></li>
            <li><a href="#">[공지] 이상의 사라지지 든 이것이다. 열매를 같으며, 바이며, 것이다.</a><span>2019.11.30</span></li>
            <li><a href="#">[공지] 이상의 사라지지 든 이것이다. 열매를 같으며, 바이며, 것이다.</a><span>2019.11.30</span></li>
            <li><a href="#">[공지] 이상의 사라지지 든 이것이다. 열매를 같으며, 바이며, 것이다.</a><span>2019.11.30</span></li>
        </div>
        
        <div id="news" class="tabcontent">
            <li><a href="#">[소식] 별과 얼마나 아름답고 무엇이 설산에서 무엇을 그들은 아니다.</a><span>2019.11.30</span></li>
            <li><a href="#">[소식] 별과 얼마나 아름답고 무엇이 설산에서 무엇을 그들은 아니다.</a><span>2019.11.30</span></li>
            <li><a href="#">[소식] 별과 얼마나 아름답고 무엇이 설산에서 무엇을 그들은 아니다.</a><span>2019.11.30</span></li>
            <li><a href="#">[소식] 별과 얼마나 아름답고 무엇이 설산에서 무엇을 그들은 아니다.</a><span>2019.11.30</span></li>
            <li><a href="#">[소식] 별과 얼마나 아름답고 무엇이 설산에서 무엇을 그들은 아니다.</a><span>2019.11.30</span></li>
        </div>
    </ul>
  
  <script>
  function openCity(evt, infoName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(infoName).style.display = "block";
    evt.currentTarget.className += " active";
  }
  
  // Get the element with id="defaultOpen" and click on it
  document.getElementById("defaultOpen").click();
  </script>


	<video width="470" height="280" controls>
		<source src="#" type="video/mp4">
		브라우저에서 지원되는 포맷이 아닙니다.
    </video>
</article>



<table>
    <tr class="tr1">
        <td id="simple-info" colspan="7">한번에 찾는 정책 정보</td>
    </tr>
    <tr class="tr2">
        <td colspan="5">대상별 정책</td>
        <td colspan="2">지역별 정책</td>
        

    </tr>
    <tr class="tr3">
        <td>청년</td>
        <td>여성</td>
        <td>중장년</td>
        <td>장애인</td>
        <td>외국인</td>
        <td>광역시별</td>
        <td>도시별</td>

    </tr>
    <tr class="tr4">
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
    </tr>
</table>

<footer>
		<ul>
			<li><a href="#">이용안내</a></li>
			<li><a href="#"><strong>개인정보처리방침</strong></a></li>
			<li><a href="#">개선의견수렴</a></li>
    </ul>
    <div id="footer-bottom">취업지원정책 연락처~~</div>
</footer>

</body>
</html>
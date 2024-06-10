<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<style>
* {
	box-sizing: border-box;
}

.container {
	margin: auto;
	height: 480px;
	width: 400px;
	border: 1px solid black;
	padding: 10px;
}

.row {
	margin-bottom: 10px;
}

.row div {
	display: inline-block;
	vertical-align: middle;
}

.col-4 {
	width: 30%;
	font-weight: bold;
	
}

.col-8 {
	width: 65%;
}

input[type="text"] {
	width: 100%;
}

#btn_row{
display:flex;
justify-content: end;
align-items: end;
}

#title{
display:flex;
justify-content: center;
align-items: center;
font-size:22px;
}

#profile_img_box{
	margin: auto;
	height: 150px;
	width: 150px;
	border: 1px solid black;
}

#profile_img{
	margin: auto;
	height: 140px;
	width: 150px;
	}

</style>
<body>

	<div class="container">
		<div id="title" class="row">My page</div>
		<div id="profile_img_box" class="row"> 프로필 이미지
			<div id="profile_img" class="col"></div>
			<input type="hidden" id="profile_img"><br>
		</div>
		<hr>
		<div id="id" class="row">
			<div class="col-4">아이디</div>
			<div class="col-8">
				<input type="hidden" placeholder="아이디">아이디
			</div>
		</div>
		<div id="name" class="row">
			<div class="col-4">이름</div>
			<div class="col-8">
				<input type="hidden" placeholder="이름">이름
			</div>
		</div>
		<div id="phone" class="row">
			<div class="col-4">폰번호</div>
			<div class="col-8">
				<input type="hidden" placeholder="핸드폰번호">핸드폰번호
			</div>
		</div>
		<div id="email" class="row">
			<div class="col-4">이메일</div>
			<div class="col-8">
				<input type="hidden" placeholder="이메일">이메일
			</div>
		</div>
			<div id="sex" class="row">
				<div class="col-4">성 별</div>
				<div class="col-8">
					<input type="hidden" placeholder="성별">성별
				</div>
			</div>
			<div id="joindate" class="row">
				<div class="col-4">가입일자</div>
				<div class="col-8">
					<input type="hidden" placeholder="가입일자">가입일자
				</div>
			</div>
			<div class="row" id="btn_row">
			<button id="update_btn" class="col">수정하기</button>
		</div>
		</div>
</body>
</html>
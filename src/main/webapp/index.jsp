<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Startup Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        body {
            font-family: 'Georgia', serif;
            background-color: #f4f4f9;
            color: #333;
        }
        .header {
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header .logo img {
            max-height: 50px;
        }
        .header .search-bar {
            display: flex;
            flex-grow: 1;
            margin-left: 20px;
            max-width: 500px;
        }
        .header .search-bar input {
            flex-grow: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 20px 0 0 20px;
        }
        .header .search-bar button {
            padding: 10px 20px;
            border: none;
            background-color: black;
            opacity: 0.5;
            color: white;
            border-radius: 0 20px 20px 0;
            cursor: pointer;
        }
        .header .login, .header .myPage {
            margin-left: 10px; 
            font-size: 18px;
            color: black;
            text-decoration: none;
            padding: 10px 20px;
            background-color: white;
            border-radius: 20px;
            text-align: center;
            transition: background-color 0.3s;
        }
        .header .login:hover, .header .myPage:hover {
            background-color: #0056b3;
        }
        .welcome-section {
            position: relative;
            text-align: center;
            color: white;
            height: 300px;
        }
        
        .loginFont{
        	background-color : #C1FF6B;
        	border-radius: 10px;
        	opacity : 0.8;
			color: #0A6E0A;
			font-family:'Times New Roman', Times, serif;
			font-size : 25px;
        }        
        .featured-stories {
            padding: 50px 20px;
            text-align: center;
        }
        .featured-stories h2 {
            font-size: 32px;
            margin-bottom: 30px;
        }


    </style>
</head>
<body>
    <header class="header">
        <div class="logo">
            <img src="images/GameWorldLogo.png" alt="GameWorld Logo">
        </div>
        <c:choose>
            <c:when test="${not empty loginID}">
                <a href="/myPage.members" class="myPage btn btn-primary">My Page</a>
            </c:when>
            <c:otherwise>
                <a href="/members/login.jsp" class="login btn btn-primary">Login</a>
            </c:otherwise>
        </c:choose>
    </header>

	<div>
        <c:choose>
            <c:when test="${not empty loginID}">
                <div class="content">
                    <p class="loginFont">${loginName}님 환영합니다!</p>
                    <button class="create-story-btn btn btn-warning">새로운 이야기</button>
                    <a href="/logout.members" class="logout-btn btn btn-danger">로그아웃</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="default-background">
                
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <section class="featured-stories container">
    <div class="card-body">
              <span class="badge badge-my">게시판 들어가기 링크임.</span>
    </div>
    </section>


    <script>
        $(document).ready(function(){
            $('.create-story-btn').click(function(){
                let loginId = '${loginID}';
                console.log(loginId);
                alert("개발중");
            });


            $('.card-body span').click(function() {
                location.href = "/list.board";
            });
        });
    </script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register - GameWorld</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #000;
            color: #fff;
            margin: 0;
            padding: 0;
        }
        .main-content {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            padding-top: 50px;
        }
        .register-container {
            background-color: #333;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            max-width: 400px;
            width: 100%;
            margin-bottom: 50px;
        }
        .register-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
            text-align: center;
        }
        .register-container .form-group {
            margin-bottom: 15px;
        }
        .register-container .form-group label {
            font-size: 14px;
            display: block;
            margin-bottom: 5px;
        }
        .register-container .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #555;
            border-radius: 5px;
            background-color: #444;
            color: #fff;
        }
        .register-container .form-group input::placeholder {
            color: #bbb;
        }
        .register-container .form-group .id-group,
        .register-container .form-group .zipcode-group {
            display: flex;
        }
        .register-container .form-group .id-group input,
        .register-container .form-group .zipcode-group input {
            flex: 1;
        }
        .register-container .form-group .id-check-btn,
        .register-container .form-group .find-address-btn {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            margin-left: 10px;
            transition: background-color 0.3s;
        }
        .register-container .form-group .id-check-btn:hover,
        .register-container .form-group .find-address-btn:hover {
            background-color: #45a049;
        }
        .register-container .form-group .radio-group {
            display: flex;
            justify-content: space-between;
        }
        .register-container .form-group .radio-group label {
            flex: 1;
            text-align: center;
        }
        .register-container .form-group .radio-group input {
            margin-right: 5px;
        }
        .register-container .agreement-group {
            margin-top: 20px;
        }
        .register-container .agreement-group .form-check {
            margin-bottom: 10px;
        }
        .register-container button[type=submit] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s;
        }
        .register-container button[type=submit]:hover {
            background-color: #45a049;
        }
        .register-container .login-link {
            display: block;
            margin-top: 20px;
            text-align: center;
            color: #007bff;
            text-decoration: none;
        }
        .register-container .login-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="main-content">
        <div class="register-container">
            <h2>게임월드 회원가입</h2>
            <form action="/register.register" method="post">
                <div class="form-group">
                    <label for="id">아이디</label>
                    <div class="id-group">
                        <input type="text" id="id" name="id" placeholder="아이디" required>
                        <button class="id-check-btn" id="idCheck" type="button">중복확인</button>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="pw" placeholder="비밀번호" required>
                </div>
                <div class="form-group">
                    <label for="confirm_password">비밀번호 확인</label>
                    <input type="password" id="confirm_password" name="confirm_password" placeholder="비밀번호 확인" required>
                </div>
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" id="name" name="name" placeholder="이름" required>
                </div>
                <div class="form-group">
                    <label for="phone">폰 번호</label>
                    <input type="text" id="phone" name="phone" placeholder="폰 번호">
                </div>
                <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="email" id="email" name="email" placeholder="이메일" required>
                </div>
                <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="email" id="email" name="email" placeholder="이메일" required>
                </div>
                    <div class="radio-group">
                        <label>
                            <input type="radio" id="male" name="gender" value="male">
                            남자
                        </label>
                        <label>
                            <input type="radio" id="female" name="gender" value="female">
                            여자
                        </label>
                    </div>
                
                <button type="submit">가입하기</button>
            </form>
            <a href="login.jsp" class="login-link">계정이 있으면 로그인하세요</a>
        </div>
    </div>
    
    <script> 
    
        function findAddress() {
            new daum.Postcode({
                oncomplete: function(data) {
                    document.getElementById('zipcode').value = data.zonecode;
                    document.getElementById('address1').value = data.roadAddress;
                }
            }).open();
        }
        
		$("#idCheck").on("click", function(){
			let idValue = $("#id").val();
			$.ajax({
				url:"/idCheck.members",
				type: "get",
				dataType:"json",
				data:{
					id:$("#id").val()
				}
			}).done(function(resp){
				console.log(resp);
				
				if(resp == true){
					alert("사용불가능한 아이디입니다.")	
					$("#id").val("");
				}else{
					alert("사용가능한 아이디입니다")
				}


			});
		});
        

    </script>
</body>
</html>

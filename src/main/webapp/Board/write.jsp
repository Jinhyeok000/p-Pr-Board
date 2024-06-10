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
<body>
	<form action="/write.board" method="post" enctype="multipart/form-data">
		<table border="1" width="800" align="center">
			<thead>
				<tr>
					<th colspan="5">
						게시판 글 작성하기
					</th>
				</tr>
				<tr>
					<th width="100">
						<select>
							<option>정보</option>
						</select>
					</th>
					<th width="500">
						<input type="text" name="title" placeholder="글제목을 입력하세요" style="width:80%;">
					</th>
				</tr>
			</thead>
			<tbody>
				<tr colspan="5" height="400px">
					<td colspan="5" height="400px">
						<textarea placeholder="글 내용을 입력하세요" style="width: 90%; height:90%; border:none; resize:none;" name="contents" id="filelist">
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<input type="file" name="file" multiple style="float:left;"><br>
						<a href="/list.board">
							<input type="button" value="목록으로" style="float:right;">
							
						</a>
						<button style="float:right;">작성완료</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
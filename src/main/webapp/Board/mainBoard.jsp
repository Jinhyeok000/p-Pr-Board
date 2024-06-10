<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<style>
	td{
		border : 1px solid black;
	}
</style>
<body>
	<table border="1" align="center">
		<thead>
			<tr>
				<td>No</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</thead>	
		<tbody>
		</tbody>
		<tr align="center">
			<td colspan="4">
				<div id="navi"></div>
			</td>
		</tr>
		<tr align="center">
			<td colspan="4"><button type="button" id="writeBtn">글쓰기</button></td>
		</tr>
	</table>
	<script>
		$("#writeBtn").on("click", function(){
			location.href = "/board/writeBoard.jsp";
		});
		
		function getNaviString() {
			let currentPage = ${cpage}
			let recordTotalCount = ${record_total_count}
			let recordCountPerPage = ${record_count_per_page}
			let naviCountPerPage = ${navi_count_per_page}
			
			let pageTotalCount = 0;
			if (recordTotalCount % recordCountPerPage == 0) {
				pageTotalCount = Math.floor(recordTotalCount / recordCountPerPage);
			} else {
				pageTotalCount = Math.floor(recordTotalCount / recordCountPerPage) + 1;
			}
			console.log(pageTotalCount);
			
			let startNavi = Math.floor((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
			let endNavi = startNavi + naviCountPerPage - 1;
			if (endNavi > pageTotalCount) {
				endNavi = pageTotalCount;
			}
			
			let needNext = true;
			let needPrev = true;
			
			if(pageTotalCount <= naviCountPerPage) {
				needPrev = false;
				needNext = false;
			}else if (startNavi == 1) {
				needPrev = false;
			} else if (endNavi == pageTotalCount) {
				needNext = false;
			}
			
			let naviString = "";
			if (needPrev) {
				naviString = naviString + "<a href = '/list.board?cpage=1'>《</a>";
				naviString = naviString + "<a href = '/list.board?cpage=" + (startNavi - 1) + "'>〈</a>";
			}
			for (let i = startNavi; i <= endNavi; i++) {
				if(i == currentPage){
					naviString = naviString + "<a class='fw-bold' href = '/list.board?cpage=" + i + "'>" + i + "</a> ";
				}else{
					naviString = naviString + "<a class='text-muted' href = '/list.board?cpage=" + i + "'>" + i + "</a> ";
				}
				
			}
			if (needNext) {
				naviString = naviString + "<a href = '/list.board?cpage=" + (endNavi + 1) + "'>〉</a>";
				naviString = naviString + "<a href = '/list.board?cpage=" + pageTotalCount + "'>》</a>";
			}
			
			return naviString;
		};
		
		$(document).ready(function(){
			let naviString = getNaviString();
			$("#navi").html(naviString);
		});
	
	</script>
</body>
</html>
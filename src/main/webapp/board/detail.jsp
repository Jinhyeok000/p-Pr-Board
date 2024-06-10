<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>board detail</title>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        </head>
        <style>
            * {
                box-sizing: border-box;
            }

            .container,
            .title_box,
            .content_box,
            .btns_box {
                border: 1px solid black;
            }

            .container {
                width: 1000px;
                height: 800px;
                margin: auto;
            }

            .col {
                display: flex;
                flex-direction: column;
            }

            .row {
                display: flex;
            }

            .center {
                display: flex;
                justify-content: center;
                align-items: center;
            }
        </style>

        <body>
            <div class="container col">
                <div class="title_box" style="flex: 1;" contenteditable="false"></div>
                <div class="content_box" style="flex:8;" contenteditable="false"></div>
                <div class="btn_box center" style="flex: 1;">
                    <button class="backbtn" type="button"
                    onclick="location.href=''">목록으로</button>
                    <c:choose>
                        <c:when test="${loginID eq dto.writer}">
                            <button id="boardUpdateBtn">수정</button>
					        <button id="boardDeleteBtn">삭제</button>
                        </c:when>
                    </c:choose>
                </div>
            </div>


        </body>

        </html>
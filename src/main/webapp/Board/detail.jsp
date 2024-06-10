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
            .title,
            .content,
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

        <script>
            $("boardUpdateBtn").on("click", function () {
                updatebtn = $(this);
                deletebtn = $(this).next();

                if (updatebtn.html() == "수정") {
                    $("div[contenteditable]").attr("contenteditable", true);
                    updatebtn.html("완료");
                    deletebtn.html("취소");
                } else if (updatebtn.html() == "완료") {
                    $("div[contenteditable]").attr("contenteditable", false);

                    let form = $('<form>', { //form 동적생성
                        action: '/update.boards',
                        method: 'post'
                    });

                    let formData = [$('<input>', {
                        type: 'hidden',
                        name: 'seq',
                        value: '${dto.seq}'
                    }), $('<input>', {
                        type: 'hidden',
                        name: 'title',
                        value: $('.title').html().trim()
                    }), $('<input>', {
                        type: 'hidden',
                        name: 'content',
                        value: $('.content').html().trim()
                    })];
                    
                    form.append(formData); // 여러 개의 폼 데이터를 한꺼번에 추가 
                    form.appendTo('body').submit(); // 폼을 body에 추가하고 제출

                }
            })

            $("#boardDeleteBtn").on("click",function(){
                updatebtn = $(this).prev();
			    deletebtn = $(this);

                if(deletebtn.html()=="삭제"){
                    let result=confirm("정말 삭제하시겠습니까?");
                    if(result){
                        location.href = "/delete.boards?seq=${dto.seq}";
                    }
                }else if(deletebtn.html()=="취소"){
                    location.href = "/detail.boards?seq=${dto.seq}";
                }
            })
        </script>

        <body>
            <div class="container col">
                <div class="title" style="flex: 1;" contenteditable="false"></div>
                <div class="content" style="flex:8;" contenteditable="false"></div>
                <div class="btn_box center" style="flex: 1;">
                    <c:choose>
                        <c:when test="${loginID eq dto.writer}">
                            <button id="boardUpdateBtn">수정</button>
                            <button id="boardDeleteBtn">삭제</button>
                        </c:when>
                    </c:choose>
                    <button class="backbtn" type="button" onclick="location.href=''">목록으로</button>
                </div>
            </div>


        </body>

        </html>
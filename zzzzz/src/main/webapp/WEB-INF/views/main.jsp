<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TodoList</title>
</head>
<body>
    <h1>Todo List</h1>
    <hr>

    <%-- DB의 TB_TODO 내용 전부 보여주기 --%>
    <form action="/prop/add" method = "POST">
        <h4>할 일 추가</h4>

        <div>
            법정동 : <input type="text" name = areaTitle>
            면적(평) : <input type="text" name = py>
            층수 : <input type="number" name = floor>
            권리금 : <input type="number" name = premium>
            보증금 : <input type="number" name = deposit>
            월세 : <input type="number" name = rent>
            관리비 : <input type="number" name = adminCost>
        </div>

        <div>
            <textarea name="memo" cols="50" rows="5" placeholder="특이사항 추가"></textarea>
        </div>

        <button>추가 하기</button>


    </form>

    <hr>
    
                          <%-- fn:length(문자열 또는 컬렉션): 문자열, 컬렉션 길이 반환 --%>
    <h3>전체 매물 개수 : ${fn:length(todoList)}개
    </h3>

    <table border="1" style="border-collapse : collapse;"  >
    
        <thead>
            <th>매물번호</th>
            <th>법정동</th>
            <th>면적(평)</th>
            <th>층수</th>
            <th>권리금</th>
            <th>보증금(만원)</th>
            <th>월세(만원)</th>
            <th>관리비(만원)</th>
            <th>특이사항</th>
            
        </thead>

        <tbody>
            <c:forEach items="${todoList}" var="todo">
            
                <tr>
                    <td>${todo.todoNo}</td>
                    <td>
                        <a href="/todo/detail?todoNo=${todo.todoNo}">${todo.todoTitle}</a>
                    </td>
                    <td>${todo.complete}</td>
                    <td>${todo.regDate}</td>
                </tr>

            </c:forEach>

            <%-- DB 조회 결과를 이용해서 화면 출력 --%>
        </tbody>
    </table>

<c:if test="${not empty message}" >

    <script>
        alert("${message}");
    </script>

    <%-- 세션에 남은 메세지 지우기 --%>
    <c:remove var="message"/>
</c:if>


</body>
</html>
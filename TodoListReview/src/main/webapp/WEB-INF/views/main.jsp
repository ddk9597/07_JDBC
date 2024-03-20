<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- fn -->
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

    <form action="#" method="POST">

        <h4>할 일 추가</h4>

    </form>

    <hr>

                            <!-- {fn:length(문자열|컬렉션) : 문자열|컬렉션의 길이 반환 -->
    <h3> 전체 Todo 개수 : ${fn:length(todoList)}개 / 완료된 Todo  개수 : ${completeCount}개 </h3>
    
    
    <table border="1" style="border-collapse: collapse;">

        <thead>
            <th>번호</th>
            <th>할 일</th>
            <th>완료 여부</th>
            <th>등록 날짜</th>
        </thead>


        <tbody>
            <c:forEach items ="${todoList}" var="todo">
                <tr>
                    <td>${todo.todoNo}</td>
                    <td>${todo.todoTitle}</td>
                    <td>${todo.complete}</td>
                    <td>${todo.regDate}</td>
                </tr>
            </c:forEach>

        </tbody>

        <!-- DB 조회 결과를 이용해서 화면 출력 -->


    </table>
</body>
</html>
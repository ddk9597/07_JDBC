<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색 결과 페이지</title>

    <style>
        table{
        border-collapse : collapse;
        border : 1px solid black;
        }
    
        .todo-content{
        /* pre태그 처럼 처리 == HTML에 작성된 모양 그대로 화면에 출력*/
        white-space : pre-wrap;
        }
    </style>

</head>
<body>
    <h1>검색 결과 페이지</h1>

    <table >
        <thead>
            <tr>
            <th>매물번호</th>
            <th>법정동</th>
            <th>면적(평)</th>
            <th>층수</th>
            <th>권리금</th>
            <th>보증금(만원)</th>
            <th>월세(만원)</th>
            <th>관리비(만원)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${Properties}" var="property">
            <tr>
                <td>${Properties.PORPERTIES_NO}</td>
                <td>${Properties.LOCATION_TITLE}</td>
                <td>${Properties.PY}</td>
                <td>${Properties.FLOOR}</td>
                <td>${Properties.PREMIUM}</td>
                <td>${Properties.DEPOSIT}</td>
                <td>${Properties.RENT}</td>
                <td>${Properties.ADMIN_COST}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    
</body>
</html>
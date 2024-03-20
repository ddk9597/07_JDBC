<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

    <table border = "1" style = "border-collapse : collapse;">
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
            <c:forEach items="${Properties.properties}" var="property">
                <tr>
                    <td>${property.propertiesNo}</td>
                    <td>${property.locationTitle}</td>
                    <td>${property.py}</td>
                    <td>${property.floor}</td>
                    <td>${property.premium}</td>
                    <td>${property.deposit}</td>
                    <td>${property.rent}</td>
                    <td>${property.adminCost}</td>
                </tr>
            </c:forEach>

    <%-- 버튼 클릭 시 고객 정보 전달하기 --%>
        <h1>상담 요청하기 </h1>

            <form action="/prop/req" method = "POST">
            
            <div>
                성함 : <input type="text" name = csName>
            </div>

            <div>
                하실 업종 : <input type="text" name = plan placeholder="사무실, 병원, 소매점 등..">
            </div>

            <div>
                연락처 : <input type="number" name = csPh placeholder=" - 제외 전화번호">
            </div>

            <div>
                <textarea name="reqMemo" cols="50" rows="5" placeholder="세부 요청 사항"></textarea>
            </div>

            <button id="req">상담 요청하기</button>

            </form>

            
        </tbody>
    </table>

    
</body>
</html>
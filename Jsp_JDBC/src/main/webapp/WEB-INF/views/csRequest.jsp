<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객 요청 사항</title>
</head>
<body>
    
    
    <table border = "1" style = "border-collapse : collapse;">
    
    <h1> 고객 요청 사항 <h1>
    고객 성함 : 
    하실 업종 :
    연락처    :
    세부 요청 :

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
    </tbody>
    </table>

</body>
</html>
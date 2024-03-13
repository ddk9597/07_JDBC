<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL Core 라이브러리 추가 -->
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 부서 조회 </title>
</head>
<body>

	<h1> 전체 부서 조회 </h1>
	
	<table border="1">
	
		<thead>
			<tr>
				<th>행 번호</th>
				<th>부서 코드(DEPT_ID)</th>
				<th>부서명   (DEPT_TITLE)</th>
				<th>지역 코드(LOCATION_ID)</th>
				
				

			</tr>
		</thead>
		
		<tbody>
			<c:forEach items ="${deptList}" var="dept" varStatus="vs">
				
				<tr>
					<td>${vs.count}</td> <!-- 현재 반복횟수(1부터 시작) -->
					
					<td>${dept.deptId}</td>
					
					<td>${dept.deptTitle}</td>
					
					<td>${dept.locationId}</td>
				</tr>
				
			</c:forEach>
		</tbody>
	
	</table>
	
	<%-- session scope로 전달받은 message가 있으면 alert() 출력 --%>
	<%-- jstlcore 라이브러리 추가 필요함! --%>
	
	<c:if test="${not empty message}" >
		<%-- page ~ application 까지 message 속성이 있는지 확인해서
         존재하는 scope의 값을 얻어옴 --%>

    <script>
      const message = "${message}"
      alert(message);
    </script>

    <%-- 
      session은 브라우저 종료 또는 만료 시 까지 유지
      -> 현재 페이지에 들어올 때 마다 session의 message 계속 출력됨
      -> 1회만 message를 출력한 후 제거 
    --%>
    <c:remove var="message" scope="session" />
	</c:if>
	
	


</body>
</html>
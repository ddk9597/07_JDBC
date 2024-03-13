<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 추가 페이지</title>
</head>
<body>
    
    <h1>부서 추가 페이지 </h1>

    <%-- 상대경로 방식으로 주소 작성 --%>
    <form action="insert" method = "POST">
        <div>
            부서 코드(DEPT_ID) : <input type="text" name = "deptId">
        </div>

        <div>
            부서 이름(DEPT_TITLE) : <input type="text" name = "deptTitle">
        </div>

        <div>
            지역 코드(LOCATION_ID) : <input type="text" name = "locationId">
        </div>

        <button type = "submit"> 추가하기 </button>
    
    </form>
</body>
</html>
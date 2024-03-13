<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 추가 페이지</title>
</head>
<body>
    <h1> 부서 추가 페이지</h1>

    <%-- 주소에서 절대/상대 경로

        주소 형태 : http://ip주소(도메인):port번호/서비스요청주소
        ex) 현재 페이지 주소 : http://localhost/department/insert(GET)

        절대경로  : port번호 뒤의 / 부터 요청하려는 주소를 모두 작성
                    /department/insert
        상대경로  : 주소 제일 마지막 경로부터 원하는 요청 주소까지를 작성한다
                    insert
    
     --%>
     <%-- 상대경로 방식으로 주소 작성 --%>
    <form action="insert" method="POST">
        <div>
            부서 코드(DEPT_ID) : <input type="text" name="deptId" >
        </div>
    
        <div>
            부서 이름(DEPT_TITLE) : <input type="text" name="deptTitle" >
        </div>

        <div>
            지역 코드(LOCATION_ID) : <input type="text" name="locationId" >
        </div>
        <%-- 버튼의 타입 기본 값은 submit --%>
        <button type="submit">추가하기</button>
    </form>
</body>
</html>
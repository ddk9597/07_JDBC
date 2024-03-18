<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>매물 탐색</title>
</head>
<body>
    <h1>매물 탐색하기</h1>
    
    <h4>법정동 선택</h4>

        <form action="/properties/select" method="POST">
        <div class="areaCheck">
            <label><input type="radio" name="location" value="강일동"> 강일동</label><br>
            <label><input type="radio" name="location" value="길동"> 길동</label><br>
            <label><input type="radio" name="location" value="노고산동"> 노고산동</label><br>
            <label><input type="radio" name="location" value="논현동"> 논현동</label><br>
            <label><input type="radio" name="location" value="대현동"> 대현동</label><br>
            <label><input type="radio" name="location" value="대흥동"> 대흥동</label><br>
            <label><input type="radio" name="location" value="둔촌동"> 둔촌동</label><br>
            <label><input type="radio" name="location" value="명일동"> 명일동</label><br>
            <label><input type="radio" name="location" value="북가좌동"> 북가좌동</label><br>
            <label><input type="radio" name="location" value="북아현동"> 북아현동</label><br>
            <label><input type="radio" name="location" value="상암동"> 상암동</label><br>
            <label><input type="radio" name="location" value="성내동"> 성내동</label><br>
            <label><input type="radio" name="location" value="성산동"> 성산동</label><br>
            <label><input type="radio" name="location" value="성수1가"> 성수1가</label><br>
            <label><input type="radio" name="location" value="성수2가"> 성수2가</label><br>
            <label><input type="radio" name="location" value="아현동"> 아현동</label><br>
            <label><input type="radio" name="location" value="연남동"> 연남동</label><br>
            <label><input type="radio" name="location" value="연희동"> 연희동</label><br>
            <label><input type="radio" name="location" value="영천동"> 영천동</label><br>
            <label><input type="radio" name="location" value="장안동"> 장안동</label><br>
            <label><input type="radio" name="location" value="중동"> 중동</label><br>
            <label><input type="radio" name="location" value="창천동"> 창천동</label><br>
            <label><input type="radio" name="location" value="천호동"> 천호동</label><br>
            <label><input type="radio" name="location" value="충정로1가"> 충정로1가</label><br>
            <label><input type="radio" name="location" value="충정로2가"> 충정로2가</label><br>
        </div>

    <h4> 종류 선택</h4>
    <label><input type="radio" name="category" value="상가">상가</label>
    <label><input type="radio" name="category" value="사무실">사무실</label>

    <h4>최대 면적 선택(평)</h4>
    최소면적 : <input type="number" name="py" value="minPy">
    최대면적 : <input type="number" name="py" value="maxPy"> 

    <button type="submit">매물 검색하기</button>


    </form>

    
    





</body>
</html>
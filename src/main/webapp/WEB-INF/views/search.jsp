<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<h2>회원 정보 조회</h2>
	<hr>
	<form action="searchOk">
		회원아이디 : <input type="text" name="mid">
		<input type="submit" value="회원조회"><br><br>
		<input type="button" value="메인화면으로" onclick="javascript:window.location.href='' "> 
	</form>
</body>
</html>
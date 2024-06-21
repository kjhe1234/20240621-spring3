<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<h2>회원 탈퇴</h2>
	<hr>
	<form action="deleteOk">
		아이디 : <input type="text" name="mid">
		<input type="submit" value="회원탈퇴"><br><br>
		<input type="button" value="메인화면으로" onclick="javascript:window.location.href='' "> 
	</form>
</body>
</html>
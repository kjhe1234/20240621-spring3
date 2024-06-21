<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 결과</title>
</head>
<body>
	<h2>회원 정보 수정 결과</h2>
	<hr>
	아이디 : ${memberDto.mid }<br><br>
	이름 : ${memberDto.mname }<br><br>
	이메일 : ${memberDto.memail }<br><br>
	가입일: ${memberDto.mdate }<br><br>

</body>
</html>
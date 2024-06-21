<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회 결과</title>
</head>
<body>
	<h2>회원 정보</h2>
	<hr>
	<form action="modifyOk">
	<input type="hidden" name="mid" value="${memberDto.mid }">
	아이디 : <input type="text" name="mid" value="${memberDto.mid }" readonly="readonly"><br><br>
	이름 : <input type="text" name="mname" value="${memberDto.mname }"><br><br>
	이메일 : <input type="text" name="memail" value="${memberDto.memail }"><br><br>
	가입일 : ${memberDto.mdate }<br><br>
	<input type="submit" value="수정완료">
	</form>
	${error }
	
</body>
</html>
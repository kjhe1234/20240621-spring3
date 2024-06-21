<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h2>회원 리스트</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="800">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		
		<c:forEach items="${mDtos}" var="memberDto">
		<tr>
			<td>
			<a href="searchOk?mid=${memberDto.mid}" >${memberDto.mid}</a>
			</td>
			<td>${memberDto.mpw}</td>
			<td>${memberDto.mname}</td>
			<td>${memberDto.memail}</td>
			<td>${memberDto.mdate}</td>
			<td>
			<input type="button" value="회원 탈퇴하기" onclick="javascript:window.location.href='deleteOk?mid=${memberDto.mid}' "> 
			</td>
		</tr>
		</c:forEach>
	</table>
	<input type="button" value="메인화면으로" onclick="javascript:window.location.href='' "> 
</body>
</html>
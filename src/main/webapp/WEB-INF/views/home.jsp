<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
</head>
<body>
	<h1> Welcome! </h1>
	<P>now is ${serverTime}.</P>	
	<a href="${pageContext.request.contextPath}/goGuestBookPage" target="_self">방명록 이동</a>

</body>
</html>

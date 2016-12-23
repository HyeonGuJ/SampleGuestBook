<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HG's GuestBook</title>

</head>
<body>

	<br />&nbsp;
	<br />

	<table width="300" border="2" cellpadding="0" cellspacing="0"	bordercolor="#D6D4D6" align="center">
		<tr height="40">
			<td align="center"><b >방 명 록</b></td>
		</tr>
	</table>

	<br />&nbsp;


	<!--  write button -->
	<table align="center">
		<tr height="40">
		<td align="center">
			<form id="writeButton" name="writeButton" 	action="${pageContext.request.contextPath}/goToWritePage">			
				<input type= "submit"  id="write" name="write"value="write" width="100" hight="50">				
			</form>
		</td> 
		</tr>
	</table>	
	
	
	
	<br/>

	<!--  show messages -->
	<table width="600" border="0" cellpadding="0" cellspacing="0"
		align="center">
		<tr>
			<td width="600" colspan="2" height="3" bgcolor="#E6D4A6"></td>
		</tr>
		<c:forEach var="item" items="${list}" varStatus="status">
			<tr height="25">
				<td width="50%" align="left">NO. ${item.idMessage}&nbsp;&nbsp;:
					${item.email}</td>
				<td width="50%" align="right">${item.modifiedDate}&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/goToModifyMessage?idMessage=${item.idMessage}">수정</a>
				</td>
			</tr>
			<tr>
				<td width="600" colspan="2" height="1" bgcolor="#E6D4A6"></td>
			</tr>
			<tr height="60">
				<td align="left" style="padding: 5px 5px 5px 5px;" valign="top">
					<pre>${item.text}</pre>
				</td>
			</tr>
			<tr>
				<td width="600" colspan="2" height="3" bgcolor="#E6D4A6"></td>
			</tr>
		</c:forEach>

		<tr height="25">
			<td width="50%" align="center"> end of message </td>
		</tr>

	</table>


</body>
</html>

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
	<br />


	<form id="messageWriteForm" name="messageWriteForm" method="RequestMethod.POST" 
	action="${pageContext.request.contextPath}/insertMessage">
	
		
		<table width="600" border="0" cellpadding="0" cellspacing="0"	align="center">
			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FD893C"></td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FFFFFF"></td>
			</tr>
			
			
			<tr>
				<td width="120" height="30" bgcolor="#EEEEEE" align="center">email	</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left" colspan="3">
					<input type="email" name="email" size="35"maxlength="20" value ="${object.email}"  />	</td>
			</tr>
			<tr>
				<td width="120" height="30" bgcolor="#EEEEEE" align="center">password</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left"colspan="3">
					<input type="password" name="password"	size="35" maxlength="20" value ="${object.password}" /> </td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="1" bgcolor="#FD893C"></td>
			</tr>
			<tr>
				<td width="120" height="30" bgcolor="#EEEEEE" align="center">text
					(max 300)</td>
				<td width="480" colspan="3" style="padding-left: 10px;" align="left">
					<textarea id="text" name="text" rows="3" cols="84" style="height: 50px;" maxlength="300"></textarea>	</td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FFFFFF"></td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FD893C"></td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="35" align="right" style="padding-right: 15px;">
				<input type="submit" value="submit" />
				<input type="reset" value="reset " onclick="document.myForm.name.focus();" /></td>
			</tr>
			<br />
		</table>
	</form>	
    
</body>
</html>

	<form name="myForm" method="post" action="">
		<table width="600" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FD893C"></td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FFFFFF"></td>
			</tr>
			<tr>
				<td width="120" height="30" bgcolor="#EEEEEE" align="center">email</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left"
					colspan="3"><input type="text" name="email" size="35"
					maxlength="20" class="boxTF" /></td>
			</tr>
			<tr>
				<td width="120" height="30" bgcolor="#EEEEEE" align="center">password</td>
				<td width="240" height="30" style="padding-left: 10px;" align="left"
					colspan="3"><input type="password" name=password
					"
						size="35" maxlength="20" class="boxTF" /></td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="1" bgcolor="#FD893C"></td>
			</tr>
			<tr>
				<td width="120" height="30" bgcolor="#EEEEEE" align="center">text
					(max 300)</td>
				<td width="480" colspan="3" style="padding-left: 10px;" align="left"><textarea
						name="content" rows="3" cols="84" style="height: 50px;"></textarea></td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FFFFFF"></td>
			</tr>

			<tr>
				<td width="600" colspan="4" height="3" bgcolor="#FD893C"></td>
			</tr>
			<tr>
				<td width="600" colspan="4" height="35" align="right"
					style="padding-right: 15px;"><input type="button" value="등록하기"
					class="btn2" onclick="sendIt()" /> <input type="reset"
					value=" 다시입력 " onclick="document.myForm.name.focus();" class="btn2" /></td>
			</tr>
			<br />
		</table>
	</form>
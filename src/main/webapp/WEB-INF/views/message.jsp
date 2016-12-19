<br/>
<table width="600" border="0" cellpadding="0" cellspacing="0" align="center">

<!-- if there is no message -->
    <tr><td width="600" colspan="2" height="3" bgcolor="#E6D4A6"></td></tr>
    <tr><td width="600" colspan="2" height="30" bgcolor="#E6D4A6">등록된 게시물이 없습니다.</td></tr>
    <tr><td width="600" colspan="2" height="3" bgcolor="#E6D4A6"></td></tr>   

<!-- if message is exist -->
    <tr><td width="600" colspan="2" height="3" bgcolor="#E6D4A6"></td></tr>
     <c:forEach var="item" items="${list}" varStatus="status">
        <tr height="25">
            <td width="50%" align="left">NO. ${item.idMessage}&nbsp;&nbsp;:  ${item.idMessage}</td>
            <td width="50%" align="right">${item.modifiedDate}&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/modifyMessage">수정</a></td>
            
        </tr>
        <tr><td width="600" colspan="2" height="1" bgcolor="#E6D4A6"></td></tr>
        <tr height="60">
            <td align="left" style="padding: 5px 5px 5px 5px;" valign="top">
                <pre>${item.text}</pre>
            </td>
        </tr>
        <tr><td width="600" colspan="2" height="3" bgcolor="#E6D4A6"></td></tr>
	</c:forEach>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/code-snippet.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/component-calendar.js"></script>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
</head>
<body>
	<h1>Welcome!</h1>

	<!-- include application-chart.min.css -->



	<P>now is ${serverTime}.</P>
	<a href="${pageContext.request.contextPath}/goGuestBookPage"
		target="_self">방명록 이동</a>
	<p></p>
	<a href="${pageContext.request.contextPath}/goToTuiPage" target="_self">Tui
		Testing</a>

	<div id="layer" class="layer">
		<!-- 기준 엘리먼트 -->
		<div class="calendar-header">
			<a href="#" class="rollover calendar-btn-prev-year">이전해</a>
			<!-- 이전년 버튼 (생략가능) -->
			<a href="#" class="rollover calendar-btn-prev-month">이전달</a>
			<!-- 이전달 버튼 (생략가능) -->
			<strong class="calendar-title"></strong>
			<!-- 달력의 타이틀 (생략가능) -->
			<!--<strong class="calendar-title-year"></strong> &lt;!&ndash; 달력의 타이틀 (생략가능) &ndash;&gt;-->
			<!--<strong class="calendar-title-month"></strong> &lt;!&ndash; 달력의 타이틀 (생략가능) &ndash;&gt;-->
			<a href="#" class="rollover calendar-btn-next-month">다음달</a>
			<!-- 다음달 버튼 (생략가능) -->
			<a href="#" class="rollover calendar-btn-next-year">다음해</a>
			<!-- 다음년 버튼 (생략가능) -->
		</div>
		<table cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th class="sun">Su</th>
					<th>Mo</th>
					<th>Tu</th>
					<th>We</th>
					<th>Th</th>
					<th>Fa</th>
					<th class="sat">Sa</th>
				</tr>
			</thead>
			<tbody>
				<tr class="calendar-week">
					<!-- 달력의 한 주에 해당하는 엘리먼트 컨테이너 -->
					<td class="calendar-date"></td>
					<!-- 날짜가 표시될 엘리먼트 -->
					<td class="calendar-date"></td>
					<td class="calendar-date"></td>
					<td class="calendar-date"></td>
					<td class="calendar-date"></td>
					<td class="calendar-date"></td>
					<td class="calendar-date"></td>
				</tr>
			</tbody>
		</table>
		<div class="calendar-bottom">
			<p>
				오늘 <em class="calendar-today"></em>
			</p>
		</div>
	</div>



</body>
</html>

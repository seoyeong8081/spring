<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 코드작성 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="container">
		<h1>도서 목록</h1>
		<table class="table table-striped table-hover mb-5">
			<thead class="border-top">
				<th>번호</th>
				<th>ISBN</th>
				<th>저자</th>
				<th>가격</th>
			</thead>
			<c:forEach var="book" items="${books}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${book.isbn}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
		</table>
		<a href="${root}/regist">도서 등록</a>
	</div>
</body>
</html>
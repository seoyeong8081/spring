<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
</head>
<body>
	<!-- 코드작성 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="container">
		<h1>도서 등록 결과</h1>
		<table class="table">
			<thead class="border-top border-bottom-0">
				<tr>
					<th>항목</th>
					<th>내용</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>도서번호</td>
					<td>${book.isbn}</td>
					<td rowspan="5"></td>
				</tr>
				<tr>
					<td>도서명</td>
					<td>${book.title}</td>
				</tr>
				<tr>
					<td>저자</td>
					<td>${book.author}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${book.price}</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td>${book.img}</td>
				</tr>
				<tr class="border-white">
					<td>설명</td>
					<td>${book.content}</td>
				</tr>
			</tbody>
		</table>
		<a href="${root}/regist">[추가등록]</a>
		<a href="${root}/list">[목록보기]</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label, form>select, form>input {
	margin-right: 10px !important;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>도서 목록</h1>
		
		<form method="get" action="${root }/list" id="searchForm" class="d-flex justify-content-end">
			<!-- 코드작성 -->
			<div class="input-group mt-2">
				<select class="form-select" id="key" name="key">
					<option value="none" selected>검색조건</option>
					<option value="isbn">ISBN</option>
					<option value="title">제목</option>
					<option value="author">저자</option>
					<!-- <option value="price">가격</option> -->
				</select>
				<input type="text" class="form-control" id="word" name="word" placeholder="검색어"/>
				<!-- 검색 버튼 -->
				<input type="button" id="searchForm-btn" class="btn btn-primary" value="검색"/>
			</div>
			<div class="input-group mt-2 ms-3">
				<select class="form-select" id="orderBy" name="orderBy">
					<option value="none" selected>정렬기준</option>
					<option value="isbn">ISBN</option>
					<option value="title">제목</option>
					<option value="author">저자</option>
					<option value="price">가격</option>
				</select>
				<select class="form-select" id="orderByDir" name="orderByDir">
					<option value="none" selected>정렬방식</option>
					<option value="asc">오름차순</option>
					<option value="desc">내림차순</option>
				</select>
			</div>
			<input type="hidden" id="currentPage" name="currentPage" value="1" />
		</form>
		<script>
			<c:if test="${!empty condition.key}">
				document.querySelector("#key").value = '${condition.key}';
				document.querySelector("#word").value = '${condition.word}';
			</c:if>
			<c:if test="${!empty condition.orderBy}">
				document.querySelector("#orderBy").value = '${condition.orderBy}';
				document.querySelector("#orderByDir").value = '${condition.orderByDir}';
			</c:if>
			<c:if test="${!empty condition.currentPage}">
				document.querySelector("#currentPage").value = '${condition.currentPage}';
			</c:if>
			
			document.querySelector("#orderByDir").addEventListener("change", function() {
				if (document.querySelector("#orderBy").value != "none" && document.querySelector("#orderByDir").value != "none") {
					document.querySelector("#currentPage").value = "1";
					document.querySelector("#searchForm").submit();
				}
			});
			
			document.querySelector("#searchForm-btn").addEventListener("click", function() {
				document.querySelector("#currentPage").value = "1";
				document.querySelector("#searchForm").submit();
			});
		</script>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>ISBN</th>
					<th>제목</th>
					<th>저자</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<%-- request 영역에 books로 등록된 자료를 반복문을 이용해 출력한다. --%>
				<c:forEach items="${books }" var="book" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${book.isbn }</td>
						<td>${book.title }</td>
						<td>${book.author }</td>
						<td>${book.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<%@ include file="/WEB-INF/views/include/paging.jsp"%>
		<a href="${root }/regist">도서 등록</a>
	</div>
</body>
</html>
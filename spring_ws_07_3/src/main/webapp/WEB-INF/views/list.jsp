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
				<select class="form-select" name="key">
					<option value="" selected>검색조건</option>
					<option value="isbn">ISBN</option>
					<option value="title">제목</option>
					<option value="author">저자</option>
					<!-- <option value="price">가격</option> -->
				</select>
				<input type="text" class="form-control" name="word" placeholder="검색어"/>
				<!-- 검색 버튼 -->
			</div>
			<div class="input-group mt-2 ms-3">
				<select class="form-select" name="orderBy">
					<option value="" selected>정렬기준</option>
					<option value="isbn">ISBN</option>
					<option value="title">제목</option>
					<option value="author">저자</option>
					<option value="price">가격</option>
				</select>
				<select class="form-select" name="orderByDir">
					<option value="" selected>정렬방식</option>
					<option value="asc">오름차순</option>
					<option value="des">내림차순</option>
				</select>
			</div>
			<input type="hidden" name="currentPage" value="1" />
		</form>
		
		<!-- String key, String word, String orderBy, String orderByDir, int currentPage -->
		<!-- <div class="input-group mb-3">
			<span class="input-group-text">도서번호</span>
			<input type="text" id="isbn" name="isbn" class="form-control">
		</div> -->
		<!-- <form class="d-flex" id="form-search" action="">
          <input type="hidden" name="pgno" value="1"/>
          <select
            class="form-select form-select-sm ms-5 me-1 w-50"
            name="key"
            aria-label="검색조건"
          >
            <option value="" selected>검색조건</option>
            <option value="subject">제목</option>
            <option value="userid">작성자</option>
          </select>
          <div class="input-group input-group-sm">
            <input type="text" class="form-control" name="word" placeholder="검색어..." />
            <button id="btn-search" class="btn btn-dark" type="button">검색</button> 안해도될듯?submit 또는 페이지 로드하면 바로 해야하나? 페이지 로드할 경우 어떻게 처리?
          </div>
        </form> -->
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
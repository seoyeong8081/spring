<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<!-- 코드작성 -->
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="container">
		<h1>도서 등록</h1>
		<form method="post" action="regist">
			<div class="form-group row mb-3">
				<label class="col-1" for="isbn">도서번호</label>
				<div class="col-3">
					<input type="text" class="form-control" id="isbn" name="isbn">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label class="col-1" for="title">도서명</label>
				<div class="col-3">
					<input type="text" class="form-control" id="title" name="title">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label class="col-1" for="author">저자</label>
				<div class="col-3">
					<input type="text" class="form-control" id="author" name="author">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label class="col-1" for="author">가격</label>
				<div class="col-3">
					<input type="text" class="form-control" id="price" name="price">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label class="col-1" for="img">이미지</label>
				<div class="col-3">
					<input type="file" class="form-control-file" id="img" name="file" accept="image/*">
				</div>
			</div>
			<div class="form-group mb-3">
				<label class="mb-3" for="desc">설명</label>
				<textarea class="form-control" rows="2" id="desc" name="content"></textarea>
			</div>
			
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</div>
</body>
</html>
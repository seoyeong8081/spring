<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
/*페이징 요소를 가운데로 정렬한다.*/
.pagination {
	justify-content: center;
}
</style>

<nav>
	<ul class="pagination">
		<li class="page-item" data-pg="1"><a class="page-link" href="#">최신</a></li>
		<li class="page-item" data-pg="1"><a class="page-link" href="#">이전</a></li>
	    <li class="page-item active" data-pg="1"><a class="page-link" href="#">1</a></li>
	    <li class="page-item" data-pg="1"><a class="page-link" href="#">다음</a></li>
	    <li class="page-item" data-pg="1"><a class="page-link" href="#">마지막</a></li>
	</ul>
</nav>

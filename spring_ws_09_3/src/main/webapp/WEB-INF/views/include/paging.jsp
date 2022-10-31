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
		<c:if test="${startRange}">
			<li class="page-item" data-pg="1"><a class="page-link" href="#">이전</a></li>
		</c:if>
		<c:if test="${!startRange}">
			<li class="page-item" data-pg="${startPage - 1}"><a class="page-link" href="#">이전</a></li>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == condition.currentPage}">
			    <li class="page-item active" data-pg="${i}"><a class="page-link" href="#">${i}</a></li>
			</c:if>
			<c:if test="${i != condition.currentPage}">
			    <li class="page-item" data-pg="${i}"><a class="page-link" href="#">${i}</a></li>
			</c:if>
		</c:forEach>
	    
	    <c:if test="${endRange}">
			<li class="page-item" data-pg="${endPage}"><a class="page-link" href="#">다음</a></li>
		</c:if>
		<c:if test="${!endRange}">
			<li class="page-item" data-pg="${endPage + 1}"><a class="page-link" href="#">다음</a></li>
		</c:if>
	    <li class="page-item" data-pg="${totalPageCount}"><a class="page-link" href="#">마지막</a></li>
	</ul>
</nav>

<script>
let pages = document.querySelectorAll(".page-item");
pages.forEach(function (page) {
  page.addEventListener("click", function () {
  	let form = document.querySelector("#searchForm");
  	document.querySelector("#currentPage").value = page.getAttribute("data-pg");
    form.submit();
  });
});
</script>

package com.ssafy.util;

public class PageNavigation {
	
	private boolean startRange; // 이전 버튼 있어야하는지 없어야하는지
	private boolean endRange;
	private int totalCount; // 총 글의 개수 (DB에서 얻어오기)
	private int newCount;
	private int totalPageCount; // (totalCount - 1) / 20 + 1 
	private int currentPage; // 현재 페이지 번호
	private int naviSize; // 네비게이션에서 페이지 개수
	private int countPerPage;
	private String navigator; // 네이게이션 만들어줌

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNewCount() {
		return newCount;
	}

	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public String getNavigator() {
		return navigator;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public void makeNavigator() {
		int startPage = (currentPage - 1) / naviSize * naviSize + 1;
		int endPage = startPage + naviSize - 1;
		if(totalPageCount < endPage)
			endPage = totalPageCount;
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("		<ul class=\"pagination  justify-content-center\"> \n");
		buffer.append("			<li class=\"page-item\" data-pg=\"1\"> \n");
		buffer.append("				<a href=\"#\" class=\"page-link\">최신</a> \n");
		buffer.append("			</li> \n");
		buffer.append("			<li class=\"page-item\" data-pg=\"" + (this.startRange ? 1 : (startPage - 1)) + "\"> \n");
		buffer.append("				<a href=\"#\" class=\"page-link\">이전</a> \n");
		buffer.append("			</li> \n");
		for(int i=startPage;i<=endPage;i++) {
			buffer.append("			<li class=\"" + (currentPage == i ? "page-item active" : "page-item") + "\" data-pg=\"" + i + "\"><a href=\"#\" class=\"page-link\">" + i + "</a></li> \n");
		}
		buffer.append("			<li class=\"page-item\" data-pg=\"" + (this.endRange ? endPage : (endPage + 1)) + "\"> \n");
		buffer.append("				<a href=\"#\" class=\"page-link\">다음</a> \n");
		buffer.append("			</li> \n");
		buffer.append("			<li class=\"page-item\" data-pg=\"" + totalPageCount + "\"> \n");
		buffer.append("				<a href=\"#\" class=\"page-link\">마지막</a> \n");
		buffer.append("			</li> \n");
		buffer.append("		</ul> \n");
		this.navigator = buffer.toString();
	}

}

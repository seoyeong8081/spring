package com.ssafy.notice.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.notice.model.NoticeDto;

public interface NoticeDao {

	int countArticle() throws SQLException;
	int writeArticle(NoticeDto noticeDto) throws SQLException;
	List<NoticeDto> listArticle(Map<String, String> map) throws SQLException;
	List<NoticeDto> preview(int num) throws SQLException;
	NoticeDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	void modifyArticle(NoticeDto noticeDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
}

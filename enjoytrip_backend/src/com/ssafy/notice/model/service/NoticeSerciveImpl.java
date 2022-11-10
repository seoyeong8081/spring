package com.ssafy.notice.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.notice.model.NoticeDto;
import com.ssafy.notice.model.dao.NoticeDao;
import com.ssafy.notice.model.dao.NoticeDaoImpl;
import com.ssafy.util.SizeConstant;

public class NoticeSerciveImpl implements NoticeService {

	private static NoticeService noticeSercive = new NoticeSerciveImpl();
	private NoticeDao noticeDao;
	
	private NoticeSerciveImpl() {
		noticeDao = NoticeDaoImpl.getNoticeDao();
	}
	
	public static NoticeService getNoticeService() {
		return noticeSercive;
	}
	
	@Override
	public int countArticle() throws Exception {
		return noticeDao.countArticle();
	}


	@Override
	public List<NoticeDto> listArticle(Map<String, String> map) throws Exception {
		int pgno = Integer.parseInt(map.get("pgno"));
		int spl = SizeConstant.SIZE_PER_LIST;
		int start = (pgno - 1) * spl;
		map.put("start", start + "");
		map.put("spl", spl + "");
		return noticeDao.listArticle(map);
	}

	@Override
	public List<NoticeDto> preview(int num) throws Exception {
		return noticeDao.preview(num);
	}

	@Override
	public int writeArticle(NoticeDto noticeDto) throws Exception {
		return noticeDao.writeArticle(noticeDto);
	}
	
	@Override
	public NoticeDto getArticle(int articleNo) throws Exception {
		return noticeDao.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		noticeDao.updateHit(articleNo);

	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		noticeDao.deleteArticle(articleNo);
	}

	@Override
	public void modifyArticle(NoticeDto noticeDto) throws Exception {
		noticeDao.modifyArticle(noticeDto);
		
	}


}

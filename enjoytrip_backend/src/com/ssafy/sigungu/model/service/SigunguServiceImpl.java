package com.ssafy.sigungu.model.service;

import java.util.List;

import com.ssafy.sigungu.model.SigunguDto;
import com.ssafy.sigungu.model.dao.SigunguDao;
import com.ssafy.sigungu.model.dao.SigunguDaoImpl;

public class SigunguServiceImpl implements SigunguService {

	private static SigunguService sigunguService = new SigunguServiceImpl();
	private SigunguDao sigunguDao;
	
	private SigunguServiceImpl() {
		sigunguDao = SigunguDaoImpl.getSigunguDao();
	}
	
	public static SigunguService getSigunguService() {
		return sigunguService;
	}
	
	@Override
	public List<SigunguDto> list(int areaCode) throws Exception {
		return sigunguDao.list(areaCode);
	}

}

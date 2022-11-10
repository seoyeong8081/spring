package com.ssafy.do17.model.service;

import java.util.List;

import com.ssafy.do17.model.DoDto;
import com.ssafy.do17.model.dao.DoDao;
import com.ssafy.do17.model.dao.DoDaoImpl;

public class DoServiceImpl implements DoService {

	private static DoService doService = new DoServiceImpl();
	private DoDao doDao;
	
	private DoServiceImpl() {
		doDao = DoDaoImpl.getDoDao();
	}
	
	public static DoService getDoService() {
		return doService;
	}
	
	@Override
	public List<DoDto> list() throws Exception {
		return doDao.list();
	}

}

package com.ssafy.tourlist.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.tourlist.model.TourListDto;
import com.ssafy.tourlist.model.dao.TourListDao;
import com.ssafy.tourlist.model.dao.TourListDaoImpl;

public class TourListServiceImpl implements TourListService {

	private static TourListService tourListService = new TourListServiceImpl();
	private TourListDao tourListDao;
	
	private TourListServiceImpl() {
		tourListDao = TourListDaoImpl.getTourListDao();
	}
	
	public static TourListService getTourListService() {
		return tourListService;
	}
	
	@Override
	public TourListDto recommend(int contentTypeId) throws Exception {
		return tourListDao.recommend(contentTypeId);
	}

	@Override
	public List<TourListDto> getData(Map<String, Integer> map) throws Exception {
		return tourListDao.getData(map);
	}


}

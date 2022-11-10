package com.ssafy.tourlist.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.tourlist.model.TourListDto;

public interface TourListService {
	
	TourListDto recommend(int contentTypeId) throws Exception;
	List<TourListDto> getData(Map<String, Integer> map) throws Exception;
}

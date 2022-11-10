package com.ssafy.tourlist.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.tourlist.model.TourListDto;

public interface TourListDao {
	
	TourListDto recommend(int contentTypeId) throws SQLException;
	List<TourListDto> getData(Map<String, Integer> map) throws SQLException;
	
}

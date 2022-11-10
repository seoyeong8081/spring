package com.ssafy.sigungu.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sigungu.model.SigunguDto;

public interface SigunguDao {
	
	List<SigunguDto> list(int areaCode) throws SQLException;
}

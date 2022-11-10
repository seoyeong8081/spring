package com.ssafy.do17.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.do17.model.DoDto;

public interface DoDao {

	List<DoDto> list() throws SQLException;
}

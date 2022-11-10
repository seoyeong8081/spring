package com.ssafy.do17.model.service;

import java.util.List;

import com.ssafy.do17.model.DoDto;

public interface DoService {
	
	List<DoDto> list() throws Exception;
}

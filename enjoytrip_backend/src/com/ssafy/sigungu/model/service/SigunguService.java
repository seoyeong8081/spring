package com.ssafy.sigungu.model.service;

import java.util.List;

import com.ssafy.sigungu.model.SigunguDto;

public interface SigunguService {
	
	List<SigunguDto> list(int areaCode) throws Exception;
}

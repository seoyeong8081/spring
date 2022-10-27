package com.ssafy.ws.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.UserDto;

@Mapper
public interface UserMapper {

	UserDto login(Map<String, String> map);
	
}

package com.ssafy.user.model.dao;

import java.sql.SQLException;

import com.ssafy.user.model.UserDto;

public interface UserDao {
	
	int checkID(String userId) throws SQLException;

	String findPass(String userId, String userName) throws SQLException;

	int joinUser(UserDto userDto) throws SQLException;

	UserDto loginUser(String userId) throws SQLException;

	int modifyUser(UserDto userDto) throws SQLException;

	int deleteUser(String userId) throws SQLException;

}

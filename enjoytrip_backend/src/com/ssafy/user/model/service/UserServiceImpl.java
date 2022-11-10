package com.ssafy.user.model.service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private static UserService userService = new UserServiceImpl();

	private UserDao userDao;

	private UserServiceImpl() {
		userDao = UserDaoImpl.getUserDao();
	}

	public static UserService getUserService() {
		return userService;
	}

	@Override
	public int checkID(String userId) throws Exception {
		return userDao.checkID(userId);
	}

	@Override
	public String findPass(String userId, String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findPass(userId, userName);
	}

	@Override
	public int joinUser(UserDto userDto) throws Exception {
		return userDao.joinUser(userDto);
	}

	@Override
	public UserDto loginUser(String userId) throws Exception {
		return userDao.loginUser(userId);
	}

	@Override
	public int modifyUser(UserDto userDto) throws Exception {
		return userDao.modifyUser(userDto);
	}

	@Override
	public int deleteUser(String userId) throws Exception {
		return userDao.deleteUser(userId);
	}

}

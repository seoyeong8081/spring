package com.ssafy.ws.model.service;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.repo.UserRepo;

public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

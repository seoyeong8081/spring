package com.ssafy.hw.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
	
	private final static Logger logger = LoggerFactory.getLogger(UserTest.class);
	
//	@Autowired
	private static UserDao userDao;
	
//	@Autowired
//	public UserTest(UserDao userDao) {
//		this.userDao = userDao;
//	}
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		userDao = context.getBean(UserDao.class);
		
		insertTest();
		searchByIdTest();
		searchByName();
		selectAll();
	}
	
	private static void insertTest() {
		User user = new User("ssafy2", "pass", "조싸피", "herz@skt.com", 27);
		User user2 = new User("hello", "hi", "김안녕", "hello@ssafy.com", 15);
		userDao.insert(user);
		userDao.insert(user2);
	}
	
	private static void searchByIdTest() {
		User user = userDao.searchById("ssafy");
		logger.debug("searchById ssafy : {}", user);
		System.out.println("searchById ssafy : " + user);
	}

	private static void searchByName() {
		List<User> list = userDao.searchByName("싸피");
		System.out.println("searchByName 싸피");
		for (User user : list) {
			logger.debug("searchByName 싸피 : {}", user);
			System.out.println(user);
		}
	}

	private static void selectAll() {
		List<User> list = userDao.selectAll();
		System.out.println("selectAll");
		for (User user : list) {
			logger.debug("selectAll : {}", user);
			System.out.println(user);
		}
	}
	
}

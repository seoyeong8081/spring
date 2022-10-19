package com.ssafy.ws;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.BookRepoImpl;
import com.ssafy.ws.model.repo.UserRepo;
import com.ssafy.ws.model.repo.UserRepoImpl;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;
import com.ssafy.ws.model.service.UserServiceImpl;

public class WS_01_BeanCreationTest extends AbstractTest{
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");;
	
	private static BookRepo bookRepo;
	private static UserRepo userRepo;
	private static BookService bookService;
	private static UserService userService;
	
	public static void main(String[] args) {
		WS_01_BeanCreationTest test = new WS_01_BeanCreationTest();
		test.testConstruct();
		test.testSingleton();
		test.testDataSource();
	}

	@Override
	void testConstruct() {
		bookRepo = context.getBean("bookRepo", BookRepoImpl.class);
		userRepo = context.getBean("userRepo", UserRepoImpl.class);
		bookService = context.getBean("bookService", BookServiceImpl.class);
		userService = context.getBean("userService", UserServiceImpl.class);
	}

	@Override
	void testSingleton() {
		BookServiceImpl bookServiceImpl = context.getBean("bookService", BookServiceImpl.class);
		System.out.println(bookRepo + " " + bookServiceImpl.getBookRepo());
	}

	@Override
	void testDataSource() {
		DataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
		System.out.println(dataSource);
	}
}

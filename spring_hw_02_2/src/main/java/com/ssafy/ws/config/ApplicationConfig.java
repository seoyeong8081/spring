package com.ssafy.ws.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.BookRepoImpl;
import com.ssafy.ws.model.repo.UserRepo;
import com.ssafy.ws.model.repo.UserRepoImpl;
//import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;
import com.ssafy.ws.model.service.UserServiceImpl;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.ssafy"})
public class ApplicationConfig {
	
	private UserRepo userRepo;
	private BookRepo bookRepo;
	
	@Bean(value = "userRepo")
	public UserRepo getUserRepo() {
		userRepo = new UserRepoImpl();
		return userRepo;
	}
	
	@Bean(value = "userService")
	public UserService getUserService() {
		UserService userService = new UserServiceImpl(userRepo);
		return userService;
	}
	
	@Bean(value = "bookRepo")
	public BookRepo getBookRepo() {
		bookRepo = new BookRepoImpl();
		return bookRepo;
	}
	
	@Bean(value = "bookService")
	public BookServiceImpl getBookService() {
		BookServiceImpl bookService = new BookServiceImpl();
		bookService.setBookRepo(bookRepo);
		return bookService;
	}
	
	@Bean(value = "dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		return dataSource;
	}
	
}


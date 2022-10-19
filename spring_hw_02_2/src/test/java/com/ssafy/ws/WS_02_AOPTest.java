package com.ssafy.ws;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.ws.config.ApplicationConfig;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;

public class WS_02_AOPTest {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
	public static BookService bservice;
	
	public void testConstruct() {
		bservice = context.getBean("bookService", BookService.class);
	}
	
	public void testInsert() {
		bservice.insert(null);
		bservice.select("111-222-3333");
		bservice.search();
	}
	
	void testDataSource() {
		DataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
		System.out.println(dataSource);
	}
	
}

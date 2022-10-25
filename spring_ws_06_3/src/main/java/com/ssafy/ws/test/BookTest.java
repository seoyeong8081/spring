package com.ssafy.ws.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.Book;

public class BookTest {
	public static void main(String[] args) {
		//코드작성		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		BookDao bookDao = context.getBean(BookDao.class);
		UserDao userDao = context.getBean(UserDao.class);
		
		// 도서 등록
		bookDao.insert(new Book("111-222-8081", "조서영", "조서영 일기", 250000, "화이팅", "표지 경로"));
		
		// 도서 전체 조회
		System.out.println("-----------------도서 전체 조회-----------------");
		List<Book> list = bookDao.selectAll();
		for (Book book : list) {
			System.out.println(book);
		}
		
		// 도서 상세 조회
		System.out.println("-----------------도서 상세 조회-----------------");
		System.out.println(bookDao.select("111-222-8081"));
		
		// 도서 수정
		System.out.println("-----------------도서 수정-----------------");
		bookDao.update(new Book("111-222-8081", "조서영님", "조서영 일기 수정", 250000, "화이팅!!", "표지 경로"));
		
		// 도서 상세 조회
		System.out.println("-----------------도서 상세 조회-----------------");
		System.out.println(bookDao.select("111-222-8081"));
		
		// 도서 삭제
		System.out.println("-----------------도서 삭제-----------------");
		bookDao.delete("111-222-8081");
		
		// 도서 전체 조회
		System.out.println("-----------------도서 전체 조회-----------------");
		List<Book> list2 = bookDao.selectAll();
		for (Book book : list2) {
			System.out.println(book);
		}
		
		// 사용자 조회
		System.out.println(userDao.select("ssafy"));
	}
}

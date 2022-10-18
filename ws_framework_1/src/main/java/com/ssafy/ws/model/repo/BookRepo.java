package com.ssafy.ws.model.repo;

import java.util.List;

import com.ssafy.ws.model.Book;

public interface BookRepo {

	int insert(Book book);
	int update(Book book);
	int delete(String isbn);
	Book select(String isbn);
	List<Book> search();
	
}

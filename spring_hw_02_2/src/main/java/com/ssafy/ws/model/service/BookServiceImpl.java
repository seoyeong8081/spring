package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;

public class BookServiceImpl implements BookService {

	private BookRepo bookRepo;

	public BookServiceImpl() {
	}

	public BookRepo getBookRepo() {
		return bookRepo;
	}

	public void setBookRepo(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String isbn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book select(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> search() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.BookDto;
import com.ssafy.ws.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	private BookMapper bookMapper;

	@Autowired
	public BookServiceImpl(BookMapper bookMapper) {
		super();
		this.bookMapper = bookMapper;
	}

	@Override
	public List<BookDto> listBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerBook(BookDto bookDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public BookDto getBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyBook(BookDto bookDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(String isbn) {
		// TODO Auto-generated method stub

	}

}

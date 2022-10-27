package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.BookDto;

public interface BookService {

	List<BookDto> listBook();

	void registerBook(BookDto bookDto);

	BookDto getBook(String isbn);

	void modifyBook(BookDto bookDto);

	void deleteBook(String isbn);

}

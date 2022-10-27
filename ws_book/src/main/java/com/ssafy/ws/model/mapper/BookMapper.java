package com.ssafy.ws.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.BookDto;

@Mapper
public interface BookMapper {

	List<BookDto> listBook();

	void registerBook(BookDto bookDto);

	BookDto getBook(String isbn);

	void modifyBook(BookDto bookDto);

	void deleteBook(String isbn);
	
}

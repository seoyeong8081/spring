package com.ssafy.enjoytrip.board.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.board.model.BoardDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController{
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		logger.info("boardController 생성자 호출");
		this.boardService = boardService;
	}
	
	@GetMapping("/preview")
	public ResponseEntity<?> preview() { // ?는 모든 타입이 가능하다  ? extends Dto하면 Dto를 상속받는 타입만 가능
		logger.info("HERE");
		try {
			List<BoardDto> list = boardService.preview(3); // >> JSON array // map을 파라미터로 넣어서 페이징 처리할 것 
			logger.info("{}", list);
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK); // 헤더에서 제이슨 설정해줘야하는데 제이슨으로 넘어올거기 때문에 JSON으로 넣어감
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		} 
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

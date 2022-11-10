package com.ssafy.enjoytrip.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.notice.model.NoticeDto;
import com.ssafy.enjoytrip.notice.model.service.NoticeService;
import com.ssafy.enjoytrip.user.model.UserDto;
import com.ssafy.enjoytrip.util.ParameterCheck;
import com.ssafy.enjoytrip.util.SizeConstant;

@RestController
@RequestMapping("/notice")
public class NoticeController extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final long serialVersionUID = 1L;

	private final NoticeService noticeService;

	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}


}

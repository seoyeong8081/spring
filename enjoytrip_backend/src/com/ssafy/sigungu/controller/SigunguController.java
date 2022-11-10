package com.ssafy.sigungu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.sigungu.model.SigunguDto;
import com.ssafy.sigungu.model.service.SigunguService;
import com.ssafy.sigungu.model.service.SigunguServiceImpl;

@WebServlet("/sigungu")
public class SigunguController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SigunguService sigugnuService;
	
	@Override
	public void init() throws ServletException {
		sigugnuService = SigunguServiceImpl.getSigunguService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		if("list".equals(act)) {
			list(request, response);
		} else {
			redirect(request, response, "/index.jsp");
		}
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		int areaCode = Integer.parseInt(request.getParameter("areaCode"));
		try {
			List<SigunguDto> list = new ArrayList<SigunguDto>();
			list = sigugnuService.list(areaCode);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(list);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

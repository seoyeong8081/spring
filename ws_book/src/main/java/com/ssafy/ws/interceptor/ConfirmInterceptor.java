package com.ssafy.ws.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ws.model.UserDto;

public class ConfirmInterceptor implements HandlerInterceptor { 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UserDto memberDto = (UserDto) session.getAttribute("userinfo");
		if(memberDto == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		return true;
	}

}

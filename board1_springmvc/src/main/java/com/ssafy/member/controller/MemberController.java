package com.ssafy.member.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
//	//parameter로 넘기는 방법 : 파라미터의 이름과 변수명이 같을 경우 자동으로 얻어짐. 다를 경우 RequestParam을 써야함
//	@GetMapping("/user/idcheck")
//	public String idCheck(@RequestParam("userid") String userId) { // 이름 같으면 requestparam 안해도 됨
//		logger.info("userid : " + userId);
//		return "";
//	}
	
	@GetMapping("/idcheck/{userid}")
	public @ResponseBody String idCheck(@PathVariable("userid") String userId) throws Exception {
		// responsebody하면 리턴값을 응답값으로 인식시켜라
		logger.debug("userid : " + userId);
		int cnt = memberService.idCheck(userId);
		return cnt + "";
	}
	
	@PostMapping("/join")
	public String join(MemberDto memberDto, Model model) {
		logger.debug("memberDto : {}", memberDto);
		try {
			memberService.joinMember(memberDto);
			return "redirect:/user/login";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 가입 처리 중 에러 발생!!!");
			return "error/error";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
//	public String login(@RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd) {
//	public String login(MemberDto memberDto) {
//	public String login(Map<String, String> map) { // modelandview model map modelmap 에 model 담아서 view에 보낼 수 있음
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) { // parameter 담는 용도로 맵을 쓰겠다
//		logger.debug("input info {}, {}", userId, userPwd);
		logger.debug("input map info {}", map);
		try {
            MemberDto memberDto = memberService.loginMember(map);
            if(memberDto != null) { // 로그인 성공(id, pwd 일치!!!!)

                String saveid = map.get("saveid");
//                if("ok".equals(saveid)) { // 아이디 저장 체크 O.
//                    Cookie cookie = new Cookie("ssafy_id", map.get("userid"));
//                    cookie.setMaxAge(60*60*24*365*40);
//                    cookie.setPath(request.getContextPath());
//
//                    response.addCookie(cookie);
//                } else {
//                    Cookie[] cookies = request.getCookies();
//                    if(cookies != null) {
//                        for(Cookie cookie : cookies) {
//                            if(cookie.getName().equals("ssafy_id")) {
//                                cookie.setMaxAge(0);
//                                cookie.setPath(request.getContextPath());
//
//                                response.addCookie(cookie);
//                                break;
//                            }
//                        }
//                    }
//                }
                Cookie cookie = new Cookie("ssafy_id", map.get("userid"));
                cookie.setPath(request.getContextPath());
                if("ok".equals(saveid)) { // 아이디 저장 체크 O
                	cookie.setMaxAge(60*60*24*365*40);
                } else {
                	cookie.setMaxAge(0);
                }
                response.addCookie(cookie);

                session.setAttribute("userinfo", memberDto);
                return "redirect:/";
            } else { // 로그인 실패(id, pwd 불일치!!!!)
                model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인!!!");
                return "user/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "로그인 처리중 에러 발생!!!");
            return "error/error";
        }
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}

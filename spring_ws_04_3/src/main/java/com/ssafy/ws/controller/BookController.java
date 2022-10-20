package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.User;

@Controller
public class BookController {

	/**
	 * <pre> / 또는 /index 요청이 get 방식으로 들어왔을 때 index 로 연결한다.</pre>
	 * 
	 * @return
	 */
	@GetMapping({"/", "/index" })
	public String showRoot() {
		return "index";
	}
	
	// 코드작성
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session, Model model) {
		String id = map.get("userid");
		String password = map.get("userpass");
		
		if ("ssafy".equals(id) && "1234".equals(password)) {
			User user = new User(id, "김싸피", password);
			session.setAttribute("loginUser", user);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인 실패");
			return "index";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("111-222-3333", "홍길동", "책제목1", 10000, "좋은 책 1", "abc1.png"));
		books.add(new Book("111-222-3333", "임꺽정", "책제목2", 20000, "좋은 책 2", "abc2.png"));
		books.add(new Book("111-222-3333", "장길산", "책제목3", 30000, "좋은 책 3", "abc3.png"));
		model.addAttribute("books", books);
		return "list";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(Book book, Model model) {
		model.addAttribute("book", book);
		return "regist_result";
	}
}

package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	private BoardService boardService;
	
//	@Autowired // 생성자가 하나일 경우 생략 가능
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(BoardDto boardDto, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write parameter boardDto : {}", boardDto);
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		boardDto.setUserId(memberDto.getUserId());
		boardService.writeArticle(boardDto);
		redirectAttributes.addAttribute("pgno", 1);
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam Map<String, String> param, Model model, RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("list parameter : {}", param);
		List<BoardDto> list = boardService.listArticle(param);
		model.addAttribute("articles", list);
		redirectAttributes.addAttribute("pgno", param.get("pgno"));
		redirectAttributes.addAttribute("key", param.get("key"));
		redirectAttributes.addAttribute("word", param.get("word"));
//		redirectAttributes.addFlashAttribute("word", param.get("word")); // 이렇게 하면 파라미터는 넘어가지만 주소에 안보임
		return "board/list";
	}
	
	@GetMapping("/view") 
	public String view(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> param, Model model, RedirectAttributes redirectAttributes) throws Exception {
		BoardDto boardDto = boardService.getArticle(articleNo);
		boardService.updateHit(articleNo);
		model.addAttribute("article", boardDto);
		redirectAttributes.addAttribute("pgno", param.get("pgno"));
		redirectAttributes.addAttribute("key", param.get("key"));
		redirectAttributes.addAttribute("word", param.get("word"));
		return "board/view";
	}
	
	@GetMapping("/modify") 
	public String modify(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> param, Model model, RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("modify parameter : {}", param);
		BoardDto boardDto = boardService.getArticle(articleNo);
		model.addAttribute("article", boardDto);
		redirectAttributes.addAttribute("pgno", param.get("pgno"));
		redirectAttributes.addAttribute("key", param.get("key"));
		redirectAttributes.addAttribute("word", param.get("word"));
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(BoardDto boardDto, RedirectAttributes redirectAttributes,  @RequestParam Map<String, String> param) throws Exception {
		logger.debug("write parameter boardDto : {}", boardDto);
		boardService.modifyArticle(boardDto);
		redirectAttributes.addAttribute("pgno", param.get("pgno"));
		redirectAttributes.addAttribute("key", param.get("key"));
		redirectAttributes.addAttribute("word", param.get("word"));
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete") 
	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> param, RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("delete parameter : {}", param);
		boardService.deleteArticle(articleNo);
		redirectAttributes.addAttribute("pgno", param.get("pgno"));
		redirectAttributes.addAttribute("key", param.get("key"));
		redirectAttributes.addAttribute("word", param.get("word"));
		return "redirect:/board/list";
	}
}

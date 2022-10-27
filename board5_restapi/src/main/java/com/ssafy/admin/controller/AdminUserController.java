package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController // return을 @responsebody로 인식하여 보내줌
@RequestMapping("/admin")
public class AdminUserController {

	private MemberService memberService;

	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userList() { // ?는 모든 타입이 가능하다  ? extends Dto하면 Dto를 상속받는 타입만 가능
		try {
			List<MemberDto> list = memberService.listMember(null); // >> JSON array // map을 파라미터로 넣어서 페이징 처리할 것 
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 헤더에서 제이슨 설정해줘야하는데 제이슨으로 넘어올거기 때문에 JSON으로 넣어감
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		} 
	}	
	
	@PostMapping("/user")
	public ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto) { 
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null); // >> JSON array // map을 파라미터로 넣어서 페이징 처리할 것 
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 헤더에서 제이슨 설정해줘야하는데 제이슨으로 넘어올거기 때문에 JSON으로 넣어감
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		} 
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) { 
		try {
			memberService.modifyMember(memberDto);
			List<MemberDto> list = memberService.listMember(null); // >> JSON array // map을 파라미터로 넣어서 페이징 처리할 것 
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 헤더에서 제이슨 설정해줘야하는데 제이슨으로 넘어올거기 때문에 JSON으로 넣어감
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		} 
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userView(@PathVariable("userid") String userId) { // ?는 모든 타입이 가능하다  ? extends Dto하면 Dto를 상속받는 타입만 가능
		try {
			MemberDto memberDto = memberService.getMember(userId);
			if (memberDto != null) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK); // JSON만 리턴해줌 list의 경우 JSON Array로
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		} 
	}
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) { // ?는 모든 타입이 가능하다  ? extends Dto하면 Dto를 상속받는 타입만 가능
		try {
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null); // >> JSON array // map을 파라미터로 넣어서 페이징 처리할 것 
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 헤더에서 제이슨 설정해줘야하는데 제이슨으로 넘어올거기 때문에 JSON으로 넣어감
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

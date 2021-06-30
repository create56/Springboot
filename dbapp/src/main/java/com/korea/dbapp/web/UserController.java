package com.korea.dbapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;
import com.korea.dbapp.util.Script;

// 회원가입 페이지에 사용하는 함수
// 회원가입 페이지로 가는 함수 생성
@Controller
public class UserController {
	private final UserRepository userRepository;
	private final HttpSession session;
	
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		this.session = session;
	}


	// @RestController (X) 데이터 리턴하지 않는다.
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "auth/joinForm";
	}
	
	
	@GetMapping("/auth/loginForm")
	public String loginForm( ) {
		return "auth/loginForm";
	}
	
	//메인
	//로그인 화면으로 가는 리턴값
	// 다른 서버에 있으면 http://localhost:8000를 풀로 다 적어주어야한다.
	@PostMapping("/auth/join")
	public String join(User user) {
		userRepository.save(user);
		return "redirect:/auth/loginForm";
	}
	
	@PostMapping("/auth/login")
	public @ResponseBody String login(User user) {
		User userEntity = userRepository.mLogin(user.getUsername(), user.getPassword());
		if(userEntity == null) {
		
			return Script.back("로그인 실패");
		} else {
			session.setAttribute("principal", userEntity); // principal=> 가지고 있는 주체
			return Script.href("/");
		}
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		session.invalidate();
		return"redirect:/";
	}
	
}

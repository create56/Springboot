package com.korea.dbapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;

// 회원가입 페이지에 사용하는 함수
// 회원가입 페이지로 가는 함수 생성
@Controller
public class UserController {
	private final UserRepository userRepository;
	
	// 의존성 주입(DI)
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
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
}

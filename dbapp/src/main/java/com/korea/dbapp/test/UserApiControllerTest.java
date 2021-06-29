package com.korea.dbapp.test;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;

@RestController
public class UserApiControllerTest {
	
	private final UserRepository userRepository;
	
	// 의존성 주입(DI)
	public UserApiControllerTest(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// insert -> save로 표현
	@PostMapping("/test/user")
	public String save(User user) {
		userRepository.save(user);
		return"save ok";
	}
	
	@GetMapping("/test/user")
	public List<User>findAll() {
		return userRepository.findAll();
	}
	
	// 데이터 베이스에 저장된 데이터들을 1,2,3으로 찾는방법
	// http:localhost:8000/user/2
	// {id} 2가 저장
	@GetMapping("/test/user/{id}")
	public User findById(@PathVariable int id) {
		// 매핑 클래스 
		// optional
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/test/user/username/{username}")
	public User findByUsername(@PathVariable String username) {
		return userRepository.mFindByUsername(username);
	}
	
//	@PostMapping("/test/login")
//	public String login(String username, String password) {
//		User user = userRepository.mLogin(username,password);
//		if(user == null) {
//			return "login fail";
//		} else  {
//			return "login success"; 
//		}
//	}
	
 @PostMapping("/test/login")
	public String login(@RequestBody User user) {
		User userEntity = userRepository.mLogin(user.getUsername(),user.getPassword());
		if (userEntity == null) {
			return "login fail";
		} else {
			return "login success";
		}
	}
	// WHERE => {id}
    // 찾을 데이터 => @PathVariable
	@DeleteMapping("/test/user/{id}")
	public String deleteById(@PathVariable int id) {
		userRepository.deleteById(id);
		return"delete ok";
	}
	
	// Update
	// id가 들어오면 save는 insert가 아니라 id를 수정함
	@PutMapping("/test/user/{id}")
	public String updateOne(@PathVariable int id, User user) { //  password, email
		// 1. id로 select 하기 
		User userEntity = userRepository.findById(id).get();
		// 2. 받은  body데이터로 수정하기
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		//3. save하면된다 . (이떄 꼭 id값이 db에 존재해야 update가 된다.)
//		user.setId(id); // username => null이므로
		userRepository.save(user); // 지금 save에 있는  user => null값이므로 데이터가 사라진다.
		return "update ok";
	}	
 }

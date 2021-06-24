package com.cos.secondapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 컴포넌트 스캔시 @RestController, @Controller를 loC에 등록한다.
// 디스패쳐는 위 두개를 관리한다
// 차이점은  @RestController는 데이터를 응답, @Controller는 View를 응답
@Controller
public class ViewController {
	// http://localhost:8000/
	@GetMapping("/home")
	public String home() {
		System.out.println("나 호출됬니??");
		return "home"; // ViewResolver 가 발동 => src/main/webapp/WEB-INF/views/home.jsp이렇게 찾아야한다.(부스 안에서 a라는 폴더에 넣었다면 "a/home")
	}
}

package com.korea.newapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home() {
		return"home";
	}
	
	@GetMapping("/post")
	public String post() {
		return"post";
	}
}

package com.pen.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mak")
public class MakController {
	@GetMapping("/plan")
	public void plan() {
		
	}
	
	@GetMapping("/test")
	void test() {
		
	}
	
}
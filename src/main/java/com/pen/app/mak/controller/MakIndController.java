package com.pen.app.mak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mak/ind")
public class MakIndController {
	@GetMapping("/plan")
	public void plan() {
	}
	
}

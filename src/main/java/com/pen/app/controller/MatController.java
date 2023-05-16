package com.pen.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mat")
public class MatController {

	@GetMapping("/order")
	public void matregister() {
		//MatService.orderregister(order);
		
		
	}
	
	
}

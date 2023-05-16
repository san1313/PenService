package com.pen.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.OrderVO;


@Controller
public class MatController {

	@RequestMapping(value="orderregister")
	public String matregister(OrderVO order) {
		
		
		return "order";
	}
	
	
}

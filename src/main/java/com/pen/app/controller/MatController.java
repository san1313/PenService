package com.pen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.vo.OrderVO;


@Controller
@RequestMapping("/mat")
public class MatController {

@Autowired MatMapper matmapper;
	
	@GetMapping("/order")
	public void ordermain() {
		
		
	}
	
	@ResponseBody
	@GetMapping("/orderListAjax")
	public List<OrderVO> orderListAjax(){
		List<OrderVO> list = matmapper.getorderlist();
		
		return list;
	}
	
}

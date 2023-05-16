package com.pen.app.controller;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.vo.BnsOrdVO;
	
	
@Controller
@RequestMapping("/bns")
public class BnsController {
	
@Autowired BnsMapper dao;
	
	@GetMapping("/ordList")
	public String empList(Model model) {
		model.addAttribute("ordList", dao.getOrdList());
		return "bns/ordList";
	}
	
	@ResponseBody
	@GetMapping("/ordListAjax")
	public List<BnsOrdVO> ordListAjax(){
		List<BnsOrdVO> list = dao.getOrdList();
		System.out.println(list);
		return list;
	}
}
	
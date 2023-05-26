package com.pen.app.mak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.PlanVO;

@Controller
@RequestMapping("/ind")
public class MakIndController {
	
	@Autowired
	MakIndService service;
	
	@GetMapping("/indica")
	public void plan() {
	}
	
	@GetMapping("/planning")
	@ResponseBody
	List<PlanVO> planning(){
		List<PlanVO> list = service.planning();
		return list;
	}
	
}

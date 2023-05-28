package com.pen.app.mak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

@Controller
@RequestMapping("/ind")
public class MakIndController {
	
	@Autowired
	MakIndService service;
	
	@GetMapping("/indica")
	public void plan() {
	}
	@GetMapping("/dirindica")
	public void dirplan() {
	}
	
	@GetMapping("/planning")
	@ResponseBody
	List<PlanVO> planning(){
		List<PlanVO> list = service.planning();
		return list;
	}
	
	
	@GetMapping("/indList")
	@ResponseBody
	List<MakVO> indList(){
		List<MakVO> list = service.indList();
		return list;
	}
	
	@RequestMapping("/planFlow")
	@ResponseBody
	List<MakVO> planFlow(@RequestParam String prodCode){
		System.out.println("공정조회"+prodCode);
		return service.planFlow(prodCode);
	}
	
	@GetMapping("/matList")
	@ResponseBody
	List<IndicaVO> matList(){
		return service.getMatList();
	}
	
}

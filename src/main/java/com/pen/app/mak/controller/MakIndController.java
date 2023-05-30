package com.pen.app.mak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaListVO;
import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

/*
 * 최준호 - 생산지시서 컨트롤러 
 */

@Controller
@RequestMapping("/ind")
public class MakIndController {
	
	@Autowired
	MakIndService service;
	
	//생산지시서 페이지
	@GetMapping("/indica")
	public void plan() {
	}
	//생산지시서(직접지시) 페이지
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
	
	@RequestMapping("/operateCheck")
	@ResponseBody
	List<MakVO> matList(@RequestBody IndicaListVO list){
		return service.getOperateCheck(list);
	}
	
	@RequestMapping("/getFlowList")
	@ResponseBody
	List<MakVO> getFlowList(@RequestBody IndicaListVO list){
		System.out.println("넘겨받은 값 : "+list);
		return service.getFlowList(list);
	}
	
	@RequestMapping("/insertIndica")
	@ResponseBody
	String insertIndica(@RequestBody IndicaListVO list) {
		System.out.println("등록 받아온 값 : "+list);
		String result = service.insertIndica(list);
			
		return result;
	}
	
	
	
}

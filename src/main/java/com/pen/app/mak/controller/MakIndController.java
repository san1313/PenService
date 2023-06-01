package com.pen.app.mak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaListVO;
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
	
	@RequestMapping(value = "/planFlow", method= {RequestMethod.GET, RequestMethod.POST})
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
	
	@RequestMapping(value = "/insertIndica", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String insertIndica(@RequestBody IndicaListVO list) {
		System.out.println("등록 받아온 값 : "+list);
		String result = service.insertIndica(list);
			
		return result;
	}
	
	@RequestMapping(value = "/getIndicatedBom", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	List<MakVO> getIndicatedBom(@RequestParam String indicaCode) {
		System.out.println("그리드 받아오는 값 : "+indicaCode);
		return service.getIndicatedBom(indicaCode);
	}
	
	@RequestMapping(value = "/updateIndica", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String updateIndica(@RequestBody IndicaListVO list) {
		System.out.println("등록 받아온 값 : "+list);
		String result = service.updateIndica(list);
			
		return result;
	}
	
	@RequestMapping(value = "/delIndica", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String delIndica(@RequestBody IndicaListVO list) {
		System.out.println("삭제 받아온 값 : "+list);
		String result = service.delIndica(list);
			
		return result;
	}
	
	@GetMapping("/dirIndList")
	@ResponseBody
	List<MakVO> dirIndList(){
		List<MakVO> list = service.dirIndList();
		return list;
	}
	
	
}

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

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaListVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

/*
 * 최준호 - 생산지시서 컨트롤러 + 공정실적 컨트롤러
 */

@Controller
@RequestMapping("/ind")
public class MakIndController {
	@Autowired
	MakIndMapper mapper;
	
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
		return service.getFlowList(list);
	}
	
	@RequestMapping(value = "/insertIndica", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String insertIndica(@RequestBody IndicaListVO list) {
		String result = service.insertIndica(list);
			
		return result;
	}
	
	@RequestMapping(value = "/getIndicatedBom", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	List<MakVO> getIndicatedBom(@RequestParam String indicaCode) {
		return service.getIndicatedBom(indicaCode);
	}
	
	@RequestMapping(value = "/updateIndica", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String updateIndica(@RequestBody IndicaListVO list) {
		String result = service.updateIndica(list);
			
		return result;
	}
	
	@RequestMapping(value = "/delIndica", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String delIndica(@RequestBody IndicaListVO list) {
		String result = service.delIndica(list);
			
		return result;
	}
	
	@GetMapping("/dirIndList")
	@ResponseBody
	List<MakVO> dirIndList(){
		List<MakVO> list = service.dirIndList();
		return list;
	}
	
	@GetMapping("/product")
	@ResponseBody
	List<MakVO> product(){
		List<MakVO> list = mapper.product();
		return list;
	}
	
	@GetMapping("/modalProd")
	@ResponseBody
	List<MakVO> modalProd(@RequestParam String prodName){
		return mapper.modalProd(prodName);
	}

	//공정실적조회 페이지로 이동
	@GetMapping("/performance")
	void performance() {
		
	}
	//공정실적관리 페이지로 이동
	@GetMapping("/performanceManage")
	void performanceManage() {
		
	}
	
	@GetMapping("/perfIndList")
	@ResponseBody
	List<MakVO> perfIndList(){
		return mapper.perfIndList();
	}
	
	@GetMapping("/resultIndList")
	@ResponseBody
	List<MakVO> resultIndList(){
		return mapper.resultIndList();
	}
	
	@RequestMapping("/oerfProcList")
	@ResponseBody
	List<MakVO> oerfProcList(@RequestParam String indicaCode){
		return service.oerfProcList(indicaCode);
	}
	
	@RequestMapping("/delProcProd")
	@ResponseBody
	int delProcProd(@RequestParam String prcsCode){
		return mapper.delProcProd(prcsCode);
	}
	
	@GetMapping("/userList")
	@ResponseBody
	List<MakVO> userList(){
	return mapper.userList();
	}
	
	@RequestMapping("/getProcList")
	@ResponseBody
	List<MakVO> getProcList(@RequestBody MakVO vo){
		
		return service.getProcList(vo);
	}
	
	@RequestMapping("/insertProcProd")
	@ResponseBody
	List<MakVO> insertProcProd(@RequestBody MakVO vo){
		
		return service.insertProcProd(vo);
	}
	
	@RequestMapping(value = "/updateProcProd", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	String updateProcProd(@RequestBody IndicaListVO list) {
		String result = service.updateProcProd(list);
			
		return result;
	}
	
	@RequestMapping(value = "/getProcProdInfo", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	List<MakVO> getProcProdInfo(@RequestBody MakVO vo) {
		return service.getProcProdInfo(vo);
	}
	
}

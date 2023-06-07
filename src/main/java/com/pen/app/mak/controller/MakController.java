package com.pen.app.mak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
import com.pen.app.mak.vo.PlanListVO;
import com.pen.app.mak.vo.PlanVO;

/*최준호 - 생산계획서 컨트롤러*/

@Controller
@RequestMapping("/mak")
public class MakController {
	
	@Autowired MakMapper mapper;
	@Autowired MakService service;
	
//계획서 페이지
	@GetMapping("/plan")
	public void plan() {
	}
	
	/* 계약서 기반 계획서 시작 */
	
	/* 기본 그리드 */
	@GetMapping("/planList")
	@ResponseBody
	ToastUiResponseDTO planList(){
		List<PlanVO> list = service.getPlanList();
		return new ToastUiResponseDTO(list);
	}
	
	@GetMapping("/planning")
	@ResponseBody
	List<PlanVO> planning(){
		int contCount=0;
		List<PlanVO> result = new ArrayList<>();
		List<PlanVO> list = mapper.getCont();
		ArrayList<String> detCoList = new ArrayList<>();
		ArrayList<String> detCo = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			String detC = list.get(i).getContDetCode();
			List<PlanVO> CDC = mapper.getConnect(detC);
			if(CDC.isEmpty()) {
			}else {
				//이중 포문
				for(int j=0; j<CDC.size();j++) {
					//계약상세코드 떼기
					if(!detCo.contains(CDC.get(j).getContDetCode())){
						detCo.add(CDC.get(j).getContDetCode());
					};
				};
					//포문 이중포문
					for(int k=0;k<detCo.size();k++) {
						contCount += mapper.getContCount(detCo.get(k));
						//특정코드
					List<PlanVO> plan = mapper.getPlanning(detCo.get(k));
					if(plan.isEmpty()) {
						if(!detCoList.contains(detCo.get(k))) {
							detCoList.add(detCo.get(k));	
						};
						}else {
							if(!detCoList.contains(detCo.get(k))) {
								result.addAll(plan);
								detCoList.add(detCo.get(k));
							};
						};
				}
			}
		}
		if(detCoList.isEmpty()) {
			
		}else {
		List<PlanVO> result1 = service.getContr(detCoList);
		
		result.addAll(result1);
		};
			if(contCount>0&&result.isEmpty()) {
				
			}else if(contCount==0&&result.isEmpty()) {
				result=list;
			}
		return result;
	}
	
	
	@RequestMapping("/insertPlan")
	@ResponseBody
	String insertPlan(@RequestBody PlanListVO vo) {

		String result = "";
		
		if(service.insertPlan(vo)>0) {
			result="등록성공";
		}else {
			result="등록실패";
		}
		return result;
	}
	
	@RequestMapping("/delPlan")
	@ResponseBody
	String delPlan(@RequestBody PlanVO vo) {
	
	String result = service.delPlan(vo);
	
	return result;
	}
	
	
	@RequestMapping("/updatePlan")
	@ResponseBody
	String updatePlan(@RequestBody PlanVO vo) {
	String result ="";
	if(service.modPlan(vo)>0) {
		result="수정성공";
	}else{
		result ="수정실패";
	};
	return result;
	}
	
	@RequestMapping("/selectPlan")
	@ResponseBody
	List<PlanVO> selectPlan(@RequestBody PlanVO vo){
		List<PlanVO> list = service.selectPlan(vo); 
		return list;
	}
	

	
	/* 주문서 기반 계획서 시작*/
	@GetMapping("/ordList")
	@ResponseBody
	ToastUiResponseDTO ordList(){
		List<PlanVO> list = service.getOrdList();
		return new ToastUiResponseDTO(list);
	};
	
	
	@GetMapping("/ordering")
	@ResponseBody
	List<PlanVO> ordering(){
		int ordCount=0;
		List<PlanVO> result = new ArrayList<>();
		List<PlanVO> list = mapper.getOrd();
		ArrayList<String> detCoList = new ArrayList<>();
		ArrayList<String> detCo = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			String detC = list.get(i).getOrdDetCode();
			List<PlanVO> CDC = mapper.getConnection(detC);
			
			if(CDC.isEmpty()) {
			}else {
				//이중 포문
				for(int j=0; j<CDC.size();j++) {
					//계약상세코드 떼기
					if(!detCo.contains(CDC.get(j).getOrdDetCode())){
						detCo.add(CDC.get(j).getOrdDetCode());
					};
				};
					//포문 이중포문
					for(int k=0;k<detCo.size();k++) {
						ordCount += mapper.getOrdCount(detCo.get(k));
						//특정코드
					List<PlanVO> plan = mapper.getOrdering(detCo.get(k));
					if(plan.isEmpty()) {
						if(!detCoList.contains(detCo.get(k))) {
							detCoList.add(detCo.get(k));	
						};
						}else {
							if(!detCoList.contains(detCo.get(k))) {
								result.addAll(plan);
								detCoList.add(detCo.get(k));
							};
						};
					
				}
			}
		}
		
		if(detCoList.isEmpty()) {
			
		}else {
		List<PlanVO> result1 = service.getOrder(detCoList);
		
		result.addAll(result1);
		};
			if(ordCount>0&&result.isEmpty()) {
				
			}else if(ordCount==0&&result.isEmpty()) {
				result=list;
			}
		return result;
	};
	
	
	@RequestMapping("/insertOrd")
	@ResponseBody
	String insertOrd(@RequestBody PlanListVO vo) {
		String result = "";
		
		if(service.insertOrd(vo)>0) {
			result="등록성공";
		}else {
			result="등록실패";
		}
		return result;
	}
	
	@RequestMapping("/delOrd")
	@ResponseBody
	String delOrd(@RequestBody PlanVO vo) {
	
	String result = service.delOrd(vo);
	
	return result;
	}
	
	
	@RequestMapping("/selectOrd")
	@ResponseBody
	List<PlanVO> selectOrd(@RequestBody PlanVO vo){
		List<PlanVO> list = service.selectOrd(vo); 
		return list;
	}
	

	@RequestMapping("/selectOrdList")
	@ResponseBody
	List<PlanVO> selectOrdList(@RequestBody PlanVO vo){
		int ordCount=0;
		List<PlanVO> result = new ArrayList<>();
		List<PlanVO> list = mapper.getModalOrd(vo);//검색 받은 값
		ArrayList<String> detCoList = new ArrayList<>();
		ArrayList<String> detCo = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			String detC = list.get(i).getOrdDetCode();
			List<PlanVO> CDC = mapper.getConnection(detC);
			if(CDC.isEmpty()) {
			}else {
				//이중 포문
				for(int j=0; j<CDC.size();j++) {
					//계약상세코드 떼기
					if(!detCo.contains(CDC.get(j).getOrdDetCode())){
						detCo.add(CDC.get(j).getOrdDetCode());
					};
					
				};
					//포문 이중포문
					for(int k=0;k<detCo.size();k++) {
						ordCount += mapper.getOrdCount(detCo.get(k));
						//특정코드
					List<PlanVO> plan = mapper.getOrdering(detCo.get(k));
					if(plan.isEmpty()) {
						if(!detCoList.contains(detCo.get(k))) {
							detCoList.add(detCo.get(k));	
						};
						}else {
							if(!detCoList.contains(detCo.get(k))) {
								result.addAll(plan);
								detCoList.add(detCo.get(k));
							};
						};
				}
			}
		}
		if(detCoList.isEmpty()) {
			
		}else {
		List<PlanVO> result1 = mapper.getModalOrder(detCoList,vo);
		result.addAll(result1);
		};
			if(ordCount>0&&result.isEmpty()) {
			}else if(ordCount==0&&result.isEmpty()) {
				result=list;
			}
		return result;
	}
	
	
	
}
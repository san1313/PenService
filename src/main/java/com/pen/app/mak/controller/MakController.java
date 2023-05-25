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
		System.out.println("조회내용 : "+list);
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
			System.out.println("포문 : "+list.get(i));
			String detC = list.get(i).getContDetCode();
			System.out.println("음"+detC);
			List<PlanVO> CDC = mapper.getConnect(detC);
			System.out.println("확인 "+i+"번 : "+CDC);
			
			if(CDC.isEmpty()) {
				System.out.println("조건값 없음");
			}else {
				//이중 포문
				for(int j=0; j<CDC.size();j++) {
					//계약상세코드 떼기
					if(!detCo.contains(CDC.get(j).getContDetCode())){
						detCo.add(CDC.get(j).getContDetCode());
						System.out.println("CDC 포문 : "+j+"번 : "+CDC.get(j));
					};
					
					System.out.println(j+"번 체크"+detCo);
					System.out.println("detCoList 포문 :" + detCoList);
				};
					//포문 이중포문
					for(int k=0;k<detCo.size();k++) {
						System.out.println(k+"번 조건값 확인 : "+detCo.get(k));
						contCount += mapper.getContCount(detCo.get(k));
						//특정코드
					List<PlanVO> plan = mapper.getPlanning(detCo.get(k));
					if(plan.isEmpty()) {
						System.out.println("결과값 없음");
						if(!detCoList.contains(detCo.get(k))) {
							detCoList.add(detCo.get(k));	
						};
						}else {
							System.out.println("결과 : "+plan);
							if(!detCoList.contains(detCo.get(k))) {
								result.addAll(plan);
								detCoList.add(detCo.get(k));
							};
						System.out.println("결과를 담은 곳 : "+result);
						};
					
				}
			}
		}
		
		if(detCoList.isEmpty()) {
			
		}else {
		System.out.println("detCoList 출력 : "+detCoList);
		List<PlanVO> result1 = service.getContr(detCoList);
		
				System.out.println("조회되는 최종값 : "+result1);
		
		result.addAll(result1);
		};
			System.out.println("최종 결과값 : "+result);
			if(contCount>0&&result.isEmpty()) {
				
			}else if(contCount==0&&result.isEmpty()) {
				result=list;
			}
		return result;
	}
	
	
	@RequestMapping("/insertPlan")
	@ResponseBody
	String insertPlan(@RequestBody PlanListVO vo) {
		System.out.println("받아오는 입력값 : "+vo);
		System.out.println("계획서 입력값: "+vo.getPlanList().get(0));
		for(int i=0; i<vo.getPlanList().size();i++) {
		System.out.println("연결테이블및 상세 입력값 : "+vo.getPlanList().get(i));
		};
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
	
	System.out.println("삭제 받아오는 데이터 : "+vo);
	String result = service.delPlan(vo);
	System.out.println("결과 문자 : "+result);
	
	return result;
	}
	
	
	@RequestMapping("/updatePlan")
	@ResponseBody
	String updatePlan(@RequestBody PlanVO vo) {
	String result ="";
	System.out.println("수정 받아오는 데이터 : "+vo);
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
		System.out.println("조회 조건 : "+vo);
		List<PlanVO> list = service.selectPlan(vo); 
		return list;
	}
	

	
	/* 주문서 기반 계획서 시작*/
	@GetMapping("/ordList")
	@ResponseBody
	ToastUiResponseDTO ordList(){
		List<PlanVO> list = service.getOrdList();
		System.out.println("조회내용 : "+list);
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
			System.out.println("포문 : "+list.get(i));
			String detC = list.get(i).getOrdDetCode();
			System.out.println("음"+detC);
			List<PlanVO> CDC = mapper.getConnection(detC);
			System.out.println("확인 "+i+"번 : "+CDC);
			
			if(CDC.isEmpty()) {
				System.out.println("조건값 없음");
			}else {
				//이중 포문
				for(int j=0; j<CDC.size();j++) {
					//계약상세코드 떼기
					if(!detCo.contains(CDC.get(j).getOrdDetCode())){
						detCo.add(CDC.get(j).getOrdDetCode());
						System.out.println("CDC 포문 : "+j+"번 : "+CDC.get(j));
					};
					
					System.out.println(j+"번 체크"+detCo);
					System.out.println("detCoList 포문 :" + detCoList);
				};
					//포문 이중포문
					for(int k=0;k<detCo.size();k++) {
						System.out.println(k+"번 조건값 확인 : "+detCo.get(k));
						ordCount += mapper.getOrdCount(detCo.get(k));
						//특정코드
					List<PlanVO> plan = mapper.getOrdering(detCo.get(k));
					if(plan.isEmpty()) {
						System.out.println("결과값 없음");
						if(!detCoList.contains(detCo.get(k))) {
							detCoList.add(detCo.get(k));	
						};
						}else {
							System.out.println("결과 : "+plan);
							if(!detCoList.contains(detCo.get(k))) {
								result.addAll(plan);
								detCoList.add(detCo.get(k));
							};
						System.out.println("결과를 담은 곳 : "+result);
						};
					
				}
			}
		}
		
		if(detCoList.isEmpty()) {
			
		}else {
		System.out.println("detCoList 출력 : "+detCoList);
		List<PlanVO> result1 = service.getOrder(detCoList);
		
				System.out.println("조회되는 최종값 : "+result1);
		
		result.addAll(result1);
		};
			System.out.println("최종 결과값 : "+result);
			if(ordCount>0&&result.isEmpty()) {
				
			}else if(ordCount==0&&result.isEmpty()) {
				result=list;
			}
		return result;
	};
	
	
	@RequestMapping("/insertOrd")
	@ResponseBody
	String insertOrd(@RequestBody PlanListVO vo) {
		System.out.println("받아오는 입력값 : "+vo);
		System.out.println("계획서 입력값: "+vo.getPlanList().get(0));
		for(int i=0; i<vo.getPlanList().size();i++) {
		System.out.println("연결테이블및 상세 입력값 : "+vo.getPlanList().get(i));
		};
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
	
	System.out.println("삭제 받아오는 데이터 : "+vo);
	String result = service.delOrd(vo);
	System.out.println("결과 문자 : "+result);
	
	return result;
	}
	
	
	@RequestMapping("/selectOrd")
	@ResponseBody
	List<PlanVO> selectOrd(@RequestBody PlanVO vo){
		System.out.println("조회 조건 : "+vo);
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
				System.out.println("조건값 없음");
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
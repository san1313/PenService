package com.pen.app.mak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
import com.pen.app.mak.vo.PlanListVO;
import com.pen.app.mak.vo.PlanVO;

@Controller
@RequestMapping("/mak")
public class MakController {
	
	@Autowired MakMapper mapper;
	@Autowired MakService service;
	@GetMapping("/plan")
	public void plan() {
		
	}
	
	@GetMapping("/test")
	void test() {
		
	}

	@GetMapping("/planList")
	@ResponseBody
	List<PlanVO> planList(){
		List<PlanVO> list = mapper.getPlanList();
		
		return list;
	}
	
	@GetMapping("/planning")
	@ResponseBody
	List<PlanVO> planning(){
		List<PlanVO> result = new ArrayList<>();
		List<PlanVO> list = mapper.getCont();
		ArrayList<String> detCoList = new ArrayList<>();

		for(int i = 0; i<list.size();i++) {
			System.out.println("포문 : "+list);
			String detC = list.get(i).getContDetCode();
			System.out.println("음"+detC);
			List<PlanVO> CDC = mapper.getConnect(detC);
			System.out.println("확인 "+i+"번 : "+CDC);
			
			if(CDC.isEmpty()) {
				System.out.println("조건값 없음");
			}else {
				for(int j=0; j<CDC.size();j++) {
					ArrayList<String> detCo = new ArrayList<>();
					detCo.add(CDC.get(j).getContDetCode());
					System.out.println("CDC 포문 : "+j+"번 : "+CDC.get(j));
					
					
					System.out.println("체크"+detCo);
					System.out.println("detCoList 포문 :" + detCoList);
					for(int k=0;k<detCo.size();k++) {
						System.out.println("조건값 확인 : "+detCo.get(k));
					List<PlanVO> plan = mapper.getPlanning(detCo.get(k));
					if(plan.isEmpty()) {
						System.out.println("결과값 없음");
//						detCoList = new ArrayList<>();
						detCoList.add(detCo.get(k));
						
						}else {
							System.out.println("결과 : "+plan);
						result.addAll(plan);
						detCoList.add(detCo.get(k));
						System.out.println("결과를 담은 곳 : "+result);
						};
					}
					
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
	
	
	
}
package com.pen.app.mak.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
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
		List<PlanVO> result = null;
		List<PlanVO> list = mapper.getCont();
		ArrayList<String> detCoList = new ArrayList<>();

		for(int i = 0; i<list.size();i++) {
			System.out.println("포문 : "+list);
			String detC = list.get(i).getContDetCode();
			System.out.println("음"+detC);
			List<PlanVO> CDC = mapper.getConnect(detC);
			System.out.println("확인"+CDC);
			
			if(CDC!=null) {
				for(int j=0; j<CDC.size();j++) {
					String detCo = CDC.get(i).getContDetCode();
					detCoList.add(detCo);
					System.out.println("CDC 포문 : "+i+"번 : "+CDC.get(i));
					
					
					System.out.println("체크"+detCo);
					System.out.println("detCoList 포문 :" + detCoList);
					List<PlanVO> plan = mapper.getPlanning(detCo);
					System.out.println("결과"+plan);
					result = plan;
				}
			}

		}
		System.out.println("detCoList 출력 : "+detCoList);
		List<PlanVO> result1 = service.getContr(detCoList);
				System.out.println("조회되는 최종값 : "+result1);
		
		result.addAll(result1);
			System.out.println("최종 결과값 : "+result);
		return result;
	}
	
	
	
}
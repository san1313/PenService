package com.pen.app.mat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.vo.MatOrdVO;
import com.pen.app.mat.vo.OrderVO;


@Controller
@RequestMapping("/mat")
public class MatController {

@Autowired MatMapper matmapper;
	
	@GetMapping("/order")
	public void ordermain() {
		
	}
	 
	
	//자재모달창리스트
	@ResponseBody
	@GetMapping("/matlist")
	public List<OrderVO> matlist(){
		List<OrderVO> list = matmapper.getmatlist();
		System.out.println(list);
		return list;
	}
	
	//자재모달조회
	@RequestMapping("/matminilist")
	@ResponseBody
	public List<OrderVO> matminilist(@RequestParam String result){
		List<OrderVO> list = matmapper.getmatminilist(result);
		return list;
	}
	
	//거래처모달창리스트
	@ResponseBody
	@GetMapping("/acclist")
	public List<OrderVO> acclist(){
		List<OrderVO> list = matmapper.getacclist();
		return list;
	}
	
	//자재모달조회
	@RequestMapping("/accminilist")
	@ResponseBody
	public List<OrderVO> accminilist(@RequestParam String result){
		System.out.println(result);
		List<OrderVO> list = matmapper.getaccminilist(result);
		return list;
	}
	
	//발주번호
	@ResponseBody
	@GetMapping("/matordercode")
	public String matordercode(){
		String result = matmapper.getmatordercode();
		return result;
	}
	
	//발주등록
	 @RequestMapping("/matregister")
	 @ResponseBody 
	 public OrderVO matregister(@RequestBody MatOrdVO vo){
		 //OrderVO result1 = matmapper.getmatregister(vo);		 
		 System.err.println(vo);
	 	 return null; 
	 	}
	
	
	 
	 
	 
	 //자재발주조회
	 @GetMapping("/orderlist")
	 public void orderlistmain(){
		 
	 }
	 
	
	 //자재/반제품 입고
	 @GetMapping("/warehousing")
	 public void warehousing() {
		 
	 }
	 
	 //자재/반제품 입고조회
	 @GetMapping("/warehousinglist")
	 public void warehousinglist() {
		 
	 }
	
	 //자재/반제품 재고조회
	 @GetMapping("/inventory")
	 public void inventory() {
		 
	 }
	 
	 
	 //재고조정관리
	 @GetMapping("/matadjust")
	 public void matadjust(){
	 
	 }
}

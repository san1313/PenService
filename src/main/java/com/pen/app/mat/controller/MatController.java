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
import com.pen.app.mat.vo.WareRegVO;
import com.pen.app.mat.vo.WarehousingVO;


@Controller
@RequestMapping("/mat")
public class MatController {

@Autowired MatMapper matmapper;
	
	//발주페이지
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
		 System.err.println(vo.getList());
		 System.out.println(vo.getList().get(0));
		 matmapper.getmatregister(vo.getList());		 
	 	 return null; 
	 	}
		 
	 //당일발주등록조회
	 @RequestMapping("/todaymatregister")
	 @ResponseBody
	 public List<OrderVO> todaymatregister(){
		 List<OrderVO> list = matmapper.gettodaymatregister();
		 return list;
	 }
	 
	 //자재발주조회페이지
	 @GetMapping("/orderlist")
	 public void matorderlist(){
		 
	 }
	 //자재발주조회
	 @RequestMapping("/orderlistajax")
	 @ResponseBody
	 public List<OrderVO> matorderlistajax(){
		 List<OrderVO> list = matmapper.getorderlistajax();	
		 return list;
	 }
	 
	 //자재발주조회 다중검색
	 @RequestMapping("/orderlistsearchajax")
	 @ResponseBody
	 public List<OrderVO> orderlistsearchajax(@RequestParam String result) {
		 List<OrderVO> list = matmapper.getorderlistsearchajax(result);
		 return list;
	 }
	  
	 
	
	 //자재입고페이지
	 @GetMapping("/warehousing")
	 public void warehousing() {
		 
	 }
	 
	 //자재 검사내역리스트
	 @RequestMapping("/warehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> warehousinglist(){
		 List<WarehousingVO> list = matmapper.getwarehousinglist();
		 return list;
	 }
	 
	 //자재 입고등록
	 @RequestMapping("/warehousingregister")
	 @ResponseBody
	 public WarehousingVO warehousingregister(@RequestBody WareRegVO vo) {
		 System.err.println(vo.getList());
		 int sum = 0;
		 for(WarehousingVO in : vo.getList()) {
			sum += in.getMatWrhqy(); 
		 }
		 vo.getList().get(0).setMatQnt(sum);
		 matmapper.getwarehousingregister(vo.getList());
		 return null;
	 }
	 
	 //당일건 자재입고등록리스트
	 @RequestMapping("/todaywarehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> gettodaywarehousinglist(){
		 List<WarehousingVO> list = matmapper.gettodaywarehousinglist();
		 return list;
	 }

	 
	 //반제품 검사내역리스트
	 @RequestMapping("/semiwarehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> semiwarehousinglist(){
		List<WarehousingVO> list = matmapper.getsemiwarehousinglist();
		return list;
	 }
	 
	 
	 
	 
	 
	 //자재 입고조회
	 @GetMapping("/warehousinglist")
	 public void warehousingmatlist() {
		 
	 }
	 
	 
	 //자재입고조회리스트
	 @GetMapping("/warehousingmatlistajax")
	 @ResponseBody
	 public List<WarehousingVO> warehousingmatlistajax(){
		 List<WarehousingVO> list = matmapper.getwarehousingmatlistajax();
		 return list;
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

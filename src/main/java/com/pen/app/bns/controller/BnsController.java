package com.pen.app.bns.controller;
   
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsOrdDetListVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

   
@Controller
@RequestMapping("/bns")
public class BnsController {
   
@Autowired BnsMapper dao;
   
	//주문서관리 페이지
   @GetMapping("/ordList")
   public String ordList(Model model, Authentication authentication) {
      model.addAttribute("ordList", dao.getOrdList());
      UserDetails user = (UserDetails) authentication.getPrincipal();
      model.addAttribute("userVO", user);
      return "bns/ordList";
   }
   
	@ResponseBody
	@GetMapping("/ordListAjax")
	public List<BnsOrdVO> ordListAjax(){
		List<BnsOrdVO> list = dao.getOrdList();
		return list;
	}
	
	@ResponseBody
	@GetMapping("/ordListconAjax")
	public List<BnsOrdVO> ordListconAjax(BnsOrdVO vo){
		System.out.println("아작스 통해서 들어온 데이터 : "+vo);
		List<BnsOrdVO> list = dao.getOrdListCon(vo);
		System.out.println("조회 이후 나온 데이터 : "+list);
		return list;
	}
	
	@RequestMapping("/insertOrdList")
	@ResponseBody
	public BnsOrdDetListVO insertOrdList(@RequestBody BnsOrdDetListVO list) {
		System.err.println(list.getList());
		dao.insertOrdList(list.getList());
		return list;
	}
	

	@ResponseBody
	@GetMapping("/accList")
	public List<BnsAccVO> accList() {
		List<BnsAccVO> list = dao.getAccList();
		return list;
	}
	
	@RequestMapping("/accKeyList")
	@ResponseBody
	public List<BnsAccVO> accKeyList(@RequestParam String result){
		List<BnsAccVO> list = dao.getAccKeyList(result);
		return list;
	}
	
	
	@ResponseBody
	@GetMapping("/prodList")
	public List<BnsProdVO> prodList() {
		List<BnsProdVO> list = dao.getProdList();
		
		return list;
	}
	
	@RequestMapping("/prodKeyList")
	@ResponseBody
	public List<BnsProdVO> prodKeyList(@RequestParam String result){
		List<BnsProdVO> list = dao.getProdKeyList(result);
		return list;
	}
	
	//주문서 수정 모달창 안의 제품리스트
	@ResponseBody
	@GetMapping("/prodListModAjax")
	public List<BnsOrdVO> prodListModAjax(String result){
		
		System.out.println(result);
		List<BnsOrdVO> list = dao.getProdModList(result);
		return list;
	}
	
	//주문서 수정 모달창 안의 제품 수정
	@RequestMapping("/modOrdList")
	@ResponseBody
	public BnsOrdVO modOrdList(@RequestBody BnsOrdDetListVO list) {
		System.err.println(list.getList());
		System.err.println(list.getList().get(1));
		dao.modOrdList(list.getList());
		return null;
	}
	
	//주문상세 삭제
	@RequestMapping("/delOrdDetList")
	@ResponseBody
	public BnsOrdVO delOrdDetList(@RequestBody BnsOrdDetListVO list) {
		dao.delOrdDetList(list.getList());
		return null;
	}
	
	
	@ResponseBody
	@GetMapping("/ordCode")
	List<BnsOrdVO> ordCode() {
		List<BnsOrdVO> list = dao.getOrdCode();
		System.out.println("주문코드 최대값 : "+list);
		return list;
	}
	
	
///계약서	
	//계약서 관리 페이지
	   @GetMapping("/conList")
	   public String conList(Model model, Authentication authentication) {
			/* model.addAttribute("conList", dao.getConList()); */
	      UserDetails user = (UserDetails) authentication.getPrincipal();
	      model.addAttribute("userVO", user);
	      return "bns/conList";
	   }

	 
///입고
	   @GetMapping("/storeList")
	   public String storeList(Model model, Authentication authentication) {
			/* model.addAttribute("conList", dao.getConList()); */
	      UserDetails user = (UserDetails) authentication.getPrincipal();
	      model.addAttribute("userVO", user);
	      return "bns/storeList";
	   }  
	
	
}

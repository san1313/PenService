package com.pen.app.bns.controller;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;
	
	
@Controller
@RequestMapping("/bns")
public class BnsController {
	
@Autowired BnsMapper dao;
	
	@GetMapping("/ordList")
	public String ordList(Model model) {
		model.addAttribute("ordList", dao.getOrdList());
		return "bns/ordList";
	}
	
	@ResponseBody
	@GetMapping("/ordListAjax")
	public List<BnsOrdVO> ordListAjax(){
		List<BnsOrdVO> list = dao.getOrdList();
		return list;
	}
	
	@RequestMapping("/insertOrdList")
	@ResponseBody
	public String insertOrdList(Model model) {
		return "redirect:/insertOrdList";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

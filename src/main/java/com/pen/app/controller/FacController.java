package com.pen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoVO;


@Controller
@RequestMapping("/fac")
public class FacController {
	
	@Autowired FacMapper dao;
	
	 @GetMapping("/register")
	    public void register() {
		 	
	    }
	 @GetMapping("/list")
	    public void getList() {
		 	
	    }
	 	
	 	@ResponseBody
		@GetMapping("/infoListAjax")
		public List<FacInfoVO> infoListAjax(){
		List<FacInfoVO> list = dao.getList();
		System.out.println(list);
		return list;
		}
	 	
	 	@ResponseBody
	 	@GetMapping("/proclistAjax")
	 	public List<FacConnProcVO> proclist(){
	 		List<FacConnProcVO> list = dao.getproclist();
	 		return list;
	 	}
	 	
	 	
	 	
	 	@ResponseBody
	 	@RequestMapping("/procminilist")
		public List<FacConnProcVO> proclistAjax(@RequestParam String result){
	 		String data1 = "%";
	 		result += "%";
	 		data1 +=result;
	 		System.out.println(result);
		List<FacConnProcVO> list = dao.getprocminilist(data1);
		System.out.println(list);
		return list;
		}
	 	
	 	
	 	
}

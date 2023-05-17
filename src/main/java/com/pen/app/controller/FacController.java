package com.pen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.fac.mapper.FacMapper;
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
}

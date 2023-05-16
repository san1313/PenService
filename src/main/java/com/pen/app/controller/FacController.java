package com.pen.app.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FacController {
	
	 @GetMapping("/fac/register")
	    public void register() {
		 	
	    }
	 @GetMapping("/fac/fac_list")
	    public void getList() {
		 	
	    }
	 @PostMapping("/fac/fac_list")
	 public String get() {
	     return "";
	 }
}

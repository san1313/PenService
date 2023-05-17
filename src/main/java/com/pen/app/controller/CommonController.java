package com.pen.app.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pen.app.user.UserVO;
import com.pen.app.user.service.impl.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	@Autowired UserServiceImpl userService;
	@Autowired AuthenticationManager authenticationManager;
	
	@GetMapping(value = {"/top", "/"})
	public String top() {
		return "/top";
	}
	
	@GetMapping("/modifyUser")
	public String modifyUserForm(Model model, Principal principal) {
		UserVO vo = new UserVO();
		vo.setEmpId(principal.getName());
		vo = userService.getUser(vo);
		model.addAttribute("vo",vo);
		return "/com/modifyUser";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/modify")
	public ResponseEntity<HttpStatus> modifyUser(@RequestBody UserVO vo, HttpSession session) { 
		System.out.println(vo.getPassword());
		if (vo.getPassword()!="") {
			vo.setEmpPw(new BCryptPasswordEncoder().encode(vo.getPassword()));
		}
		userService.modifyUser(vo);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("/admin/userManage")
	public String userManage(){
		
		return "/com/userManage";
	}
	
	@GetMapping("/test")
	public void test() {
		
	}
//	@GetMapping("/user/user")
//	public void user(@AuthenticationPrincipal Principal uservo, HttpSession session) {
//		String sessionLoginId = (String)session.getAttribute("loginId");
//		System.out.println(sessionLoginId);
//		System.out.println("------------------------");
//		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println(userDetails.getUsername());
//		System.out.println("------------------------");
////		System.out.println(uservo.getName());
//	}
}

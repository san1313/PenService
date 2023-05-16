package com.pen.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pen.app.user.UserVO;
import com.pen.app.user.service.impl.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	@Autowired UserServiceImpl userService;
	
	@GetMapping(value = {"/top", "/"})
	public String top() {
		return "/top";
	}
	
	@GetMapping("/modifyUser")
	public String modifyUserForm() {
		return "/com/modifyUser";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/modify")
	public String modifyUser(UserVO vo) {
		System.out.println(vo.getPassword());
		if (vo.getPassword()!="") {
			vo.setEmpPw(new BCryptPasswordEncoder().encode(vo.getPassword()));
		}
		userService.modifyUser(vo);
		System.out.println(vo);
		return "/com/modifyUser";
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

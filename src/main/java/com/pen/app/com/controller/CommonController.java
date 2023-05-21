package com.pen.app.com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.service.impl.UserServiceImpl;
import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.UserVO;

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
	public boolean modifyUser(@RequestBody UserVO vo, HttpSession session) { 
		if (vo.getPassword()!="") {
			vo.setEmpPw(new BCryptPasswordEncoder().encode(vo.getPassword()));
		}
		return userService.modifyUser(vo);
	}
	
	@ResponseBody
	@GetMapping("/getAuthListAjax")
	public List<AuthVO> getAuthListAjax() {
		return userService.getAuthList();
	}
	
	@GetMapping("/admin/userManage")
	public String userManage(){
		return "/com/userManage";
	}
	
	@ResponseBody
	@GetMapping("/admin/userListAjax")
	public ToastUiResponseDTO userListAjax(){
		
		return new ToastUiResponseDTO(userService.getUserList());
	}
	
	@ResponseBody
	@PostMapping("/admin/userModifyAjax")
	public ToastUiResponseDTO userModifyAjax(@RequestBody Map<String, List<UserVO>> modifiedRows) {
		System.out.println(modifiedRows);
		String result = "Success";
		List<UserVO> updatedRows = modifiedRows.get("updatedRows");
		List<UserVO> createdRows = modifiedRows.get("createdRows");
		List<UserVO> deletedRows = modifiedRows.get("deletedRows");
		
		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size()!=0) {
			userService.modifyUserList(updatedRows);
		}
		
		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size()!=0) {
			for(UserVO vo : createdRows) { // 비밀번호 암호화
				vo.setEmpPw(new BCryptPasswordEncoder().encode(vo.getEmpTel().substring(vo.getEmpTel().length()-4)));
			}
			if(!userService.insertUserList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}
		}
		
		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size()!=0) {
			if(!userService.deleteUserList(deletedRows)) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}
	
	@ResponseBody
	@GetMapping("/admin/getUserWithNameAjax")
	public List<UserVO> getUserAjax(String empName) {
		return userService.getUserWithName(empName);
	}
	
	@ResponseBody
	@PostMapping("/admin/resetPassword")
	public boolean resetPassword(String empNum, String empPw) {
		return userService.resetPassword(empNum, new BCryptPasswordEncoder().encode(empPw));
	}
	
	@ResponseBody
	@GetMapping("/admin/getEmpCode")
	public String getEmpCode() {
		return userService.getEmpCode();
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

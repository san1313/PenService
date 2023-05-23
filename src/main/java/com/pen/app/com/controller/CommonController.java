package com.pen.app.com.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.service.impl.ComCodeServiceImpl;
import com.pen.app.com.service.impl.ItemServiceImpl;
import com.pen.app.com.service.impl.UserServiceImpl;
import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;
import com.pen.app.com.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	@Autowired UserServiceImpl userService;
	@Autowired ItemServiceImpl itemService;
	@Autowired ComCodeServiceImpl comCodeService;
	@Autowired AuthenticationManager authenticationManager;
	
	@GetMapping(value = {"/top", "/"})
	public String top() {
		return "/top";
	}
	
	//로그인유저 정보수정
	@GetMapping("/modifyUser")
	public String modifyUserForm(Model model, Principal principal) {
		UserVO vo = new UserVO();
		vo.setEmpId(principal.getName());
		vo = userService.getUser(vo);
		model.addAttribute("vo",vo);
		return "/com/modifyUser";
		
	}
	@PostMapping("/modify")
	public boolean modifyUser(@RequestBody UserVO vo, HttpSession session) { 
		if (vo.getPassword()!="") {
			vo.setEmpPw(new BCryptPasswordEncoder().encode(vo.getPassword()));
		}
		return userService.modifyUser(vo);
	}
	
	//로그인 페이지 -----------------------------------------------
	@GetMapping("/login")
	public void login() {
		
	}
	
	//사원관리페이지 -----------------------------------------------
	
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
	
	//품목정보 페이지 -----------------------------------------------
	@GetMapping("/admin/itemManage")
	public String itemManage() {
		return "/com/itemManage";
	}
	
	@GetMapping("/admin/getMatList")
	@ResponseBody
	public ToastUiResponseDTO getMatList(){
		return new ToastUiResponseDTO(itemService.getMatList());
	}
	
	@GetMapping("/admin/getMatWithName")
	@ResponseBody
	public List<MatVO> getMatWithName(String itemName) {
		return itemService.getMatWithName(itemName);
	}
	
	@GetMapping("/admin/getMatCode")
	@ResponseBody
	public String getMatCode() {
		return itemService.getMatCode();
	}
	
	@ResponseBody
	@PostMapping("/admin/matModifyAjax")
	public ToastUiResponseDTO matModifyAjax(@RequestBody Map<String, List<MatVO>> modifiedRows) {
		String result = "Success";
		List<MatVO> updatedRows = modifiedRows.get("updatedRows");
		List<MatVO> createdRows = modifiedRows.get("createdRows");
		
		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size()!=0) {
			itemService.modifyMatList(updatedRows);
		}
		
		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size()!=0) {
			if(!itemService.insertMatList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}
		
		}
		return new ToastUiResponseDTO(result);
	}
	
	@GetMapping("/admin/getSemiList")
	@ResponseBody
	public ToastUiResponseDTO getSemiList(){
		return new ToastUiResponseDTO(itemService.getSemiList());
	}
	
	@GetMapping("/admin/getSemiWithName")
	@ResponseBody
	public List<SemiVO> getSemiWithName(String itemName) {
		return itemService.getSemiWithName(itemName);
	}
	
	@GetMapping("/admin/getSemiCode")
	@ResponseBody
	public String getSemiCode() {
		return itemService.getSemiCode();
	}
	
	@ResponseBody
	@PostMapping("/admin/semiModifyAjax")
	public ToastUiResponseDTO semiModifyAjax(@RequestBody Map<String, List<SemiVO>> modifiedRows) {
		String result = "Success";
		List<SemiVO> updatedRows = modifiedRows.get("updatedRows");
		List<SemiVO> createdRows = modifiedRows.get("createdRows");
		
		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size()!=0) {
			itemService.modifySemiList(updatedRows);
		}
		
		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size()!=0) {
			if(!itemService.insertSemiList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}
		
		}
		return new ToastUiResponseDTO(result);
	}
	
	@GetMapping("/admin/getProdList")
	@ResponseBody
	public ToastUiResponseDTO getProdList(){
		return new ToastUiResponseDTO(itemService.getProdList());
	}
	
	@GetMapping("/admin/getProdWithName")
	@ResponseBody
	public List<ProdVO> getProdWithName(String itemName) {
		return itemService.getProdWithName(itemName);
	}
	
	@GetMapping("/admin/getProdCode")
	@ResponseBody
	public String getProdCode() {
		return itemService.getProdCode();
	}
	@ResponseBody
	@PostMapping("/admin/prodModifyAjax")
	public ToastUiResponseDTO prodModifyAjax(@RequestBody Map<String, List<ProdVO>> modifiedRows) {
		System.out.println("----------------Prod--------------");
		System.out.println(modifiedRows);
		String result = "Success";
		List<ProdVO> updatedRows = modifiedRows.get("updatedRows");
		List<ProdVO> createdRows = modifiedRows.get("createdRows");
		
		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size()!=0) {
			itemService.modifyProdList(updatedRows);
		}
		
		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size()!=0) {
			if(!itemService.insertProdList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}
		
		}
		return new ToastUiResponseDTO(result);
	}
	
	//공통코드 조회 페이지 -----------------------------------------------
	@GetMapping("/admin/comCode")
	public String comCode() {
		return "/com/comCode";
	}
	
	@GetMapping("/admin/getComCodeList")
	@ResponseBody
	public ToastUiResponseDTO getComCodeList(){
		return new ToastUiResponseDTO(comCodeService.getComCodeList());
	}
	
	@GetMapping("/admin/getComCodeWithName")
	@ResponseBody
	public List<ComCodeVO> getComCodeWithName(String codeName) {
		return comCodeService.getComCodeWithName(codeName);
	}
	
	@GetMapping("/admin/getInnerCodeList")
	@ResponseBody
	public List<ComCodeVO> getInnerCodeList(String comCode){
		return comCodeService.getInnerCodeList(comCode);
	}
}

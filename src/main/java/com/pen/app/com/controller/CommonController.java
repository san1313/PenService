package com.pen.app.com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.pen.app.com.service.impl.AccountServiceImpl;
import com.pen.app.com.service.impl.BomServiceImpl;
import com.pen.app.com.service.impl.ComCodeServiceImpl;
import com.pen.app.com.service.impl.ItemServiceImpl;
import com.pen.app.com.service.impl.ProcFlowServiceImpl;
import com.pen.app.com.service.impl.ProcessServiceImpl;
import com.pen.app.com.service.impl.UserServiceImpl;
import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.BomVO;
import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.ItemVO;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProcFlowVO;
import com.pen.app.com.vo.ProcessVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;
import com.pen.app.com.vo.UserVO;
import com.pen.app.com.vo.iCodeVO;

/*
 * 배창우
 * 공통부분
 */
@Controller
public class CommonController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	ItemServiceImpl itemService;
	@Autowired
	ComCodeServiceImpl comCodeService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	AccountServiceImpl accService;
	@Autowired
	ProcessServiceImpl procService;
	@Autowired
	ProcFlowServiceImpl flowService;
	@Autowired
	BomServiceImpl bomService;

	@GetMapping(value = { "/top", "/" })
	public String top() {
		return "top";
	}

	// 아이디로 유저 조회
	@GetMapping("/getUser")
	@ResponseBody
	public UserVO getUser(String empId) {
		UserVO vo = new UserVO();
		vo.setEmpId(empId);
		return userService.getUser(vo);
	}

	// 로그인유저 정보수정 페이지
	@GetMapping("/modifyUser")
	public String modifyUserForm(Model model, Principal principal) {
		UserVO vo = new UserVO();
		vo.setEmpId(principal.getName());
		vo = userService.getUser(vo);
		model.addAttribute("vo", vo);
		return "com/modifyUser";

	}

	// 본인 계정 정보수정
	@PostMapping("/modify")
	@ResponseBody
	public boolean modifyUser(@RequestBody Map<String, String> voMap) {
		UserVO modVo = new UserVO();
		modVo.setEmpId(voMap.get("empId"));
		modVo.setEmpPw(voMap.get("empPw"));
		modVo.setEmpTel(voMap.get("empTel"));
		UserVO userVo = userService.getUser(modVo);
		modVo.setEmpNum(userVo.getEmpNum());
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		if (modVo.getPassword() != "") {
			modVo.setEmpPw(bcpe.encode(modVo.getPassword()));
		}
		if (bcpe.matches(voMap.get("curPw"), userVo.getPassword())) {
			return userService.modifyUser(modVo);
		} else {
			return false;
		}
	}

	// 로그인 페이지 -----------------------------------------------
	@GetMapping("/login")
	public String login(Principal principal, HttpServletRequest request) {
		if(principal != null) {
			return "redirect:"+request.getContextPath()+"/top";
		}else {
			return "login";
		}
	}

	// 사원관리페이지 -----------------------------------------------
	@GetMapping("/admin/userManage")
	public String userManage() {
		return "com/userManage";
	}

	// 권한 리스트 조회
	@ResponseBody
	@GetMapping("/getAuthListAjax")
	public List<AuthVO> getAuthListAjax() {
		return userService.getAuthList();
	}

	// 사원 리스트 조회
	@ResponseBody
	@GetMapping("/admin/userListAjax")
	public ToastUiResponseDTO userListAjax() {

		return new ToastUiResponseDTO(userService.getUserList());
	}

	// 저장 버튼 동작
	@ResponseBody
	@PostMapping("/admin/userModifyAjax")
	public ToastUiResponseDTO userModifyAjax(@RequestBody Map<String, List<UserVO>> modifiedRows) {
		String result = "Success";
		List<UserVO> updatedRows = modifiedRows.get("updatedRows");
		List<UserVO> createdRows = modifiedRows.get("createdRows");
		List<UserVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			userService.modifyUserList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			for (UserVO vo : createdRows) { // 비밀번호 암호화
				vo.setEmpPw(new BCryptPasswordEncoder().encode(vo.getEmpTel().substring(vo.getEmpTel().length() - 4)));
			}
			if (!userService.insertUserList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}
		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (!userService.deleteUserList(deletedRows)) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}

	// 이름으로 사원 조회
	@ResponseBody
	@GetMapping("/admin/getUserWithNameAjax")
	public List<UserVO> getUserAjax(String empName) {
		return userService.getUserWithName(empName);
	}

	// 사원 비밀번호 초기화
	@ResponseBody
	@PostMapping("/admin/resetPassword")
	public boolean resetPassword(String empNum, String empPw) {
		return userService.resetPassword(empNum, new BCryptPasswordEncoder().encode(empPw));
	}

	// 다음 사원코드 조회
	@ResponseBody
	@GetMapping("/admin/getEmpCode")
	public String getEmpCode() {
		return userService.getEmpCode();
	}

	// 품목정보 페이지 -----------------------------------------------
	@GetMapping("/admin/itemManage")
	public String itemManage() {
		return "com/itemManage";
	}

	// 자재 리스트 조회
	@GetMapping("/admin/getMatList")
	@ResponseBody
	public ToastUiResponseDTO getMatList() {
		return new ToastUiResponseDTO(itemService.getMatList());
	}

	// 자재 이름으로 조회
	@GetMapping("/admin/getMatWithName")
	@ResponseBody
	public List<MatVO> getMatWithName(String itemName) {
		return itemService.getMatWithName(itemName);
	}

	// 다음 자재코드 조회
	@GetMapping("/admin/getMatCode")
	@ResponseBody
	public String getMatCode() {
		return itemService.getMatCode();
	}

	// 저장 버튼 동작
	@ResponseBody
	@PostMapping("/admin/matModifyAjax")
	public ToastUiResponseDTO matModifyAjax(@RequestBody Map<String, List<MatVO>> modifiedRows) {
		String result = "Success";
		List<MatVO> updatedRows = modifiedRows.get("updatedRows");
		List<MatVO> createdRows = modifiedRows.get("createdRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			itemService.modifyMatList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (!itemService.insertMatList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}

		}
		return new ToastUiResponseDTO(result);
	}

	// 반제품 리스트 조회
	@GetMapping("/admin/getSemiList")
	@ResponseBody
	public ToastUiResponseDTO getSemiList() {
		return new ToastUiResponseDTO(itemService.getSemiList());
	}

	// 반제품 이름으로 조회
	@GetMapping("/admin/getSemiWithName")
	@ResponseBody
	public List<SemiVO> getSemiWithName(String itemName) {
		return itemService.getSemiWithName(itemName);
	}

	// 다음 반제품코드 조회
	@GetMapping("/admin/getSemiCode")
	@ResponseBody
	public String getSemiCode() {
		return itemService.getSemiCode();
	}

	// 저장 버튼 동작
	@ResponseBody
	@PostMapping("/admin/semiModifyAjax")
	public ToastUiResponseDTO semiModifyAjax(@RequestBody Map<String, List<SemiVO>> modifiedRows) {
		String result = "Success";
		List<SemiVO> updatedRows = modifiedRows.get("updatedRows");
		List<SemiVO> createdRows = modifiedRows.get("createdRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			itemService.modifySemiList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (!itemService.insertSemiList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}

		}
		return new ToastUiResponseDTO(result);
	}

	// 완제품 리스트 조회
	@GetMapping("/admin/getProdList")
	@ResponseBody
	public ToastUiResponseDTO getProdList() {
		return new ToastUiResponseDTO(itemService.getProdList());
	}

	// 완제품 이름으로 조회
	@GetMapping("/admin/getProdWithName")
	@ResponseBody
	public List<ProdVO> getProdWithName(String itemName) {
		return itemService.getProdWithName(itemName);
	}

	// 다음 완제품코드 조회
	@GetMapping("/admin/getProdCode")
	@ResponseBody
	public String getProdCode() {
		return itemService.getProdCode();
	}

	// 저장 버튼 동작
	@ResponseBody
	@PostMapping("/admin/prodModifyAjax")
	public ToastUiResponseDTO prodModifyAjax(@RequestBody Map<String, List<ProdVO>> modifiedRows) {
		String result = "Success";
		List<ProdVO> updatedRows = modifiedRows.get("updatedRows");
		List<ProdVO> createdRows = modifiedRows.get("createdRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			itemService.modifyProdList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (!itemService.insertProdList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}

		}
		return new ToastUiResponseDTO(result);
	}

	// 공통코드 관리 페이지 -----------------------------------------------
	@GetMapping("/admin/comCodeManage")
	public String comCode() {
		return "com/comCodeManage";
	}

	// 공통코드 리스트 조회
	@GetMapping("/admin/getComCodeList")
	@ResponseBody
	public ToastUiResponseDTO getComCodeList() {
		return new ToastUiResponseDTO(comCodeService.getComCodeList());
	}

	// 공통코드 이름으로 조회
	@GetMapping("/admin/getComCodeWithName")
	@ResponseBody
	public List<ComCodeVO> getComCodeWithName(String codeName) {
		return comCodeService.getComCodeWithName(codeName);
	}

	// 세부코드 리스트 조회
	@GetMapping("/admin/getInnerCodeList")
	@ResponseBody
	public List<ComCodeVO> getInnerCodeList(String comCode) {
		return comCodeService.getInnerCodeList(comCode);
	}

	@PostMapping("/admin/iCodeModifyAjax")
	@ResponseBody
	public ToastUiResponseDTO innerCodeModifyAjax(@RequestBody Map<String, List<iCodeVO>> modifiedRows) {
		return comCodeService.modifyICodeList(modifiedRows);
	}

	@GetMapping("/void")
	@ResponseBody
	public ToastUiResponseDTO voidReturn() {
		return new ToastUiResponseDTO(new ArrayList<Integer>());
	}

	// 거래처관리 페이지-------------------------------------------------
	@GetMapping("/admin/accountManage")
	public String accountManage() {
		return "com/accountManage";

	}

	// 거래처 리스트 조회
	@GetMapping("/admin/getAccountList")
	@ResponseBody
	public ToastUiResponseDTO getAccountList() {
		return new ToastUiResponseDTO(accService.getAccountList());
	}

	// 거래처 구분으로 조회
	@PostMapping("/admin/getAccListWithType")
	@ResponseBody
	public List<AccountVO> getAccListWithType(String accType) {
		return accService.getAccListWithType(accType);
	}

	// 거래처 구분 리스트 조회
	@GetMapping("/admin/getAccTypeList")
	@ResponseBody
	public List<String> getAccTypeList() {
		return accService.getAccTypeList();
	}

	// 다음 거래처코드 조회
	@GetMapping("/admin/getAccCode")
	@ResponseBody
	public String getAccCode() {
		return accService.getAccCode();
	}

	// 저장 버튼 동작
	@ResponseBody
	@PostMapping("/admin/accModifyAjax")
	public ToastUiResponseDTO accModifyAjax(@RequestBody Map<String, List<AccountVO>> modifiedRows) {
		String result = "Success";
		List<AccountVO> updatedRows = modifiedRows.get("updatedRows");
		List<AccountVO> createdRows = modifiedRows.get("createdRows");
		List<AccountVO> deletedRows = modifiedRows.get("deletedRows");
		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			accService.modifyAccList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (!accService.insertAccList(createdRows)) { // 결과가 0건이면
				result = "Fail";
			}
		}
		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (!accService.deleteAccList(deletedRows)) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}

	// 거래처별 항목조회
	@ResponseBody
	@GetMapping("/admin/getItemListWithAccCode")
	public List<ItemVO> getItemListWithAccCode(String accCode) {
		return accService.getItemListWithAccCode(accCode);
	}

	// 이름으로 거래처 조회
	@ResponseBody
	@GetMapping("/admin/searchAccAjax")
	public List<AccountVO> searchAccAjax(String accName, String accType) {
		return accService.searchAccList(accName, accType);
	}
	
	// 거래 품목 관리 페이지 -------------------------------------------------------
	@GetMapping("/admin/accountItemManage")
	public String accountItemManage() {
		return "com/accountItemManage";
	}
	
	// 거래처 목록가져오기
	@GetMapping("/admin/getAccList")
	@ResponseBody
	public ToastUiResponseDTO getAccList(String accName) {
		return new ToastUiResponseDTO(accService.getAccList(accName));
	}
	
	// 거래처별 거래품목 가져오기
	@GetMapping("/admin/getAccItemList")
	@ResponseBody
	public ToastUiResponseDTO getAccItemList(String accCode) {
		return new ToastUiResponseDTO(accService.getItemListWithAccCode(accCode));
	}
	
	// 자재,완제품 리스트 가져오기
	@GetMapping("/admin/getAllAccItemList")
	@ResponseBody
	public ToastUiResponseDTO getAllAccItemList(String itemName, String accType) {
		return new ToastUiResponseDTO(accService.getAllAccItemList(itemName, accType));
	}
	
	// 거래처별 거래품목 저장
	@PostMapping("/admin/accItemModify")
	@ResponseBody
	public ToastUiResponseDTO accItemModify(@RequestBody Map<String, List<ItemVO>> map) {
		return accService.modifyAccItemList(map);
	}
	// 공정 관리 페이지---------------------------------------------------
	@GetMapping("/admin/processManage")
	public String processManage() {
		return "com/processManage";
	}

	// 공정구분 리스트 받아오기
	@GetMapping("/admin/getProcTypeList")
	@ResponseBody
	public List<String> getProcTypeList() {
		return procService.getProcTypeList();
	}

	// 공정 리스트 받아오기
	@GetMapping("/admin/getProcList")
	@ResponseBody
	public ToastUiResponseDTO getProcList() {
		return new ToastUiResponseDTO(procService.getProcList());
	}

	// 공정 구분별로 리스트 조회
	@GetMapping("/admin/getProcWithType")
	@ResponseBody
	public List<ProcessVO> getProcWithType(String procType) {
		return procService.getProcWithType(procType);
	}

	// 다음 공정코드 조회
	@GetMapping("/admin/getProcCode")
	@ResponseBody
	public String getProcCode() {
		return procService.getProcCode();
	}

	// 저장 버튼 동작
	@PostMapping("/admin/procModifyAjax")
	@ResponseBody
	public ToastUiResponseDTO procModifyAjax(@RequestBody Map<String, List<ProcessVO>> modifiedRows) {
		return procService.modifyProcList(modifiedRows);
	}

	// 공정 흐름 페이지-----------------------------------------------
	@GetMapping("/admin/procFlowManage")
	public String procFlowManage() {
		return "com/procFlowManage";
	}
	
	// 제품 리스트 조회
	@GetMapping("/admin/getFlowItemList")
	@ResponseBody
	public ToastUiResponseDTO getFlowItemList() {
		return new ToastUiResponseDTO(flowService.getFlowItemList());
	}
	
	// 이름으로 제품 조회
	@GetMapping("/admin/getFlowItemListWithName")
	@ResponseBody
	public List<Map<String, String>> getFlowItemListWithName(String itemName){
		return flowService.getFlowItemListWithName(itemName);
	}
	
	// 공정 흐름 리스트 조회
	@GetMapping("/admin/getFlowList")
	@ResponseBody
	public List<ProcFlowVO> getFlowList(String itemCode){
		return flowService.getFlowList(itemCode);
	}
	
	// 저장 버튼 동작
	@PostMapping("/admin/procFlowModifyAjax")
	@ResponseBody
	public ToastUiResponseDTO procFlowModifyAjax(@RequestBody Map<String, List<ProcFlowVO>> modifiedRows) {
		return flowService.modifyFlowList(modifiedRows);
	}
	
	// BOM 관리 페이지 ---------------------------------------------------
	@GetMapping("/admin/bomManage")
	public String bomManage() {
		return "com/bomManage";
	}
	
	@GetMapping("/admin/getBomList")
	@ResponseBody
	public ToastUiResponseDTO getBomList(String itemCode) {
		return new ToastUiResponseDTO(bomService.getBomList(itemCode));
	}
	
	@GetMapping("/admin/getBomProcList")
	@ResponseBody
	public List<Map<String, String>> getBomProcList(String itemCode){
		return bomService.getBomProcList(itemCode);
	}
	
	@GetMapping("/admin/getBomMatList")
	@ResponseBody
	public ToastUiResponseDTO getBomMatList() {
		return new ToastUiResponseDTO(bomService.getBomMatList());
	}
	
	@GetMapping("/admin/getBomMatWithName")
	@ResponseBody
	public List<ItemVO> getBomMatWithName(String itemName){
		return bomService.getBomMatWithName(itemName);
	}
	
	@PostMapping("/admin/bomModifyAjax")
	@ResponseBody
	public ToastUiResponseDTO bomModifyAjax(@RequestBody Map<String, List<BomVO>> modifiedRows) {
		return bomService.modifyBomList(modifiedRows);
	}
}

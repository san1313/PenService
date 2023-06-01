package com.pen.app.qip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.qip.service.impl.TestCodeServiceImpl;
import com.pen.app.qip.service.impl.TestPerItemServiceImpl;
import com.pen.app.qip.service.impl.TestServiceImpl;
import com.pen.app.qip.service.impl.TestViewServiceImpl;
import com.pen.app.qip.vo.ItemTestDTO;
import com.pen.app.qip.vo.TestCodeVO;
import com.pen.app.qip.vo.TestPerItemVO;

/*
 * 배창우
 * 품질검사
 */

@Controller
@RequestMapping("/qip")
public class QualityController {
	
	@Autowired
	TestCodeServiceImpl tCodeService;
	@Autowired
	TestPerItemServiceImpl tpiService;
	@Autowired
	TestServiceImpl testService;
	@Autowired
	TestViewServiceImpl viewService;
	
	
	// 검사코드 관리 페이지 ------------------------------------------------
	@GetMapping("/testCodeManage")
	String testCodeManage() {
		return "/qip/testCodeManage";
	}
	
	// 검사코드 리스트 조회
	@GetMapping("/getTCodeList")
	@ResponseBody
	ToastUiResponseDTO getTCodeList() {
		return new ToastUiResponseDTO(tCodeService.getTCodeList());
	}
	
	// 검사코드 이름으로 조회
	@GetMapping(value = "/getTCodeList", params = {"testName"})
	@ResponseBody
	ToastUiResponseDTO getTCodeWithName(String testName) {
		return new ToastUiResponseDTO(tCodeService.getTCodeWithName(testName));
	}
	
	// 다음 검사코드 가져오기
	@GetMapping("/getTestCode")
	@ResponseBody
	String getTestCode() {
		return tCodeService.getTestCode();
	}
	
	// 저장 버튼 동작
	@PostMapping("/tCodeModifyAjax")
	@ResponseBody
	ToastUiResponseDTO tCodeModifyAjax(@RequestBody Map<String, List<TestCodeVO>> modifiedRows) {
		return tCodeService.modifyTCode(modifiedRows);
	}
	
	// 항목별 검사 관리 페이지 -----------------------------------------------
	@GetMapping("/testPerItemManage")
	String testPerItemManage() {
		return "/qip/testPerItemManage";
	}
	
	// 검사항목 리스트 조회
	@GetMapping("/getTestItemList")
	@ResponseBody
	ToastUiResponseDTO getTestItemList() {
		return new ToastUiResponseDTO(tpiService.getTestItemList());
	}
	
	// 검사항목 이름으로 조회
	@GetMapping(value = "/getTestItemList", params = "itemName")
	@ResponseBody
	ToastUiResponseDTO getTestItemWithName(String itemName) {
		return new ToastUiResponseDTO(tpiService.getTestItemWithName(itemName));
	}
	
	// 항목별 검사 리스트 조회
	@GetMapping("/getTPIList")
	@ResponseBody
	ToastUiResponseDTO getTPIList(String itemCode) {
		return new ToastUiResponseDTO(tpiService.getTPIList(itemCode));
	}
	
	// 저장 버튼 동작
	@PostMapping("/tpiModifyAjax")
	@ResponseBody
	ToastUiResponseDTO tpiModifyAjax(@RequestBody Map<String, List<TestPerItemVO>> modifiedRows) {
		return tpiService.modifyTCode(modifiedRows);
	}
	
	// 검사 페이지 -----------------------------------------------------
	@GetMapping("/test")
	String test() {
		return "/qip/itemTest";
	}
	
	// 발주 검사 리스트 조회
	@GetMapping("/matTestList")
	@ResponseBody
	ToastUiResponseDTO matTestList() {
		return new ToastUiResponseDTO(testService.matTestList());
	}
	
	// 제품 검사 리스트 조회
	@GetMapping("/itemTestList")
	@ResponseBody
	ToastUiResponseDTO itemTestList() {
		return null;
	}
	
	// 보관기간 초과 자재 검사 리스트 조회
	@GetMapping("/expTestList")
	@ResponseBody
	ToastUiResponseDTO expTestList() {
		return new ToastUiResponseDTO(testService.expTestList());
	}
	
	// 검사완료 동작
	@PostMapping("/testInsertAjax")
	@ResponseBody
	boolean testInsertAjax(@RequestBody ItemTestDTO obj) {
		System.err.println(obj);
		return testService.insertTest(obj);
	}
	
	// 검사 조회 페이지 ------------------------------------------------
	@GetMapping("/testView")
	String testView() {
		return "/qip/testView";
	}
	
	// 자재입고검사 리스트
	@GetMapping("/matView")
	@ResponseBody
	ToastUiResponseDTO matView(@RequestParam Map<String, String> map) {
		return viewService.getMatView(map);
	}
	
	// 제품 검사 리스트
	@GetMapping("/itemView")
	@ResponseBody
	ToastUiResponseDTO itemView(@RequestParam Map<String, String> map) {
		return viewService.getItemView(map);
	}
}

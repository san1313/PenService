package com.pen.app.qip.service;

import java.util.List;

import com.pen.app.qip.vo.ItemTestDTO;
import com.pen.app.qip.vo.TestExpModalVO;
import com.pen.app.qip.vo.TestItemModalVO;
import com.pen.app.qip.vo.TestMatModalVO;

public interface TestService {
	// 자재 입고검사 모달 리스트 조회
	List<TestMatModalVO> matTestList();

	// 제품 검사 모달 리스트 조회
	List<TestItemModalVO> itemTestList();
	
	// 보관기간 초과 자재 검사 모달 리스트 조회
	List<TestExpModalVO> expTestList();
	
	// 검사 내역 입력
	boolean insertTest(ItemTestDTO dto);

}

package com.pen.app.qip.mapper;

import java.util.List;

import com.pen.app.qip.vo.TestExpModalVO;
import com.pen.app.qip.vo.TestMatModalVO;
import com.pen.app.qip.vo.TestPerItemVO;
import com.pen.app.qip.vo.TestResultVO;

public interface TestMapper {
	// 자재 입고검사 모달 리스트 조회
	List<TestMatModalVO> matTestList();
	
	// 보관기간 초과 자재 검사 모달 리스트 조회
	List<TestExpModalVO> expTestList();
	
	// 검사 완료 버튼 동작(자재입고)
	int insertMatTest(TestResultVO rVO, List<TestPerItemVO> list);
	
	// 검사 완료 버튼 동작(초과자재)
	int insertExpTest(TestResultVO rVO, List<TestPerItemVO> list);
}

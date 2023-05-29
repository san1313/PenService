package com.pen.app.qip.service;

import java.util.List;

import com.pen.app.qip.vo.TestMatModalVO;

public interface TestService {
	// 자재 입고검사 모달 리스트 조회
	List<TestMatModalVO> matTestList();
}

package com.pen.app.qip.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.qip.vo.TestCodeVO;

public interface TestCodeService {
	// 검사코드 리스트 조회
	List<TestCodeVO> getTCodeList();

	// 이름으로 검사코드 조회
	List<TestCodeVO> getTCodeWithName(String testName);
	
	// 다음 검사코드 가져오기
	String getTestCode();
	
	// 저장 버튼 동작
	ToastUiResponseDTO modifyTCode(Map<String, List<TestCodeVO>> modifiedRows);
}

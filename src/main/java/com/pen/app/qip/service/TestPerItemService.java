package com.pen.app.qip.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.qip.vo.TestItemVO;
import com.pen.app.qip.vo.TestPerItemVO;

public interface TestPerItemService {
	// 검사코드 리스트 조회
	List<TestItemVO> getTestItemList();

	// 이름으로 검사코드 조회
	List<TestItemVO> getTestItemWithName(String itemName);

	// 항목별 검사목록 조회
	List<TestPerItemVO> getTPIList(String itemCode);

	// 저장 버튼 동작
	ToastUiResponseDTO modifyTCode(Map<String, List<TestPerItemVO>> modifiedRows);
}

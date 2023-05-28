package com.pen.app.com.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.vo.ProcFlowVO;

public interface ProcFlowService {
	// 제품 리스트 조회
	List<Map<String, String>> getFlowItemList();

	// 제품 이름으로 조회
	List<Map<String, String>> getFlowItemListWithName(String itemName);
	
	// 공정 흐름 리스트 조회
	List<ProcFlowVO> getFlowList(String itemCode);
	
	// 저장 버튼 동작
	ToastUiResponseDTO modifyFlowList(Map<String, List<ProcFlowVO>> modifiedRows);

}

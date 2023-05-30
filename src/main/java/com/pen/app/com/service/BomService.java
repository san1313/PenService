package com.pen.app.com.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.vo.BomVO;
import com.pen.app.com.vo.ItemVO;

public interface BomService {
	// 제품의 BOM 조회
	List<BomVO> getBomList(String itemCode);

	// 제품의 사용공정 조회
	List<Map<String, String>> getBomProcList(String itemCode);

	// 자재 및 반제품 조회
	List<ItemVO> getBomMatList();
	
	// 이름으로 자재 및 반제품 조회
	List<ItemVO> getBomMatWithName(String itemName);
	
	// 저장 버튼 동작
	ToastUiResponseDTO modifyBomList(Map<String, List<BomVO>> modifiedRows);
}

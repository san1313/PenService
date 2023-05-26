package com.pen.app.com.mapper;

import java.util.List;
import java.util.Map;

public interface ProcFlowMapper {
	// 제품 리스트 조회
	List<Map<String, String>> getFlowItemList();
	
	// 제품 이름으로 조회
	List<Map<String, String>> getFlowItemListWithName(String itemName);
}

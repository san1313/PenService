package com.pen.app.com.mapper;

import java.util.List;
import java.util.Map;

import com.pen.app.com.vo.ProcFlowVO;

public interface ProcFlowMapper {
	// 제품 리스트 조회
	List<Map<String, String>> getFlowItemList();
	
	// 제품 이름으로 조회
	List<Map<String, String>> getFlowItemListWithName(String itemName);
	
	// 공정 흐름 리스트 조회
	List<ProcFlowVO> getFlowList(String itemCode);
	
	// 공정흐름 정보수정
	int modifyFlowList(List<ProcFlowVO> list);
	
	// 공정흐름 추가
	int insertFlowList(List<ProcFlowVO> list);
	
	// 공정흐름 삭제
	int deleteFlowList(List<ProcFlowVO> list);
}

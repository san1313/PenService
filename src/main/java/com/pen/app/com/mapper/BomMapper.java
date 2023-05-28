package com.pen.app.com.mapper;

import java.util.List;
import java.util.Map;

import com.pen.app.com.vo.BomVO;
import com.pen.app.com.vo.ItemVO;

public interface BomMapper {
	// 제품의 BOM 조회
	List<BomVO> getBomList(String itemCode);

	// 제품의 사용공정 조회
	List<Map<String, String>> getBomProcList(String itemCode);

	// 자재 및 반제품 조회
	List<ItemVO> getBomMatList();
	
	// 이름으로 자재 및 반제품 조회
	List<ItemVO> getBomMatWithName(String itemName);
	
	// BOM 정보수정
	int modifyBomList(List<BomVO> list);
	
	// BOM 추가
	int insertBomList(List<BomVO> list);
	
	// BOM 삭제
	int deleteBomList(List<BomVO> list);
}

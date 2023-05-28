package com.pen.app.qip.mapper;

import java.util.List;

import com.pen.app.qip.vo.TestItemVO;
import com.pen.app.qip.vo.TestPerItemVO;

public interface TestPerItemMapper {
	// 검사항목 리스트 조회
	List<TestItemVO> getTestItemList();
	
	// 이름으로 검사항목 조회
	List<TestItemVO> getTestItemWithName(String itemName);
	
	// 항목별 검사목록 조회
	List<TestPerItemVO> getTPIList(String itemCode);
	
	// 검사코드 정보수정
	int modifyTPI(List<TestPerItemVO> list);
	
	// 검사코드 추가
	int insertTPI(List<TestPerItemVO> list);
	
	// 검사코드 삭제
	int deleteTPI(List<TestPerItemVO> list);
}

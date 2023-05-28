package com.pen.app.qip.mapper;

import java.util.List;

import com.pen.app.qip.vo.TestCodeVO;

public interface TestCodeMapper {
	// 검사코드 리스트 조회
	List<TestCodeVO> getTCodeList();
	
	// 이름으로 검사코드 조회
	List<TestCodeVO> getTCodeWithName(String testName);
	
	// 다음 검사코드 가져오기
	String getTestCode();
	
	// 검사코드 정보수정
	int modifyTCode(List<TestCodeVO> list);
	
	// 검사코드 추가
	int insertTCode(List<TestCodeVO> list);
	
	// 검사코드 삭제
	int deleteTCode(List<TestCodeVO> list);
}

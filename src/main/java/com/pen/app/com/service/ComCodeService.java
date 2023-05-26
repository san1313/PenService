package com.pen.app.com.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.iCodeVO;

public interface ComCodeService {
	// 공통코드 리스트 조회
	List<ComCodeVO> getComCodeList();
	
	//공통코드 이름으로 조회
	List<ComCodeVO> getComCodeWithName(String codeName);
	
	// 세부코드 리스트 조회
	List<ComCodeVO> getInnerCodeList(String comCode);
	
	// 저장 버튼 동작
	ToastUiResponseDTO modifyICodeList(Map<String, List<iCodeVO>> modifiedRows);

}

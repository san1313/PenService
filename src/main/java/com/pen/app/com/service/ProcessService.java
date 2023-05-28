package com.pen.app.com.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.vo.ProcessVO;

public interface ProcessService {
	// 공정 구분 리스트 받아오기
	List<String> getProcTypeList();

	// 공정 리스트 받아오기
	List<ProcessVO> getProcList();

	// 공정 구분으로 리스트 조회
	List<ProcessVO> getProcWithType(String procType);
	
	// 다음 공정코드 조회
	String getProcCode();
	
	// 저장 버튼 동작
	ToastUiResponseDTO modifyProcList(Map<String, List<ProcessVO>> modifiedRows);

}

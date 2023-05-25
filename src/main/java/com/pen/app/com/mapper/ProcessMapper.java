package com.pen.app.com.mapper;

import java.util.List;
import java.util.Map;

import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;
import com.pen.app.com.vo.ProcessVO;

public interface ProcessMapper {
	// 공정 구분 리스트 받아오기
	List<String> getProcTypeList();
	
	// 공정 리스트 받아오기
	List<ProcessVO> getProcList();
	
	// 공정 구분으로 리스트 조회
	List<ProcessVO> getProcWithType(String procType);
	
	// 다음 공정코드 조회
	String getProcCode();
	
	// 공정 정보수정
	int modifyProcList(List<ProcessVO> list);
	
	// 공정 추가
	int insertProcList(List<ProcessVO> list);
	
	// 공정 삭제
	int deleteProcList(List<ProcessVO> list);
}

package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.iCodeVO;

public interface comCodeMapper {
	// 공통코드 리스트 조회
	List<ComCodeVO> getComCodeList();

	// 공통코드 이름으로 조회
	List<ComCodeVO> getComCodeWithName(String codeName);

	// 세부코드 리스트 조회
	List<ComCodeVO> getInnerCodeList(String comCode);

	// 세부코드 정보수정
	int modifyICodeList(List<iCodeVO> list);

	// 세부코드 추가
	int insertICodeList(List<iCodeVO> list);

	// 세부코드 삭제
	int deleteICodeList(List<iCodeVO> list);
}

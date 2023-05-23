package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;
import com.pen.app.com.vo.UserVO;

public interface comCodeMapper {
	//공통코드 리스트 조회
	List<ComCodeVO> getComCodeList();
	List<ComCodeVO> getComCodeWithName(String codeName);
	List<ComCodeVO> getInnerCodeList(String comCode);
}

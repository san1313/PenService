package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AccountVO;

public interface AccountMapper {
	//거래처 리스트 조회
	List<AccountVO> getAccountList();
	List<String> getAccTypeList();
	String getAccCode();
	int modifyAccList(List<AccountVO> list);
	int insertAccList(List<AccountVO> list);
	int deleteAccList(List<AccountVO> list);
}

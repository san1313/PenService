package com.pen.app.com.service;

import java.util.List;

import com.pen.app.com.vo.AccountVO;

public interface AccountService {
	List<AccountVO> getAccountList();
	List<String> getAccTypeList();
	String getAccCode();
	boolean modifyAccList(List<AccountVO> list);
	boolean insertAccList(List<AccountVO> list);
	boolean deleteAccList(List<AccountVO> list);
}

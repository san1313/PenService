package com.pen.app.com.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;

public interface AccountService {
	List<AccountVO> getAccountList();
	List<AccountVO> getAccListWithType(String accType);
	List<String> getAccTypeList();
	String getAccCode();
	boolean modifyAccList(List<AccountVO> list);
	boolean insertAccList(List<AccountVO> list);
	boolean deleteAccList(List<AccountVO> list);
	List<ItemVO> getItemListWithAccCode(String accCode);
	List<AccountVO> searchAccList(String accName, String accType);
}

package com.pen.app.com.mapper;

import java.util.List;
import java.util.Map;

import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;

public interface AccountMapper {
	//거래처 리스트 조회
	List<AccountVO> getAccountList();
	List<String> getAccTypeList();
	List<AccountVO> getAccListWithType(String accType);
	String getAccCode();
	int modifyAccList(List<AccountVO> list);
	int insertAccList(List<AccountVO> list);
	int deleteAccList(List<AccountVO> list);
	List<ItemVO> getItemListWithAccCode(String accCode);
	List<AccountVO> searchAccList(Map<String, String> map);
}

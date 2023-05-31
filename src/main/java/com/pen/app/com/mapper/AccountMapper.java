package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;

public interface AccountMapper {
	// 거래처 리스트 조회
	List<AccountVO> getAccountList();

	List<String> getAccTypeList();

	List<AccountVO> getAccListWithType(String accType);

	String getAccCode();

	int modifyAccList(List<AccountVO> list);

	int insertAccList(List<AccountVO> list);

	int deleteAccList(List<AccountVO> list);

	List<ItemVO> getItemListWithAccCode(String accCode);

	List<AccountVO> searchAccList(String accName, String accType);

	// 거래처 리스트 조회(동적쿼리로)
	List<AccountVO> getAccList(String accName);

	// 거래처별 거래품목 가져오기
	List<ItemVO> getAccItemList(String accCode);

	// 모든 자재, 완제품 가져오기
	List<ItemVO> getAllAccItemList(String itemName, String accType);
	
	// 저장 버튼 동작 시작
	int modifyAccItemList(List<ItemVO> list);

	int insertAccItemList(List<ItemVO> list);

	int deleteAccItemList(List<ItemVO> list);
	// 저장 버튼 동작 끝
	
}

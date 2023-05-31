package com.pen.app.com.service;

import java.util.List;
import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;
import com.pen.app.qip.vo.TestPerItemVO;

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

	// 거래처 리스트 조회(동적쿼리로)
	List<AccountVO> getAccList(String accName);

	// 거래처별 거래품목 가져오기
	List<ItemVO> getAccItemList(String accCode);
	
	// 모든 자재, 완제품 가져오기
	List<ItemVO> getAllAccItemList(String itemName, String accType);
	
	// 저장 버튼 동작
	ToastUiResponseDTO modifyAccItemList(Map<String, List<ItemVO>> modifiedRows);
}

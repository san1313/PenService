package com.pen.app.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.mapper.AccountMapper;
import com.pen.app.com.service.AccountService;
import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;
import com.pen.app.qip.vo.TestPerItemVO;

@Service
public class AccountServiceImpl implements AccountService {

@Autowired AccountMapper mapper;
@Override
	public List<AccountVO> getAccountList() {
		
		return mapper.getAccountList();
	}
	@Override
		public List<String> getAccTypeList() {
			
			return mapper.getAccTypeList();
		}
	
	@Override
		public String getAccCode() {
			
			return mapper.getAccCode();
		}
	public boolean modifyAccList(List<AccountVO> list) {
		
		return mapper.modifyAccList(list)>0;
	}
	@Override
		public boolean insertAccList(List<AccountVO> list) {
			
			return mapper.insertAccList(list)>0;
		}
	@Override
		public boolean deleteAccList(List<AccountVO> list) {
			
			return mapper.deleteAccList(list)>0;
		}
	@Override
		public List<ItemVO> getItemListWithAccCode(String accCode) {
			
			return mapper.getItemListWithAccCode(accCode);
		}
	@Override
		public List<AccountVO> searchAccList(String accName, String accType) {
			
			return mapper.searchAccList(accName, accType);
		}
	@Override
		public List<AccountVO> getAccListWithType(String accType) {
			
			return mapper.getAccListWithType(accType);
		}
	@Override
		public List<AccountVO> getAccList(String accName) {
			
			return mapper.getAccList(accName);
		}
	@Override
		public List<ItemVO> getAccItemList(String accCode) {
			
			return mapper.getAccItemList(accCode);
		}
	@Override
		public List<ItemVO> getAllAccItemList(String itemName, String accType) {
			
			return mapper.getAllAccItemList(itemName, accType);
		}
	@Override
		public ToastUiResponseDTO modifyAccItemList(Map<String, List<ItemVO>> modifiedRows) {
		String result = "Success";
		List<ItemVO> updatedRows = modifiedRows.get("updatedRows");
		List<ItemVO> createdRows = modifiedRows.get("createdRows");
		List<ItemVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyAccItemList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertAccItemList(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteAccItemList(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
		}
}

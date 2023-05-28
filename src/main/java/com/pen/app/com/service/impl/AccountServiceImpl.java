package com.pen.app.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.mapper.AccountMapper;
import com.pen.app.com.service.AccountService;
import com.pen.app.com.vo.AccountVO;
import com.pen.app.com.vo.ItemVO;

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
}

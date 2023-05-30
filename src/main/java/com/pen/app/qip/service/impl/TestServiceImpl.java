package com.pen.app.qip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.qip.mapper.TestMapper;
import com.pen.app.qip.service.TestService;
import com.pen.app.qip.vo.ItemTestDTO;
import com.pen.app.qip.vo.TestExpModalVO;
import com.pen.app.qip.vo.TestMatModalVO;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	TestMapper mapper;
	
	@Override
	public List<TestMatModalVO> matTestList() {
		
		return mapper.matTestList();
	}
	
	@Override
	public List<TestExpModalVO> expTestList() {
		
		return mapper.expTestList();
	}
	
	@Override
	public boolean insertTest(ItemTestDTO dto) {
		if(dto.getDetails() == null) return false;
		if(dto.getResult() == null) return false;
		
		switch (dto.getType()) {
		case "mat":
			mapper.insertMatTest(dto.getResult(), dto.getDetails());
			break;
		case "item":
			break;
		case "exp":
			mapper.insertExpTest(dto.getResult(), dto.getDetails());
			break;
		}
		return true;
	}
}

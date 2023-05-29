package com.pen.app.qip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.qip.mapper.TestMapper;
import com.pen.app.qip.service.TestService;
import com.pen.app.qip.vo.TestMatModalVO;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	TestMapper mapper;
	
	@Override
	public List<TestMatModalVO> matTestList() {
		
		return mapper.matTestList();
	}
}

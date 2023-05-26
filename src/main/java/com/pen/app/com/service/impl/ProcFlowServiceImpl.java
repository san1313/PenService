package com.pen.app.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.mapper.ProcFlowMapper;
import com.pen.app.com.service.ProcFlowService;

@Service
public class ProcFlowServiceImpl implements ProcFlowService {

	@Autowired
	ProcFlowMapper mapper;

	@Override
	public List<Map<String, String>> getFlowItemList() {
		
		return mapper.getFlowItemList();
	}
	@Override
	public List<Map<String, String>> getFlowItemListWithName(String itemName) {
		
		return mapper.getFlowItemListWithName(itemName);
	}
}

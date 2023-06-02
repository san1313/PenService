package com.pen.app.qip.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.qip.mapper.TestViewMapper;
import com.pen.app.qip.service.TestViewService;

@Service
public class TestViewServiceImpl implements TestViewService{
	@Autowired
	TestViewMapper mapper;
	
	@Override
	public ToastUiResponseDTO getMatView(Map<String, String> map) {
		System.err.println(map);
		return new ToastUiResponseDTO(mapper.getMatView(map));
	}
	
	@Override
	public ToastUiResponseDTO getItemView(Map<String, String> map) {
		
		return new ToastUiResponseDTO(mapper.getItemView(map));
	}
	
	@Override
	public ToastUiResponseDTO getExpView(Map<String, String> map) {
		
		return new ToastUiResponseDTO(mapper.getExpView(map));
	}
}

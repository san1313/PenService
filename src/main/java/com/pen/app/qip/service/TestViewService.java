package com.pen.app.qip.service;

import java.util.Map;

import com.pen.app.com.dto.ToastUiResponseDTO;

public interface TestViewService {
	ToastUiResponseDTO getMatView(Map<String, String> map);
	
	ToastUiResponseDTO getItemView(Map<String, String> map);

	ToastUiResponseDTO getExpView(Map<String, String> map);
}

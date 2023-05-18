package com.pen.app.com.dto;

import java.util.HashMap;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToastUiResponseDTO {
	private boolean result;
	private HashMap<String, Object> data;
	
	public ToastUiResponseDTO(Object data){
		this.result = !data.equals("Fail");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("contents", data);
		this.data = map;
	}
}

package com.pen.app.qip.mapper;

import java.util.List;
import java.util.Map;

import com.pen.app.qip.vo.TestViewVO;

public interface TestViewMapper {
	List<TestViewVO> getMatView(Map<String, String> map);
	
	List<TestViewVO> getItemView(Map<String, String> map);

	List<TestViewVO> getExpView(Map<String, String> map);

	List<TestViewVO> getDetailView(String qipCode);
}

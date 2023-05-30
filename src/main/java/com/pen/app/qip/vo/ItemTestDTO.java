package com.pen.app.qip.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ItemTestDTO {
	List<TestPerItemVO> details;
	TestResultVO result;
	String type;
}

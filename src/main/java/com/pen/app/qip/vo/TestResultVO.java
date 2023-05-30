package com.pen.app.qip.vo;

import lombok.Data;

@Data
public class TestResultVO {
	String targetCode;
	String testDate;
	String empNum;
	int testNum;
	int testTnumDef;
	int testTnumPass;
}

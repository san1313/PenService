package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacConfirmVO {
	
	/*
	CONFIRM_CODE VARCHAR2(15) NOT NULL,
	CONFIRM_DATE DATE NOT NULL,
	CONFIRM_CATEGORY VARCHAR2(50) NOT NULL,
	ACTION_HISTORY VARCHAR2(100) NOT NULL,
	DECISION VARCHAR2(50) NOT NULL,
	FAC_NAME VARCHAR2(100) NOT NULL,
	NEXT_CONFIRM_DATE DATE	NULL,
	CONFIRM_TIME DATE NOT NULL,
	EMP_NUM	VARCHAR2(15) NOT NULL,
	FAC_CODE VARCHAR2(15) NOT NULL,
	CONFIRM_ISSUE VARCHAR2(50) NOT NULL
	 * */
	String confirm_code;
	String fac_code;
	String downTime_reason;
	String downTime_start_day;
	String start_time;
	String downTime_end_day;
	String end_time;
	String reason_explain;
	String emp_num;
}

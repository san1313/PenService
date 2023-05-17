package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacDownTimeVO {
	
	/*
	DOWNTIME_CODE VARCHAR2(15) NOT NULL,
	FAC_CODE VARCHAR2(15) NOT NULL,
	DOWNTIME_REASON	VARCHAR2(50) NOT NULL,
	START_TIME DATE	NOT NULL,
	END_TIME DATE NOT NULL,
	DOWNTIME_START_DAY DATE	NOT NULL,
	DOWNTIME_END_DAY DATE NOT NULL,
	EMP_NUM	VARCHAR2(15) NOT NULL,
	REASON_EXPLAIN VARCHAR2(400) NOT NULL
	 * */
	String downTime_code;
	String fac_code;
	String downTime_reason;
	String downTime_start_day;
	String start_time;
	String downTime_end_day;
	String end_time;
	String reason_explain;
	String emp_num;
}

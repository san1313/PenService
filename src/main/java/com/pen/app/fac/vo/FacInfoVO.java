package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacInfoVO {
	
	/*
	CREATE TABLE FAC_INFO (
   FAC_CODE VARCHAR2(15) NOT NULL,
   FAC_NAME VARCHAR2(50) NOT NULL,
   INSTALL_DATE DATE NOT NULL,
   TEMP_MIN NUMBER NOT NULL,
   TEMP_MAX NUMBER NOT NULL,
   MAKER_NAME VARCHAR2(50) NOT NULL,
   CHECK_CYCLE NUMBER NOT NULL,
   OPERATE_CHECK VARCHAR2(10) NOT NULL,
   EMP_NUM VARCHAR2(15) NOT NULL
);
	 * */
	String facCode;
	String facName;
	String installDate;
	String tempMin;
	String tempMax;
	String makerName;
	String checkCycle;
	String operateCheck;
	String EmpNum;
}

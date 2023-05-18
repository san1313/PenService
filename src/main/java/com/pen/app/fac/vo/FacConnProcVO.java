package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacConnProcVO {
	
	/*
	FAC_PROC VARCHAR(255) NOT NULL,
	FAC_CODE VARCHAR2(15) NOT NULL,
	PROC_CODE VARCHAR2(15) NOT NULL
	 * */
	String facProc;
	String facCode;
	String procCode;
	String procName;
}

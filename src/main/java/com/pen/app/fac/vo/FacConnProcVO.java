package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacConnProcVO {
	
	/*
	FAC_PROC VARCHAR(255) NOT NULL,
	FAC_CODE VARCHAR2(15) NOT NULL,
	PROC_CODE VARCHAR2(15) NOT NULL
	 * */
	String procCode;//공정코드
	String facCode;//설비코드
	String facProc;//공정과 설비 연결테이블코드
	
	String procName;//공정이름
	String procType; //공정타입
	String procDetail; //공정설명
}

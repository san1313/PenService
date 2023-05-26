package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacConnProcVO {
	
	/*
	FAC_PROC VARCHAR(255) NOT NULL,
	FAC_CODE VARCHAR2(15) NOT NULL,
	PROC_CODE VARCHAR2(15) NOT NULL
	 * */
	
	String facProc;//공정과설비 연결하는 고유번호
	String procCode;//공정코드
	String facCode;//설비코드

	//COM_CODE_PROC 테이블 필드
	String procName;//공정이름
	String procType; //공정타입
	String procDetail; //공정설명
}

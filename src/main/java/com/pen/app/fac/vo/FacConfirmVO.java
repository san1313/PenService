package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacConfirmVO {

	String confirmCode; //점검코드

	String confirmCategory; //점검구분
	String actionHistory; //조치내역
	String confirmIssue; //점검사항
	String confirmDate; //점검일시
	String decision; //판정 
	
	String empNum; //담당자
	String facCode; //설비코드
	String facName; //설비명
	
	String confirmday1; //점검일자1
	String confirmday2; //점검일자2
	
	String searchDiv;
	String searchName;
	
}	

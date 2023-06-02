package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacInfoVO {
	
	String facCode; //설비코드(pk)

	String facName; //설비명
	String installDate; //입고날짜
	String tempMin; //최저온도
	String tempMax; //최고온도
	String makerName; //제조업체
	String checkCycle; //점검주기
	String operateCheck; //가동유무
	String EmpNum; //사원번호
	
	
	String facProc;
	String procCode;
	//한 설비에 연결된 공정 데이터들
	
	//COM_CODE_PROC 테이블 필드
	String procName;//공정이름
	String procType; //공정타입
	String procDetail; //공정설명
	
	String searchDiv; //조건검색구분
	String searchName; //조건검색명
}

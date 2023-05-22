package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacInfoVO {
	
	String facCode; //설비코드
	String facName; //설비명
	String installDate; //입고날짜
	String tempMin; //최저온도
	String tempMax; //최고온도
	String makerName; //제조업체
	String checkCycle; //점검주기
	String operateCheck; //가동유무
	String EmpNum; //사원번호
	
	String procCode; //공정코드
	String procName; //공정명
	String procType; //공정타입
	String procDetail; //공정설명
	
	
}

package com.pen.app.fac.vo;

import java.util.List;

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
	

	
	List<FacConnProcVO> list;//한 설비에 연결된 공정 데이터들
}

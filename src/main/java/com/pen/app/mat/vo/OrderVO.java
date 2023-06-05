package com.pen.app.mat.vo;


import lombok.Data;

@Data
public class OrderVO { //발주
	
	String matOrdernum; //발주번호
	String accCode; //거래처코드
	String matOrdername; //발주명
	String matOrderdate; //발주일자
	String matOrderdate1; //발주일자
	String matCharger; //담당자
	String vo;
	
	String matDtaordcode; //발주상세코드
	String matCode; //자재코드
	String matName; //자재명
	long matOrderQy; //발주량
	long matUntpc; //단가
	long matTotamt; //총금액
	String matReqdate; //납기요청일

	
	String accName; //거래처명
	String empNum; //사원번호
	long testNumMat;
	long testTnumDef;
	long testTnumPass;
	
	String accType;
	String accItem;
}

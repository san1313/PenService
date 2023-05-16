package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO { //발주
	
	String matOrdernum; //발주번호
	String matCharger; //담당자
	String matOrdername; //발주명
	String accCode; //거래처코드
	
	int num;
	int matUntpc; //단가
	int matOrderQy; //발주량
	int matTotamt; //총금액
	String matUnit; //단위
	String matCode; //자재코드
	String matName; //자재명
	Date matOrderdate; //발주일자	
	Date matReqdate; //납기요청일

}

package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HoldVO { //홀드해제
	
	int num;
	String matUnit; //단위
	int matBholding; //해제 전 수량
	int matAholding; //해제 후 수량
	String accName; //거래처명
	Date matRlsdate; //해제일자
	String matLot;
	String matHoldresn; //해제사유
	
	String matName; //자재명
	int matQnt; //재고량
	Date matCstdy; //보관기한
	String matCode; //자재코드
	String matOrdernum; //발주번호
	
}

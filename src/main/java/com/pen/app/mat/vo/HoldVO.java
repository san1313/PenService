package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HoldVO { //홀드해제
	
	int num;
	String matUnit; //단위
	Date matRlsdate; //해제일자
	String matLot;
	String matHoldresn; //해제사유
	
	String matName; //자재명
	int matQnt; //재고량
	String matCode; //자재코드
	
}

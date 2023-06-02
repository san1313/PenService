package com.pen.app.mat.vo;

import lombok.Data;

@Data
public class HoldVO { //홀드해제
	
	int num;
	String matUnit; //단위
	String matRlsdate; //해제일자
	String matRlsdate1; //해제일자
	String matLot;
	String matHoldresn; //해제사유
	
	String matName; //자재명
	int matQnt; //재고량
	String matCode; //자재코드
	
	int matRlsqnt; //해제수량
	int bmatQnt; //해제전수량
	
	
}

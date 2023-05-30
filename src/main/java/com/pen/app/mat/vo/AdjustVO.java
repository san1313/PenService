package com.pen.app.mat.vo;


import lombok.Data;

@Data
public class AdjustVO { //조정
	int num;
	String matName;
	String matCode;
	String matUnit;
	int matMdatqnt; //자재조정수량
	String matMdatdate; //조정날짜
	String matMdatdate1; //조정날짜
	String matMdatresn; //조정사유
	String matLot;
	String matCharger; //담당자
	String matMdev; //조정구분
	int matQnt;//재고량
	String matBcncname; //거래처명
	int matWrhqy;
	int matDlivyqnt;
	String matWrhst; //상태
	int bmatQnt; //처리 전 재고량
	String vo;

	
}

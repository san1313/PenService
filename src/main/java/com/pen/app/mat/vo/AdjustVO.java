package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AdjustVO { //조정
	int num;
	String matName;
	String matUnit;
	int matFroqnt; //처리 전 수량
	int matProcessqnt; //처리 후 수량
	int matMdatqnt; //자재조정수량
	Date matMdatdate; //조정날짜
	String matMdatresn; //조정사유
	String matLot;
	
	int matQnt;//재고량
	
}

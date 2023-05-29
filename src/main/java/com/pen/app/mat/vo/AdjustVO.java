package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AdjustVO { //조정
	int num;
	String matName;
	String matCode;
	String matUnit;
	int matMdatqnt; //자재조정수량
	Date matMdatdate; //조정날짜
	String matMdatresn; //조정사유
	String matLot;
	String matCharger; //담당자
	String matMdev; //조정구분
	int matQnt;//재고량
	String matBcncname; //거래처명
	int matWrhqy;
	
}

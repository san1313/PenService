package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DisposeResultVO {//폐기처리결과

	int num;
	String matLot;
	String matUnit;
	int matBtestQnt; //검사 전 수량
	int matAtestQnt; //검사 후 수량
	int matSta; //폐기율
	
	String matName;
	int matQnt; //재고량
	Date matCstdy; //보관기한
	String matCode;
	String matOrdernum;
	String matState; //상태
}

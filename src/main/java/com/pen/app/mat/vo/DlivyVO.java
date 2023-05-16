package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DlivyVO { //출고
	
	String matDlivycode; //자재출고코드
	String matCode; //자재코드
	String matName; //자재명
	Date matDlivydate; //출고일시
	int matDlivyqnt; //출고량
	Date matCstdy; //보관기한
	String matUnit; //단위
	String matLot; //lot번호
	
	String semiDlivyCode; //반제품출고코드
	String semiCode; //반제품코드
	String semiName; //반제품명
	Date matSemidlivydate; //출고일시
	int matSemiDlivyqnt; //출고량
	String semiLot; //반제품lot번호

	String matOrdernum;
	int matQnt; //재고량
	
	int matSemiqnt; //재고량
	
}

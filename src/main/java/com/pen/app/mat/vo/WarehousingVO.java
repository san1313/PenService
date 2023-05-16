package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class WarehousingVO { //입고
	
	int num;
	String matName; //자재명
	String matBcncname; //거래처명
	int matWrhqy; //입고량
	Date matOrderdate; //발주일자
	Date matWrhdate; //입고일자
	Date matCstdy; //보관기한
	String matLot; //lot번호
	String matOrdernum; //발주번호
	
	int matQnt; //재고량
	String matState; // 상태
	
	
}

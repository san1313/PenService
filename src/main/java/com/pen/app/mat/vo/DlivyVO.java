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
	String matUnit; //단위
	String matContent; //출고내용
	String matLot; //자재lot번호
	String semiLot;//반제품lot번호
	String matCate;//자재종류
	
	
	String semiName; //반제품명

	int matQnt; //자재재고량
	
	int matSemiqnt; //반제품재고량
	
}

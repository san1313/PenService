package com.pen.app.mat.vo;


import lombok.Data;

@Data
public class DlivyVO { //출고
	
	String matDlivycode; //자재출고코드
	String matCate;//자재구분
	String matCode; //자재코드/반제품코드
	String matName; //자재명/반제품명
	String semiLot;//반제품lot번호
	String matLot; //자재lot번호
	String matDlivydate; //출고일시
	String matDlivydate1; //출고일시
	int matDlivyqnt; //출고량
	String matUnit; //단위
	String matContent; //출고내용
	
	
}

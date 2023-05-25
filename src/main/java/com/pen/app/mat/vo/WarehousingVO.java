package com.pen.app.mat.vo;


import lombok.Data;

@Data
public class WarehousingVO { //입고
	
	int matWrhnum; //입고번호
	int qipCodeListMat;//자재내역번호
	String matLot; //lot번호
	String matBcncname; //거래처명
	int matWrhqy; //입고량
	String matWrhdate; //입고일자
	String matWrhdate1; //입고일자
	String matWrhst; //입고상태
	
	String matDtaordcode; //자재내역번호
	String testDate; //검사일자
	String empNum; //사원번호
	String testNumMat; //검사수량
	String testTnumDef; //총불량량
	int testTnumPass; //총합격량
	String matCode;
	String matName;
	String matOrdernum;
	String accCode; //거래처코드
	
	String matOrderdate; //발주일자
	
	int matQnt; //재고량
	String matState; //상태
	String matKeepdate; //현재보관기한
	
		
	String qipCodeListProd; //제품검사내역코드
	String prcsCode; //생산lot
	String TestDate; //검사일자
	int testNumProd; //검사수량
	int testNumDef; //총불량량
	int procOrder; //공정순서
	
	String vo;

	
}

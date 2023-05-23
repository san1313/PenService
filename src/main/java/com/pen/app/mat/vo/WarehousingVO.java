package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class WarehousingVO { //입고
	
	int matWrhnum; //입고번호
	int qipNumListMat;//자재내역번호
	String matLot; //lot번호
	String matBcncname; //거래처명
	int matWrhqy; //입고량
	Date matWrhdate; //입고일자
	String matWrhst; //입고상태
	
	String matDtaordcode; //자재내역번호
	Date testDate; //검사일자
	String empNum; //사원번호
	String testNumMat; //검사수량
	String testTnumDef; //총불량량
	String testTnumPass; //총합격량
	String matCode;
	String matName;
	String matOrdernum;
	String accCode; //거래처코드
	
	Date matOrderdate; //발주일자
	
	int matQnt; //재고량
	String matState; //상태
	Date matKeepdate; //현재보관기한
	
	
	
}

package com.pen.app.bns.vo;

import lombok.Data;

@Data
public class BnsStoreVO {
	
	//입고 전
	String prcsCode;
	String prodCode;
	long cnt;
	String prdtDate;
	String prdtDate1;
	String prdtUnit;
	String qipCodeListProd;
	String prdtState;
	//입고후 
	String prdtLot; //생산Lot번호
	String prdtNm; //완제품명
	long bnsStoreQuan; //입고량
	String bnsStoreDate; //입고일자
	String bnsStoreDate1; //입고일자
	String empNum; //사원번호
	String empName; //사원명
	String bnsStoreNote; //비고
}

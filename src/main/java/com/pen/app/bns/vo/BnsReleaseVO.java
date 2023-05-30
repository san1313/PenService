package com.pen.app.bns.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BnsReleaseVO {

	
	String ordDetCode;
	String ordCode;
	String accCode;
	String accName;
	String prodCode;
	String prodName;
	String prdtNm;
	int ordDetQuan; //주문서 주문량
	String ordDueDate;
	String ordDetRelease; //납기일자
	String prdtLot;
	int contDetQuan; //주문량
	int bnsReleaseQuan; //출고량
	int bnsStoreQuan; //재고량
	String bnsStoreDate; //입고일자
	String contDetCode;
	String contCode;
	String contDetRelease; //납기일자
	String bnsReleaseDate; //출고일자
	String empNum;
	String empName; //담당자명
	String bnsReleaseNote; //출고 비고
	String sys;
}

package com.pen.app.bns.vo;



import lombok.Data;

@Data
public class BnsReleaseVO {

	
	String ordDetCode;
	String ordCode;
	String accCode;
	String accName;
	String prodCode;
	String prdtCode;
	String prodName;
	String prdtNm;
	int ordDetQuan; //주문서 주문량
	String ordDueDate;
	String ordDueDate1;
	String ordDetRelease; //납기일자
	String prdtLot; //로트번호
	int contDetQuan; //주문량
	int bnsReleaseQuan; //출고량
	String bnsStoreDate; //입고일자
	String contDetCode;
	String contCode;
	String contDetRelease; //납기일자
	String contDetRelease1; //납기일자1
	String bnsReleaseDate; //출고일자
	String bnsReleaseDate1; //출고일자1
	String empNum;
	String empName; //담당자명
	String bnsReleaseNote; //출고 비고
	String sys;
	int cnt; //재고량
	int needContDetQuan;
	int contReqQuan; //계약서 필요 재고량
	int ordReqQuan; //주문서 필요 재고량
	String bnsReleaseCode; //주문코드
}

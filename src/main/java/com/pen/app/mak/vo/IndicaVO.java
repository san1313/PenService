package com.pen.app.mak.vo;

import lombok.Data;

@Data
public class IndicaVO {
	//홀드
	String rscCode;
	String indicaCode;
	String matLot;
	String semiLot;
	int cnt;
	String holdDate;
	String holdState;
	//공정실적
	String prcsCode;
	String prodNm;
	String procCode;
	String facCode;
	String empNum;
	String prodCnt;
	String prcsFrDate;
	String prcsFlDate;
	String prcsState;
	//완제품
	String prdtLot;
	String prodCode;
	String prdtNm;
	String prdtDate;
	String prdtUnit;
	String qipCodeListProd;
	//제품검사
	String testType;
	String testDate;
	int testNumProd;
	int testTnumDef;
	int testTnumPass;
	int procOrder;
	//자재
	String matCode;
	String matName;
	int matQnt;
	String matState;
	String matKeepdate;
	
	
	//생산지시서
	String indicaNm; 
	String indicaDate;         
	String prodDev;
	int ordrQnt;    
	String sDate;         
	String clsDate;         
	String indicaState; 
	String pdCode;
	
	int reQnt;
	
	//공통bom flow
	int lev;
	String parentCode;
	String bomMatType;
	String bomProdCode;
	String bomProdName;
	String bomMatUnit;
	int bomMatUsage;
	String procType;
	String procName;
}

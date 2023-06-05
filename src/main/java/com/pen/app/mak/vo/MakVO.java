package com.pen.app.mak.vo;

import lombok.Data;

@Data
public class MakVO{
	//생산지시서
	String indicaCode; 
	String indicaNm; 
	String empNum; 
	String indicaDate;         
	String prodDev;
	String prodCode;
	int ordrQnt;    
	String stDate;       
	String clsDate;         
	String indicaState; 
	String pdCode;
	
	int count;
	int reQnt;
	
	//공통bom flow
	String prodNm;
	String procCode;
	int lev;
	String parentCode;
	String bomMatType;
	String bomProdCode;
	String bomProdName;
	String bomMatUnit;
	int bomMatUsage;
	String procType;
	String procName;
	String prodName;
	//설비
	String facCode; 
	String facName; 
	String operateCheck; 
	int procOrder;
		
	//생산 BOM
	 int makBomCode;
	 int makFlowCode;
	 int makStep;
	 int amount;
	 String planIndica;
	 
	 //생산공정
	 int makFlowStep;
	 
	String planNm;
	String planCode;
	String planSdate;
	String planClsdate;
	
	//홀드
	String rscCode;
	String matLot;
	String semiLot;
	int cnt;
	String holdDate;
	String holdState;
	//자재
	String matCode;
	String matName;
	int matQnt;
	String matState;
	
	//공정실적
	String prcsCode;
	int prodCnt;
	String prcsFrDate;
	String prcsFlDate;
	String prcsState;
	
	//완제품
	String prdtLot;
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
	//자재
	String matKeepdate;
	
	//유저
	String empName;
	String empId;
	String empPw;
	String empTel;
	String hireDate;
	String authCode;
	String authName;
	
	int makUsage;
	String resultCode;
	String semiName;
}

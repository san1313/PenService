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
	String sDate;         
	String clsDate;         
	String indicaState; 
	String pdCode;
	
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
	
	
	
}

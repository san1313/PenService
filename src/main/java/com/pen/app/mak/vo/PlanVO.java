package com.pen.app.mak.vo;

import lombok.Data;


@Data
public class PlanVO {
	//상세계획
	String pdCode; 
	String planState; 
	int planQnt;    
	int priority;    
	String planClsdate;
	String planSdate;
	String pdProdCode;
	//계획
	String planCode;
	String planNm;
	String planDate;         
	String planType;  
	String makEmpNum;
	
	//연결
	int connectCode;        
	String ordDetCode; 
	String contDetCode; 
	
	//계약 상세
	String contCode;  
	String prodCode;  
	String prodName;  
	int contDetPrice;        
	int contDetQuan;        
	String contDetRelease;          
	String contDetProgress; 

	//계약
	String accCode;  
	String accName;  
	String contDate;          
	String contDueDate;          
	String contProgress; 
	String contNote; 
	String empNum;  

	//계약명
	String contNm;
	//주문
	String ordCode;  
	String ordDate;          
	String ordDueDate;          
	String ordProgress; 
	String ordNote; 

	//주문 상세
	int ordDetPrice;        
	int ordDetQuan;        
	String ordDetProgress; 

	int count;
	
	
}
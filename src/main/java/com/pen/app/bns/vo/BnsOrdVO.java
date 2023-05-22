package com.pen.app.bns.vo;

import lombok.Data;

@Data
public class BnsOrdVO {
	String ordCode;
	String accCode;
	String accName;
	String ordDate;
	String ordDueDate;
	String ordProgress;
	String empNum;
	String ordNote;
	
	String ordDetCode;
	String prodCode;
	String prodName;
	int ordDetPrice;
	int ordDetQuan;
	int ordDetTotPrice;
	String ordDetProgress;
	
	String empName;
	
	
}
	
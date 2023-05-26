package com.pen.app.bns.vo;

import lombok.Data;

@Data
public class BnsContVO {
	String contCode;
	String accCode;
	String accName;
	String contDate;
	String contDueDate;
	String contProgress;
	String contNote;
	String empNum;
	String contStartDate;
	String empName;
	
	String contDetCode;
	String prodCode;
	String prodName;
	int contDetPrice;
	int contDetQuan;
	String contDetRelease;
	String contDetProgress;
	int contDetTotPrice;
}

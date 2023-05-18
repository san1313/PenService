package com.pen.app.bns.vo;

import java.util.Date;

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
}
	
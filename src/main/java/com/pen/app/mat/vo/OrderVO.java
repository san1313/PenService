package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	String matOrdernum;
	String matCode;
	String matName;
	Date matOrderdate;
	String matCharger;
	String matOrdername;
	String accCode;
}

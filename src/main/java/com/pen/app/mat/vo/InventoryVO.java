package com.pen.app.mat.vo;

import lombok.Data;

@Data
public class InventoryVO {
	String matCode;
	String matName;
	String matQnt;
	String matLot;
	String keepdate;//보관기한
	String matSfst; //안전재고
	String matBcncname; //거래처명
	String matState; //상태
	
}

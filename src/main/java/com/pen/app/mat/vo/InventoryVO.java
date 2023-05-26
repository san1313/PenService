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
	String matdef;//안전재고 부족분
	String matBcncname; //거래처명
	String matState; //상태
	String matRlsqnt; //홀드해제수량량
	String cnt; //홀드수량
	String matQntt; //실재고량
	
}

package com.pen.app.mat.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DisposeResultVO {//폐기처리결과

	String matLot;
	String matUnit;
	int matTestQnt; //검사량
	int matPassQnt; //합격량
	int matStaQnt; //폐기량
	int qipNumListExp;//보관초과검사내역번호
	String testOrderCode2; //검사순서코드
	
	
	String matName;
	int matQnt; //재고량
	Date matCstdy; //보관기한
	String matCode;
	String matOrdernum;
	String matState; //상태
}

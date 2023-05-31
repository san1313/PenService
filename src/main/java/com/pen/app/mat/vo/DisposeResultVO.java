package com.pen.app.mat.vo;

import lombok.Data;

@Data
public class DisposeResultVO {//폐기처리결과

	String matLot;
	String matUnit;
	int matTestQnt; //검사량
	int matPassQnt; //합격량
	int matStaQnt; //폐기량
	int qipNumListExp;//보관초과검사내역번호

	
	int matDsnum;//폐기처리번호
	String matName;
	int matQnt; //재고량
	String matChkeepdate; //변경보관기한
	String matChkeepdate1; //변경보관기한
	String matCode;
	String matOrdernum;
	String matState; //상태
	String matKeepdate; //보관기한
}

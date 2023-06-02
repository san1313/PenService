package com.pen.app.mat.vo;

import lombok.Data;

@Data
public class DisposeResultVO {//폐기처리결과

	String matLot;
	String matUnit;
	long matTestQnt; //검사량
	long matPassQnt; //합격량
	long matStaQnt; //폐기량
	long qipNumListExp;//보관초과검사내역번호

	
	long matDsnum;//폐기처리번호
	String matName;
	long matQnt; //재고량
	String matChkeepdate; //변경보관기한
	String matChkeepdate1; //변경보관기한
	String matCode;
	String matOrdernum;
	String matState; //상태
	String matKeepdate; //보관기한
	

	
	long matMdatqnt; //자재조정수량
	String matMdatdate; //조정날짜
	String matMdatdate1; //조정날짜
	String matMdatresn; //조정사유
	
	String matCharger; //담당자
	String matMdev; //조정구분
	
	String matBcncname; //거래처명
	int matWrhqy;
	int matDlivyqnt;
	String matWrhst; //상태
	int bmatQnt; //처리 전 재고량
	String vo;
}

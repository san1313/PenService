package com.pen.app.qip.vo;

import lombok.Data;

@Data
public class TestViewVO {
	//자재
	String qipCodeListMat;
	String matOrdernum;
    String matName;
    
    //제품
    String qipCodeListProd;
    String indicaCode;
    String prodName;
    String procName;
    int testNumProd;
    
    //보관기간초과
    String qipCodeListExp;
    String matLot;
    
    //공통
    String testDate;
    String empName;
    int testNumMat;
    int testTnumDef;
    int testTnumPass;
    
    //상세
    String testName;
    String testDetail;
    int testNumDef;
}

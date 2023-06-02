package com.pen.app.fac.vo;

import lombok.Data;

@Data
public class FacDownTimeVO {
	
	String downTimeCode; //비가동코드
	String facCode; //설비코드
	String downTimeReason; //비가동사유
	String downTimeStartDay; //비가동시작일
	String startTime; //시작시간	
	String reasonExplain; //사유설명
	String empNum; //담당자
	
	String downTimeEndDay; //비가동종료일	
	String endTime; //비가동 종료시간
	String facName;// 설비명
	
	String operateCheck; //가동여부
}

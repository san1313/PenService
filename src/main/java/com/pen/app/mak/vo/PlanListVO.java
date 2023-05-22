package com.pen.app.mak.vo;

import java.util.List;

import lombok.Data;

@Data
public class PlanListVO {
	List<PlanVO> planList;
	
	
	public void setPlanList(List<PlanVO> mainList) {
		this.planList = mainList;
	}
}

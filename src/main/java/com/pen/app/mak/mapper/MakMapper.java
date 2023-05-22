package com.pen.app.mak.mapper;

import java.util.ArrayList;
import java.util.List;

import com.pen.app.mak.vo.PlanVO;

public interface MakMapper {
	List<PlanVO> getPlanList();
	List<PlanVO> getPlanning(String contDetCode);
	List<PlanVO> getCont();
	List<PlanVO> getConnect(String contDetCode);
	List<PlanVO> getContr(ArrayList<String> detCoList);
	int insertPlan(PlanVO vo);
	int insertDetailPlan(PlanVO vo);
	int setPlanCont(PlanVO vo);
	int getContCount(String contDetCode);
	int getLeftQuan(String contDetCode);
}
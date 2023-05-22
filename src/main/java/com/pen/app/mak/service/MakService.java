package com.pen.app.mak.service;

import java.util.ArrayList;
import java.util.List;

import com.pen.app.mak.vo.PlanListVO;
import com.pen.app.mak.vo.PlanVO;

public interface MakService {
	public int insertPlan(PlanListVO vo);
	public List<PlanVO> getPlanList();
	public List<PlanVO> getCont();
	public List<PlanVO> getConnect(String detc);
	public List<PlanVO> getPlanning(String detc);
	public List<PlanVO> getContr(ArrayList<String> detCoList);
	
}

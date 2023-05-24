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
	int delConPlan(int connectCode);
	int delDPlan(String pdCode);
	int delPlan(String planCode);
	int getPdCount(String planCode);
	int modPlan(PlanVO vo);
	List<PlanVO> getPlanningList(PlanVO vo);
	//계약 상세 상태 바꿔주기
	int updateCont(String contDetCode);
	int updateContr(String contDetCode);
	
	
	List<PlanVO> getOrdList();
	int getOrdCount(String ordDetCode);
	int getLeaveQuan(String ordDetCode);
	List<PlanVO> getOrd();
	List<PlanVO> getConnection(String ordDetCode);
	List<PlanVO> getOrdering(String ordDetCode);
	List<PlanVO> getOrder(ArrayList<String> detCoList);
	int insertOrd(PlanVO vo);
	int updateOrd(String ordDetCode);
	int setPlanOrd(PlanVO vo);
	int updateOrder(String ordDetCode);
	
	List<PlanVO> getOrderingList(PlanVO vo);
	
}
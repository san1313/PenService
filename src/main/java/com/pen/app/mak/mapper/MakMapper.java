package com.pen.app.mak.mapper;

import java.util.List;

import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

public interface MakMapper {
	MakVO getMak(MakVO vo);
	MakVO setMak(MakVO vo);
	List<PlanVO> getPlanList();
	List<PlanVO> getPlanning(String contDetCode);
	List<PlanVO> getCont();
	List<PlanVO> getConnect(String contDetCode);
	List<PlanVO> getContr(String ContDetCode);
}

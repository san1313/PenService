package com.pen.app.mak.mapper;

import java.util.List;

import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

public interface MakIndMapper {
	List<PlanVO> ordPlanning();
	List<PlanVO> contPlanning();
	List<MakVO> indList();
	List<MakVO> planFlow(String prodCode);
	
	List<MakVO> getFlowList(List<MakVO> list);
	List<MakVO> getOperateCheck(List<MakVO> list);
	int insertIndica(MakVO vo);
}

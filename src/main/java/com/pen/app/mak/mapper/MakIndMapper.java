package com.pen.app.mak.mapper;

import java.util.List;

import com.pen.app.mak.vo.PlanVO;

public interface MakIndMapper {
	List<PlanVO> ordPlanning();
	List<PlanVO> contPlanning();
}

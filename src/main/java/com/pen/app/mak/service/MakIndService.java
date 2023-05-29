package com.pen.app.mak.service;

import java.util.List;

import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;


public interface MakIndService {
	List<PlanVO> planning();
	List<MakVO> indList();
	List<MakVO> planFlow(String prodCode);
	List<IndicaVO> getMatList();
}

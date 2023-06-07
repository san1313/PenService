package com.pen.app.mak.service;

import java.util.List;

import com.pen.app.mak.vo.IndicaListVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;


public interface MakIndService {
	List<PlanVO> planning();
	List<MakVO> indList();
	List<MakVO> planFlow(String prodCode);
	List<MakVO> getOperateCheck(IndicaListVO list);
	List<MakVO> getFlowList(IndicaListVO list);
	String insertIndica(IndicaListVO list);
	List<MakVO> getIndicatedBom(String indicaCode);
	String updateIndica(IndicaListVO list);
	String delIndica(IndicaListVO list);
	List<MakVO> dirIndList();
	List<MakVO> oerfProcList(String indicaCode);
	List<MakVO> getProcList(MakVO vo);
	List<MakVO> insertProcProd(MakVO vo);
	String updateProcProd(IndicaListVO list);
	List<MakVO> getProcProdInfo(MakVO vo);
}

package com.pen.app.mak.mapper;

import java.util.List;

import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

public interface MakIndMapper {
	List<PlanVO> ordPlanning(List<MakVO> list);
	List<MakVO> getOrdReQnt();
	List<PlanVO> ordPlanned(MakVO vo);
	
	List<MakVO> getConReQnt();
	List<PlanVO> contPlanning(List<MakVO> list);
	List<PlanVO> contPlanned(MakVO vo);
	
	List<MakVO> getIndReQnt();
	List<MakVO> indList(String pdCode);
	List<MakVO> planFlow(String prodCode);
	
	List<MakVO> getFlowList(List<MakVO> list);
	List<MakVO> getOperateCheck(List<MakVO> list);
	int insertIndica(MakVO vo);
	int insertBOM(MakVO vo);
	int insertFlow(MakVO vo);
	int getFlowSeq();
	List<MakVO> getCurrBom();
	List<MakVO> getMatQnt(String prodCode);
	int insertHold(MakVO vo);
	int updateMat(MakVO vo);
	
	List<MakVO> getIndicatedBom(String indicaCode);
	/* List<MakVO> getOrdCount(); */
	int updateIndica(MakVO vo);
	int updateMakBom(MakVO vo);
	List<MakVO> getIndMakHold(String indicaCode);
	int updateIndMakHold(MakVO vo);
	int updateIndMakMat(MakVO vo);
	int delIndica(MakVO vo);
	int delIndBom(int makBomCode);
	int delIndFlow(int makFlowCode);
	int delIndHold(String indicaCode);
	
	List<MakVO> dirIndList();
	List<MakVO> product();
	
	List<MakVO> modalProd(String prodName);
	List<MakVO> perfIndList();
	List<MakVO> resultIndList();
	List<MakVO> oerfProcList(String indicaCode);
	List<MakVO> userList();
	List<MakVO> getAllProcMat(MakVO vo);
	List<MakVO> getProcFac(String procCode);
	int insertProcProd(MakVO vo);
	int updateProcInd(String indicaCode);
	MakVO selectSemi(String resultCode);
	MakVO selectProd(String resultCode);
	String getProcProd(MakVO vo);
	int updateProcProd(MakVO vo);
	int insertMatDlivy(MakVO vo);
	int insertProcSemiHold(MakVO vo);
	int insertProcPrdt(MakVO vo);
	int updateProcIndica(MakVO vo);
	int getProcProdCount(MakVO vo);
	int getProcReCnt(MakVO vo);
	List<MakVO> getProcProdInfo(MakVO vo);
	Integer getResultUsage(MakVO vo);
}

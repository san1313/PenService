package com.pen.app.mak.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaListVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakIndServiceImpl implements MakIndService{
	@Autowired MakIndMapper mapper;
	
	//
	@Override
	@Transactional
	public List<PlanVO> planning() {
		List<MakVO> remain = mapper.getOrdReQnt();
		List<MakVO> conRe = mapper.getConReQnt();
		
		//주문서기반
		List<PlanVO> list = mapper.ordPlanning(remain);
		//계약서기반
		list.addAll(mapper.contPlanning(conRe));
		for (MakVO vo : remain) {
			List<PlanVO> result = mapper.ordPlanned(vo);
			for (PlanVO plan : result) {
				if(plan.getReQnt()!=0) {
					list.add(plan);
				}
			};
		}
		for (MakVO vo : conRe) {
			List<PlanVO> result = mapper.contPlanned(vo);
			for (PlanVO plan : result) {
				if(plan.getReQnt()!=0) {
					list.add(plan);
				}
			};
		}		
		return list;
	}

	@Override
	public List<MakVO> indList() {
		List<MakVO> remain = mapper.getIndReQnt();
		List<MakVO> result = new ArrayList<>();
		for (MakVO vo : remain) {
			List<MakVO> Make = mapper.indList(vo.getPdCode());
			for (MakVO vo2 : Make) {
				vo2.setReQnt(vo.getReQnt());
			};
			result.addAll(Make);
			
		}
		
		return result;
	}

	//필요자재 조회
	@Override
	public List<MakVO> planFlow(String prodCode) {

		return mapper.planFlow(prodCode);
	}


	//공정조회
	@Override
	public List<MakVO> getFlowList(IndicaListVO list) {
		List<MakVO> condi = list.getList();
		return mapper.getFlowList(condi);
	}

	@Override
	public List<MakVO> getOperateCheck(IndicaListVO list) {
		List<MakVO> condi = list.getList();
		return mapper.getOperateCheck(condi);
	}

	@Override
	@Transactional
	public String insertIndica(IndicaListVO list) {
		String result="";
		int j = 999;
		for(int i=0;i<list.getList().size();i++) {
			if(list.getList().get(i).getAmount()>0) {
				if(j>i) {
				j=i;
				}
			}
		}
		mapper.insertIndica(list.getList().get(j));
		int k=0;
		Map<Object,Integer> step = new HashMap<>();
		for (MakVO vo : list.getList()) {
			if(vo.getAmount()>0) {
				vo.setMakFlowCode(step.get(vo.getProcCode()));
				vo.setMakStep(step.get(vo.getMakFlowCode()));
				k+=mapper.insertBOM(vo);
			}else if(vo.getMakFlowStep()>0) {
				k+=mapper.insertFlow(vo);
				int seq = mapper.getFlowSeq();
				step.put(vo.getProcCode(),seq);
				step.put(seq, vo.getMakFlowStep());
			};
		};
		List<MakVO> bomList = mapper.getCurrBom();
		List<MakVO> matQnt = new ArrayList<>();
		for(MakVO vo : bomList) {
			matQnt=mapper.getMatQnt(vo.getProdCode());
			if(matQnt.get(0).getMatQnt()<vo.getAmount()) {
			for(MakVO vo2 : matQnt) {
				if(vo.getAmount()>vo2.getMatQnt()) {
				vo.setAmount(vo.getAmount()-vo2.getMatQnt());
				vo2.setCnt(vo2.getMatQnt());
				k+=mapper.insertHold(vo2);
				k+=mapper.updateMat(vo2);
				}else if(vo.getAmount()<vo2.getMatQnt()) {
					vo2.setCnt(vo.getAmount());
					k+=mapper.insertHold(vo2);
					k+=mapper.updateMat(vo2);
				}
				
				}
			}else {
				matQnt.get(0).setCnt(vo.getAmount());
				k+=mapper.insertHold(matQnt.get(0));
				k+=mapper.updateMat(matQnt.get(0));
			}
		}
		if(k>0) {
			result = "등록성공";
		}
		return result;
	}



}

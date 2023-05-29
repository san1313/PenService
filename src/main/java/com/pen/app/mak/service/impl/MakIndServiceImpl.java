package com.pen.app.mak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaListVO;
import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakIndServiceImpl implements MakIndService{
	@Autowired MakIndMapper mapper;
	
	//
	@Override
	@Transactional
	public List<PlanVO> planning() {
		//주문서기반
		List<PlanVO> list = mapper.ordPlanning();
		//계약서기반
		list.addAll(mapper.contPlanning());
		return list;
	}

	@Override
	public List<MakVO> indList() {
		return mapper.indList();
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
	public String insertIndica(MakVO vo) {
		String result="";
			if(mapper.insertIndica(vo)>0) {
				result="등록성공";
			}else{
				result="등록실패";
			};
		return result;
	}



}

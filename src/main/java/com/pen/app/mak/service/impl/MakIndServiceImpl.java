package com.pen.app.mak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakIndServiceImpl implements MakIndService{
	@Autowired MakIndMapper mapper;
	
	@Override
	public List<PlanVO> planning() {
		List<PlanVO> list = mapper.ordPlanning();
		list.addAll(mapper.contPlanning());
		return list;
	}

	@Override
	public List<MakVO> indList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MakVO> planFlow(String prodCode) {

		return mapper.planFlow(prodCode);
	}

	@Override
	public List<IndicaVO> getMatList() {
		return mapper.getMatList();
	}

}

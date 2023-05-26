package com.pen.app.mak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
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

}

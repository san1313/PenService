package com.pen.app.mak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
import com.pen.app.mak.vo.PlanListVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakServiceImpl implements MakService {

@Autowired MakMapper mapper;


@Override
public List<PlanVO> getPlanList() {
	List<PlanVO> list = mapper.getPlanList();
	return list;
}

@Override
public List<PlanVO> getCont() {
	List<PlanVO> list = mapper.getCont();
	return list;
}

@Override
public List<PlanVO> getConnect(String detc) {
	List<PlanVO> list = mapper.getConnect(detc);
	return list;
}

@Override
public List<PlanVO> getPlanning(String detc) {
	List<PlanVO> vo = mapper.getPlanning(detc);
	return vo;
}

@Override
public List<PlanVO> getContr(ArrayList<String> detCoList) {
	List<PlanVO> list = mapper.getContr(detCoList);
	return list;
}

@Override
@Transactional
public int insertPlan(PlanListVO vo) {
	int result = mapper.insertPlan(vo.getPlanList().get(0));
	for(int i=0; i<vo.getPlanList().size();i++) {
	result += mapper.insertDetailPlan(vo.getPlanList().get(i));
	result += mapper.setPlanCont(vo.getPlanList().get(i));
	};
	return result;
}


}

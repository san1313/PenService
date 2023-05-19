package com.pen.app.mak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakServiceImpl implements MakService {

@Autowired MakMapper mapper;

@Override
public MakVO getMak(MakVO vo) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public MakVO setMak(MakVO vo) {
	// TODO Auto-generated method stub
	return null;
}

@Transactional
public int insertPlan(List<PlanVO> list) {
	
	return 0;
}



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
	List<PlanVO> list = mapper.getPlanning(detc);
	return list;
}

@Override
public List<PlanVO> getContr(ArrayList<String> detCoList) {
	List<PlanVO> list = mapper.getContr(detCoList);
	return list;
}


}

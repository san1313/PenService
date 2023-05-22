package com.pen.app.fac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.service.FacService;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoVO;

@Service
public class FacServiceImpl implements FacService {

@Autowired FacMapper mapper;

@Override
public FacInfoVO getFac(FacInfoVO vo) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<FacConnProcVO> getproclist() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<FacConnProcVO> getprocminilist(String keyword) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void insert(FacInfoVO vo) {
	// TODO Auto-generated method stub
	
}

@Override
public void insertSelectKey(FacInfoVO vo) {
	// TODO Auto-generated method stub
	
}

@Override
public FacInfoVO getFac(String facCode) {
	// TODO Auto-generated method stub
	return null;
}








}

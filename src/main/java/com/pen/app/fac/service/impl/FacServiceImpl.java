package com.pen.app.fac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.service.FacService;
import com.pen.app.fac.vo.FacInfoVO;

@Service
public class FacServiceImpl implements FacService {

@Autowired FacMapper mapper;

@Override
public FacInfoVO getFac(FacInfoVO vo) {
	// TODO Auto-generated method stub
	return null;
}








}

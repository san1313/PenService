package com.pen.app.fac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.service.FacService;
import com.pen.app.fac.vo.FacVO;

@Service
public class FacServiceImpl implements FacService {

@Autowired FacMapper mapper;
	
@Override
public FacVO getFac(FacVO vo) {
	
		return mapper.getFac(vo);
	}
	
}

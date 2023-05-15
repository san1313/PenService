package com.pen.app.mak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
import com.pen.app.mak.vo.MakVO;

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


}

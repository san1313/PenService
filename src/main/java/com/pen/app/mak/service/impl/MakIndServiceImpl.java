package com.pen.app.mak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.MakVO;

@Service
public class MakIndServiceImpl implements MakIndService{
	@Autowired MakIndMapper mapper;
	
	@Override
	public List<MakVO> planning() {
		List<MakVO> list = mapper.planning();
		return list;
	}

}

package com.pen.app.bns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.service.BnsService;
import com.pen.app.bns.vo.BnsOrdVO;

@Service
public class BnsServiceImpl implements BnsService {

	@Autowired BnsMapper mapper;

	@Override
	public List<BnsOrdVO> getOrdList() {
		return mapper.getOrdList();
	}

	
}

package com.pen.app.bns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.service.BnsService;
import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

@Service
public class BnsServiceImpl implements BnsService {

	@Autowired BnsMapper mapper;

	@Override
	public List<BnsOrdVO> getOrdList() {
		return mapper.getOrdList();
	}

	@Override
	public int insertOrdList(BnsOrdVO bnsOrdVo) {
		return mapper.insertOrdList(bnsOrdVo);
	}

	@Override
	public List<BnsAccVO> getAccList() {
		return mapper.getAccList();
	}

	@Override
	public List<BnsProdVO> getProdList() {
		return mapper.getProdList();
	}

	
}

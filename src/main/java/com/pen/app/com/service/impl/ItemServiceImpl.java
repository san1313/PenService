package com.pen.app.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.mapper.ItemMapper;
import com.pen.app.com.service.ItemService;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;

@Service
public class ItemServiceImpl implements ItemService {

@Autowired ItemMapper mapper;
@Override
	public List<MatVO> getMatList() {
		
		return mapper.getMatList();
	}
@Override
public List<SemiVO> getSemiList() {
	
	return mapper.getSemiList();
}
@Override
	public List<ProdVO> getProdList() {
		
		return mapper.getProdList();
	}
}

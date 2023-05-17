package com.pen.app.mat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.OrderVO;

@Service
public class MatServiceimpl implements MatService{
	
	@Autowired MatMapper matmapper;

	@Override
	public void orderregister(OrderVO order) {
		

	}

	@Override
	public List<OrderVO> getorderlist() {		
		return matmapper.getorderlist();
	}

	@Override
	public List<OrderVO> getmatlist() {
		return matmapper.getmatlist();
	}

	@Override
	public List<OrderVO> getmatminilist(String keyword) {
		
		return matmapper.getmatminilist(keyword);
	}
	
	
}

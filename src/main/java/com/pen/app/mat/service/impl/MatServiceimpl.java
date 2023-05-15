package com.pen.app.mat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.OrderVO;

@Service
public class MatServiceimpl implements MatService{
	@Autowired MatMapper matMapper;

	@Override
	public void orderregister(OrderVO order) {
		
		matMapper.insertorder(order);
	}
	
	
}

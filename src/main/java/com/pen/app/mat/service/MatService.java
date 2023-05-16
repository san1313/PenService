package com.pen.app.mat.service;

import org.mybatis.spring.annotation.MapperScan;

import com.pen.app.mat.vo.OrderVO;

@MapperScan
public interface MatService {
	public void orderregister(OrderVO order);
}

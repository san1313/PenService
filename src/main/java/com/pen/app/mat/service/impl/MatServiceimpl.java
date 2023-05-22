package com.pen.app.mat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

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
		//모달자재목록
		return matmapper.getmatlist();
	}

	@Override
	public List<OrderVO> getmatminilist(String keyword) {
		
		return matmapper.getmatminilist(keyword);
	}

	@Override
	public List<OrderVO> getacclist() {
		//모달거래처목록
		return matmapper.getacclist();
	}

	@Override
	public List<OrderVO> getaccminilist(String keyword) {
		// TODO Auto-generated method stub
		return matmapper.getaccminilist(keyword);
	}


	 @Override
	 public void getmatregister(List<OrderVO> list) { 
		 // 발주등록 
			 
	 }

	@Override
	public List<WarehousingVO> getwarehousinglist() {
		// 자재입고 검사내역리스트
		return matmapper.getwarehousinglist();
	}
	 
	
	
	
}

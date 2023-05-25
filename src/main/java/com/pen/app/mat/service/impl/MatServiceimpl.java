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
		public List<OrderVO> gettodaymatregister() {
			// 당일발주등록리스트
			return matmapper.gettodaymatregister();
		}

	 
	 @Override
	public List<OrderVO> getorderlistajax() {
		// 발주등록조회페이지
		return matmapper.getorderlistajax();
	}
	 
	@Override
	public List<OrderVO> getorderlistsearchajax(String keyword) {
		//발주조회다중검색
		return matmapper.getorderlistsearchajax(keyword);
	}

	@Override
	public List<WarehousingVO> getwarehousinglist() {
		// 자재입고 검사내역리스트
		return matmapper.getwarehousinglist();
	}

	
	@Override
	public void getwarehousingregister(List<WarehousingVO> list) {
		// 자재입고등록
		for(int i=0; i<list.size(); i++) {
			int pass = list.get(i).getTestTnumPass();
			list.get(i).setMatWrhqy(pass);
		}
		matmapper.getwarehousingregister(list);
	}
	
	@Override
	public List<WarehousingVO> gettodaywarehousinglist() {
		// 자재입고리스트 당일건
		return matmapper.gettodaywarehousinglist();
	}
	
	@Override
	public List<WarehousingVO> getwarehousingmatlistajax() {
		// 자재입고조회
		return matmapper.getwarehousingmatlistajax();
	}

	@Override
	public List<WarehousingVO> getsemiwarehousinglist() {
		// 반제품 검사내역리스트
		return matmapper.getsemiwarehousinglist();
	}

	



	

	
	
	
	
}

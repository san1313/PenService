package com.pen.app.mat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.AdjustVO;
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

@Service
public class MatServiceimpl implements MatService {

	@Autowired
	MatMapper matmapper;

	@Override
	public void orderregister(OrderVO order) {

	}

	@Override
	public List<OrderVO> getorderlist() {
		return matmapper.getorderlist();
	}

	@Override
	public List<OrderVO> getmatlist() {
		// 모달자재목록
		return matmapper.getmatlist();
	}

	@Override
	public List<OrderVO> getmatminilist(String keyword) {
		// 모달자재검색
		return matmapper.getmatminilist(keyword);
	}

	@Override
	public List<OrderVO> getacclist() {
		// 모달거래처목록
		return matmapper.getacclist();
	}

	@Override
	public List<OrderVO> getaccminilist(String keyword) {
		// 모달거래처검색
		return matmapper.getaccminilist(keyword);
	}

	@Override
	public String getmatordercode() {
		// 발주번호
		return matmapper.getmatordercode();
	}

	@Override
	public void getmatregister(List<OrderVO> list) {
		// 발주등록
		matmapper.getmatregister(list);
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
	public List<OrderVO> getorderlistsearchajax(OrderVO vo) {
		// 발주조회다중검색
		return matmapper.getorderlistsearchajax(vo);
	}

	@Override
	public List<WarehousingVO> getwarehousinglist() {
		// 자재입고 검사내역리스트
		return matmapper.getwarehousinglist();
	}

	@Override
	public void getwarehousingregister(List<WarehousingVO> list) {
		//자재입고
		int sum = 0;
		// 입고량을 재고량으로 지정
		for (WarehousingVO in : list) {
			sum += in.getMatWrhqy();
		}
		list.get(0).setMatQnt(sum);

		// 자재입고등록. 총합격량을 입고량으로 지정
		for (int i = 0; i < list.size(); i++) {
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
	public List<WarehousingVO> getwarehousingsearchajax(WarehousingVO vo) {
		// 자재입고 다중검색 리스트
		return matmapper.getwarehousingsearchajax(vo);
	}

	@Override
	public List<WarehousingVO> getwarehousingmatlistajax() {
		// 자재입고조회
		return matmapper.getwarehousingmatlistajax();
	}

	@Override
	public List<InventoryVO> getinventorysearch(String keyword) {
		// 자재재고조회 자재코드 검색
		return matmapper.getinventorysearch(keyword);
	}

	@Override
	public List<InventoryVO> getinventorysearchlot(String matCode) {
		// 자재재고조회 lot
		return matmapper.getinventorysearchlot(matCode);
	}

	@Override
	public List<DlivyVO> getmatdlivylist() {
		// 자재출고리스트
		return matmapper.getmatdlivylist();
	}

	@Override
	public List<DlivyVO> getmatdlivysearchlist(DlivyVO vo) {
		// 자재출고리스트 다중검색
		return matmapper.getmatdlivysearchlist(vo);
	}

	@Override
	public List<AdjustVO> getmatadjustlotlist() {
		// 자재조정lot 리스트
		return matmapper.getmatadjustlotlist();
	}

	@Override
	public List<AdjustVO> getmatadjustlot(String matLot) {
		// 자재조정lot상세
		return matmapper.getmatadjustlot(matLot);
	}

	@Override
	public void getmatadjustregister(List<AdjustVO> list) {
		// 조정등록
		for (AdjustVO vo : list) {
			matmapper.getmatadjustregister(vo);
		}
		
	}

	/*
	 * @Override public List<WarehousingVO> getsemiwarehousinglist() { // 반제품
	 * 검사내역리스트 return matmapper.getsemiwarehousinglist(); }
	 */

}

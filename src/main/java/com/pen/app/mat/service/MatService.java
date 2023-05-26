package com.pen.app.mat.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

@MapperScan

public interface MatService {
	public void orderregister(OrderVO order);
	public List<OrderVO> getorderlist();
	public List<OrderVO> getmatlist(); //모달자재목록
	public List<OrderVO> getmatminilist(String keyword);
	public List<OrderVO> getacclist(); //모달거래처목록
	public List<OrderVO> getaccminilist(String keyword);
	public void getmatregister(List<OrderVO> list); //발주등록
	public List<OrderVO> gettodaymatregister(); //당일발주등록리스트
	public List<OrderVO> getorderlistajax(); //발주등록조회페이지
	public List<OrderVO> getorderlistsearchajax(OrderVO vo); //발주조회다중검색
	public List<WarehousingVO> getwarehousinglist(); //자재입고 검사내역리스트
	
	public void getwarehousingregister(List<WarehousingVO> list); //자재입고등록
	public List<WarehousingVO> gettodaywarehousinglist(); //당일건 자재입고리스트
	public List<WarehousingVO> getwarehousingsearchajax(WarehousingVO vo);//자재입고리스트 다중검색
	public List<WarehousingVO> getwarehousingmatlistajax(); //자재입고조회
	//public List<WarehousingVO> getsemiwarehousinglist(); //반제품 검사내역리스트
	
	public List<InventoryVO> getinventorysearch(String keyword); //자재재고조회 자재코드검색
	public List<InventoryVO> getinventorysearchlot(String matCode); //자재재고조회 lot
	
}

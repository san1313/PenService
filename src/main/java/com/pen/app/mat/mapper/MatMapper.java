package com.pen.app.mat.mapper;


import java.util.List;

import com.pen.app.mat.vo.AdjustVO;
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

public interface MatMapper {
	List<OrderVO> getorderlist();
	List<OrderVO> getmatlist(); //모달자재목록
	List<OrderVO> getmatminilist(String keyword);//거래처모달검색조회
	List<OrderVO> getacclist(); //모달거래처목록
	List<OrderVO> getaccminilist(String keyword);//거래처모달검색조회
	String getmatordercode();//발주코드
	public void getmatregister(List<OrderVO> list); //발주등록
	List<OrderVO> gettodaymatregister(); //당일발주등록리스트
	
	List<OrderVO> getorderlistajax(); //발주등록조회페이지리스트
	List<OrderVO> getorderlistsearchajax(OrderVO vo); //발주조회다중검색
	List<WarehousingVO> getestwarehousinglist(); //자재입고페이지 검사내역리스트
	
	public void getwarehousingregister(List<WarehousingVO> list); //자재입고등록
	List<WarehousingVO> gettodaywarehousinglist(); //당일건자재입고리스트
	List<WarehousingVO> getwarehousingsearchajax(WarehousingVO vo); //자재입고리스트 다중검색
	List<WarehousingVO> getwarehousingmatlistajax(); //자재입고조회
	
	//List<WarehousingVO> getsemiwarehousinglist(); //반제품입고페이지 검사내역리스트
	
	List<InventoryVO> getinventorysearch(String keyword); //자재재고조회 자재코드 검색
	List<InventoryVO> getinventorysearchlot(String matCode);//자재재고조회 lot
	
	List<AdjustVO> getmatadjustlotlist(); //자재조정 lot리스트
	List<AdjustVO> getmatadjustsearch(String keyword); //자재조정 자재코드 검색
	List<AdjustVO> getmatadjustlot(String matLot); //자재조정 lot 상세
	public void getmatadjustregister(AdjustVO vo); //조정등록(입고)
	public void getmatadjustdliregister(AdjustVO vo); //조정등록(출고)
	List<AdjustVO> getallmatadjustlist(); //자재조정리스트
	List<AdjustVO> getmatadjustsearchlist(AdjustVO vo); //자재조정리스트 다중검색
	
	List<DlivyVO> getmatdlivylist(); //자재출고리스트
	List<DlivyVO> getmatdlivysearchlist(DlivyVO vo); //자재출고리스트 다중검색
	
	
}
	
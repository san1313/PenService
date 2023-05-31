package com.pen.app.mat.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pen.app.mat.vo.AdjustVO;
import com.pen.app.mat.vo.DisposeResultVO;
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

@MapperScan

public interface MatService {
	//모달
	public void orderregister(OrderVO order);
	public List<OrderVO> getorderlist();
	public List<OrderVO> getmatlist(); //모달자재목록
	public List<OrderVO> getmatminilist(String keyword);
	public List<OrderVO> getacclist(String matName); //모달거래처목록
	public List<OrderVO> getaccminilist(String keyword);
	
	//자재발주관리
	public String getmatordercode();//발주코드
	public void getmatregister(List<OrderVO> list); //발주등록
	public List<OrderVO> gettodaymatregister(); //당일발주등록리스트
	
	//자재발주조회
	public List<OrderVO> getorderlistajax(); //발주등록조회페이지
	public List<OrderVO> getorderlistsearchajax(OrderVO vo); //발주조회다중검색
	
	//자재입고관리
	public List<WarehousingVO> getestwarehousinglist(); //자재입고 검사내역리스트	
	public void getwarehousingregister(List<WarehousingVO> list); //자재입고등록
	
	//자재입고조회
	public List<WarehousingVO> gettodaywarehousinglist(); //당일건 자재입고리스트
	public List<WarehousingVO> getwarehousingsearchajax(WarehousingVO vo);//자재입고리스트 다중검색
	public List<WarehousingVO> getwarehousingmatlistajax(); //자재입고조회
	
	//반제품입고관리
	public List<WarehousingVO> getsemiwarehousingtestlist(); //반제품 검사내역리스트
	public void getsemiwarehousingregister(List<WarehousingVO> list); //반제품 입고등록
	
	//반제품입고조회
	public List<WarehousingVO> getsemiwarehousinglistajax(); //반제품입고리스트
	
	//자재재고조회
	public List<InventoryVO> getinventorysearch(String keyword); //자재재고조회 자재코드검색
	public List<InventoryVO> getinventorysearchlot(String matCode); //자재재고조회 lot

	//자재조정관리
	public List<AdjustVO> getmatadjustlotlist(); //조정내역 lot리스트
	public List<AdjustVO> getmatadjustsearch(String keyword); //자재조정 자재코드 검색
	public List<AdjustVO> getmatadjustlot(String matLot);//조정 단건조회
	public void getmatadjustregister(List<AdjustVO> list); //조정등록(입고)
	public void getmatadjustdliregister(List<AdjustVO> list); //조정등록(출고)
	
	//자재조정조회
	public List<AdjustVO> getallmatadjustlist(); //자재조정리스트
	public List<AdjustVO> getmatadjustsearchlist(AdjustVO vo); //자재조정리스트 다중검색
	
	//자재출고조회
	public List<DlivyVO> getmatdlivylist(); //자재출고리스트
	public List<DlivyVO> getmatdlivysearchlist(DlivyVO vo); //자재출고리스트 다중검색
	
	//폐기자재조회
	public List<DisposeResultVO> getdisposeresultlist(); //폐기자재조회리스트
	public List<DisposeResultVO> getdisposeresultsearchlist(DisposeResultVO vo); //폐기자재조회 다중검색
}

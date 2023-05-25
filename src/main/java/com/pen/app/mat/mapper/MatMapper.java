package com.pen.app.mat.mapper;

import java.util.List;

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
	List<OrderVO> getorderlistsearchajax(String keyword); //발주조회다중검색
	List<WarehousingVO> getwarehousinglist(); //자재입고페이지 검사내역리스트
	
	public void getwarehousingregister(List<WarehousingVO> list); //자재입고등록
	List<WarehousingVO> gettodaywarehousinglist(); //당일건자재입고리스트
	
	List<WarehousingVO> getwarehousingmatlistajax(); //자재입고조회
	
	List<WarehousingVO> getsemiwarehousinglist(); //반제품입고페이지 검사내역리스트
}
	
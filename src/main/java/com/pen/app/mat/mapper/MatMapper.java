package com.pen.app.mat.mapper;


import java.util.List;

import com.pen.app.mat.vo.AdjustVO;
import com.pen.app.mat.vo.DisposeResultVO;
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.HoldVO;
import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

public interface MatMapper {
	//모달
	List<OrderVO> getmatlist(String accName); //모달자재목록
	List<OrderVO> getmatminilist(String keyword);//거래처모달검색조회
	List<OrderVO> getacclist(String matName); //모달거래처목록
	List<OrderVO> getaccminilist(String keyword);//거래처모달검색조회
	
	//자재발주관리
	String getmatordercode();//발주코드
	public void getmatregister(List<OrderVO> list); //발주등록
	List<OrderVO> gettodaymatregister(); //당일발주등록리스트
	List<OrderVO> getorderlistmodal(); //발주수정리스트모달
	List<OrderVO> getordlistsearchmodal(OrderVO vo); //발주리스트모달다중검색
	public void getordmodify(OrderVO list); //발주수정
	public void getdeleteord(OrderVO list); //발주삭제
	
	//자재발주조회
	List<OrderVO> getorderlistajax(); //발주등록조회페이지리스트
	List<OrderVO> getorderlistsearchajax(OrderVO vo); //발주조회다중검색
	
	//자재입고관리
	List<WarehousingVO> getestwarehousinglist(); //자재입고페이지 검사내역리스트
	public int getwarehousingregister(WarehousingVO vo); //자재입고등록
	public void getmativntryregister(WarehousingVO vo);
	public String getMatLotWarehousing();
	
	//자재입고조회
	List<WarehousingVO> gettodaywarehousinglist(); //당일건자재입고리스트
	List<WarehousingVO> getwarehousingsearchajax(WarehousingVO vo); //자재입고리스트 다중검색
	List<WarehousingVO> getwarehousingmatlistajax(); //자재입고조회
	
	
	//자재재고조회
	List<InventoryVO> getinventorysearch(String keyword); //자재재고조회 자재코드 검색
	List<InventoryVO> getinventorysearchlot(String matCode);//자재재고조회 lot
	
	//자재조정관리
	List<AdjustVO> getmatadjustlotlist(); //자재조정 lot리스트
	List<AdjustVO> getmatadjustsearch(AdjustVO vo); //자재조정 다중검색
	List<AdjustVO> getmatadjustlot(String matLot); //자재조정 lot 상세
	public void getmatadjustregister(AdjustVO vo); //조정등록(입고)
	public void getmatadjustdliregister(AdjustVO vo); //조정등록(출고)
	
	//자재조정조회
	List<AdjustVO> getallmatadjustlist(); //자재조정리스트
	List<AdjustVO> getmatadjustsearchlist(AdjustVO vo); //자재조정리스트 다중검색
	
	//출고내역
	List<DlivyVO> getmatdlivylist(); //자재출고리스트
	List<DlivyVO> getmatdlivysearchlist(DlivyVO vo); //자재출고리스트 다중검색
	
	//폐기자재조회
	List<DisposeResultVO> getdisposeresultlist(); //폐기자재조회리스트
	List<DisposeResultVO> getdisposeresultsearchlist(DisposeResultVO vo); //폐기자재조회 다중검색
	public void getdisposeresultlistresu(DisposeResultVO vo); //결과반영
	
	//자재홀드임의해제
	public void getmatoptionholdregister(HoldVO vo); //임의해제등록
	
	//자재홀드임의해제내역
	List<HoldVO> getallmatoptionholdlist(); 
	//임의해제다중검색
	List<HoldVO> getmatoptionholdsearchlist(HoldVO vo);
}
	
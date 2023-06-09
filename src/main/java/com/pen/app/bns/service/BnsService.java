package com.pen.app.bns.service;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsContVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;
import com.pen.app.bns.vo.BnsReleaseListVO;
import com.pen.app.bns.vo.BnsReleaseVO;
import com.pen.app.bns.vo.BnsStockVO;
import com.pen.app.bns.vo.BnsStoreListVO;
import com.pen.app.bns.vo.BnsStoreVO;

public interface BnsService {
	
	//주문서
	public List<BnsOrdVO> getOrdList(); //주문서페이지 조회
	public  List<BnsOrdVO> getOrdListCon(BnsOrdVO vo);//주문서 조건 조회
	public List<BnsAccVO> getAccList(); //모달창 거래처리스트 조회
	public List<BnsProdVO> getProdList();// 모달창 제품리스트 조회
	public List<BnsAccVO> getAccKeyList(String keyword);//거래처리스트 조회검색
	public List<BnsProdVO> getProdKeyList(String keyword);
	public List<BnsOrdVO> getProdModList(String keyword);// 주문서 수정 모달창 내의 제품리스트
	public int insertOrdList(List<BnsOrdVO> list);// 주문서 등록
	public int modOrdList(List<BnsOrdVO> list);//주문서 수정
	public void delOrdDetList(List<BnsOrdVO> list);//주문수정할때 제품 삭제
	public void delOrdList(List<BnsOrdVO> list);//주문서 삭제
	BnsOrdVO getOrdCode();//주문코드 조회
	
	public List<BnsContVO> getcontCodesList();// 모달창 제품리스트 조회
	public List<BnsContVO> getcontCodesKeyList(String keyword);
	public List<BnsOrdVO> getordCodesList();// 모달창 제품리스트 조회
	public List<BnsOrdVO> getordCodesKeyList(String keyword);
	
	//계약서
	public List<BnsContVO> getContList(); //계약서 페이지 조회
	public  List<BnsContVO> getContListCon(BnsContVO vo);//계약서 조건 조회
	public List<BnsContVO> getContProdModList(String keyword);// 계약서 수정 모달창 내의 제품리스트
	public int insertContList(List<BnsContVO> list);
	public int modContList(List<BnsContVO> list);//주문서 수정
	public void delContDetList(List<BnsContVO> list);//모달창 계약제품 삭제
	public void delContList(List<BnsContVO> list);//계약서 삭제
	List<BnsContVO> getContCode();//계약코드 조회
	
	//입고
	public List<BnsStoreVO> getbeforeStoreList(); //입고전 그리드 조회
	public List<BnsStoreVO> getafterStoreList(); //입고후 그리드 조회
	public void insertStoreList(BnsStoreListVO list); //입고 등록
	public void delStoreList(BnsStoreListVO list);//입고 취소
	public List<BnsStoreVO> getSearchStoreList();
	//출고
	
	public  List<BnsReleaseVO> getbeforeReleaseContList();//출고전 계약서 조회
	public  List<BnsReleaseVO> getbeforeReleaseOrdList();//출고전 주문서 조회
	public List<BnsReleaseVO> getLotReleaseList(String keyword);//출고전 LOT 리스트 그리드
	public void insertReleaseList(BnsReleaseListVO list); //출고 등록
	public List<BnsReleaseVO> getSearchReleaseList(); //출고조회 페이지
	
	public List<BnsStoreVO> getLOTPrdtList(String keyword);//거래처리스트 조회검색
	public List<BnsStoreVO> getLOTPrdtAfterList(String keyword);
	public  List<BnsStoreVO> getStoreListCon(BnsStoreVO vo);//입고 조건 조회
	public  List<BnsStoreVO> getStoreSearchListCon(BnsStoreVO vo);//입고 조건 조회
	
	public  List<BnsReleaseVO> getreleaseContListCon(BnsReleaseVO vo);//출고관리(계약) 조건 조회
	public  List<BnsReleaseVO> getreleaseOrdListCon(BnsReleaseVO vo);//출고관리(주문) 조건 조회
	public  List<BnsReleaseVO> getreleaseSearchListCon(BnsReleaseVO vo);//출고관리(주문) 조건 조회
	
	//재고조회
	public List<BnsStockVO> getSearchStockList(); //재고조회 페이지
	public  List<BnsStockVO> getstockSearchListCon(BnsStockVO vo);
	
}
package com.pen.app.bns.mapper;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsConVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

public interface BnsMapper {
	
	//주문서
	List<BnsOrdVO> getOrdList(); //주문서 전체 조회
	List<BnsOrdVO> getOrdListCon(BnsOrdVO vo); //주문서 조건 조회
	List<BnsAccVO> getAccList(); //모달창 거래처리스트 조회
	List<BnsProdVO> getProdList();// 모달창 제품리스트 조회
	
	List<BnsAccVO> getAccKeyList(String keyword); //거래처리스트 조회검색
	List<BnsProdVO> getProdKeyList(String keyword);
	
	List<BnsOrdVO> getProdModList(String keyword); // 주문서 수정 모달창 내의 제품리스트
	int insertOrdList(List<BnsOrdVO> list);// 주문서 등록
	
	int modOrdList(List<BnsOrdVO> list);// 주문서 수정
	void delOrdDetList(List<BnsOrdVO> list);// 주문서 삭제
	
	List<BnsOrdVO> getOrdCode();//주문코드 조회
	
	//계약서
	List<BnsConVO> getConList(); //계약서 전체 조회
	
}
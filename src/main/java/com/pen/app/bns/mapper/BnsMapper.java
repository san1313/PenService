package com.pen.app.bns.mapper;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsContVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;
import com.pen.app.bns.vo.BnsReleaseVO;
import com.pen.app.bns.vo.BnsStoreVO;

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
	void delOrdList(List<BnsOrdVO> list);// 주문서 삭제
	BnsOrdVO getOrdCode();//주문코드 조회
	
	//계약서
	List<BnsContVO> getContList(); //계약서 전체 조회
	List<BnsContVO> getContListCon(BnsContVO vo); //계약서 조건 조회
	List<BnsContVO> getContProdModList(String keyword); // 계약서 수정 모달창 내의 제품리스트
	int insertContList(List<BnsContVO> list);// 계약서 등록
	int modContList(List<BnsContVO> list);// 계약서 수정
	void delContDetList(List<BnsContVO> list);// 모달창 주문제품 삭제
	void delContList(List<BnsContVO> list);// 주문서 삭제
	List<BnsContVO> getContCode();//계약코드 조회
	
	//입고
	List<BnsStoreVO> getbeforeStoreList(); //입고 전 그리드
	List<BnsStoreVO> getafterStoreList(); //입고 후 그리드
	void insertStore(BnsStoreVO list);// 입고 등록
	void delStoreList(BnsStoreVO list);// 주문서 삭제
	
	
	//출고
	List<BnsReleaseVO> getbeforeReleaseContList(); //출고전 계약서 그리드
	List<BnsReleaseVO> getbeforeReleaseOrdList(); //출고전 주문서 그리드
}
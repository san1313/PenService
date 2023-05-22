package com.pen.app.bns.mapper;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsEmpVO;
import com.pen.app.bns.vo.BnsOrdDetVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

public interface BnsMapper {
	List<BnsOrdVO> getOrdList(); //주문서 전체 조회
	List<BnsOrdVO> getOrdListCon(BnsOrdVO vo); //주문서 조건 조회
	List<BnsAccVO> getAccList(); //모달창 거래처리스트 조회
	List<BnsProdVO> getProdList();// 모달창 제품리스트 조회
	List<BnsEmpVO> getEmpList();
	List<BnsAccVO> getAccKeyList(String keyword); //거래처리스트 조회검색
	List<BnsProdVO> getProdKeyList(String keyword);
	List<BnsEmpVO> getEmpKeyList(String keyword);
	int insertOrdList(BnsOrdVO bnsOrdVo);// 주문서 등록
	public void insertOrdDetList(BnsOrdDetVO vo);
	List<BnsOrdVO> getOrdCode();//주문코드 조회
}

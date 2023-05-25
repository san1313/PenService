package com.pen.app.bns.service;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsContVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

public interface BnsService {
	//주문서
	public List<BnsOrdVO> getOrdList(); //주문서페이지 조회
	public  List<BnsOrdVO> getOrdListCon(BnsOrdVO vo);
	public List<BnsAccVO> getAccList();
	public List<BnsProdVO> getProdList();
	public List<BnsAccVO> getAccKeyList(String keyword);
	public List<BnsProdVO> getProdKeyList(String keyword);
	public int insertOrdList(List<BnsOrdVO> list);
	public int modOrdList(List<BnsOrdVO> list);//주문서 수정
	public void delOrdDetList(List<BnsOrdVO> list);//주문서 삭제
	public List<BnsOrdVO> getProdModList(String keyword);
	/* public void insertOrdDetList (BnsOrdDetListVO bnsOrdDetListVo); */
	
	//계약서
	public List<BnsContVO> getContList(); //계약서 페이지 조회
	public  List<BnsContVO> getContListCon(BnsContVO vo);
	public int insertContList(List<BnsContVO> list);
	public int modContList(List<BnsContVO> list);//주문서 수정
	public void delContDetList(List<BnsContVO> list);//주문서 삭제
	public List<BnsContVO> getContProdModList(String keyword);
	
}
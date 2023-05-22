package com.pen.app.bns.service;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsEmpVO;
import com.pen.app.bns.vo.BnsOrdDetListVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

public interface BnsService {

	public List<BnsOrdVO> getOrdList();
	public  List<BnsOrdVO> getOrdListCon(BnsOrdVO vo);
	public List<BnsAccVO> getAccList();
	public List<BnsProdVO> getProdList();
	public List<BnsEmpVO> getEmpList();
	public List<BnsAccVO> getAccKeyList(String keyword);
	public List<BnsProdVO> getProdKeyList(String keyword);
	public List<BnsEmpVO> getEmpKeyList(String keyword);
	public int insertOrdList(BnsOrdVO bnsOrdVo);
	public void insertOrdDetList (BnsOrdDetListVO bnsOrdDetListVo);
}
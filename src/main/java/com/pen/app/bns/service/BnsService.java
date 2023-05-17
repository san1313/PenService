package com.pen.app.bns.service;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

public interface BnsService {

	public List<BnsOrdVO> getOrdList();
	public List<BnsAccVO> getAccList();
	public List<BnsProdVO> getProdList();
	public int insertOrdList(BnsOrdVO bnsOrdVo);
}
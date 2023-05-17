package com.pen.app.bns.mapper;

import java.util.List;

import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

public interface BnsMapper {
	List<BnsOrdVO> getOrdList();
	List<BnsAccVO> getAccList();
	List<BnsProdVO> getProdList();
	int insertOrdList(BnsOrdVO bnsOrdVo);
}

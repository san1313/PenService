package com.pen.app.fac.mapper;

import java.util.List;

import com.pen.app.fac.vo.FacInfoVO;


public interface FacInfoMapper {
	
	public List<FacInfoVO> getList(); //전체조회
	FacInfoVO getFac(FacInfoVO vo); //단건조회
	
}

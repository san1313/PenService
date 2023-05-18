package com.pen.app.fac.mapper;

import java.util.List;

import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoVO;


public interface FacMapper {
	
	public List<FacInfoVO> getList(); //전체조회
	public List<FacConnProcVO> getproclist();//공정코드목록
	public List<FacConnProcVO> getprocminilist(String keyword); //공정코드조회
	
	public void insert(FacInfoVO vo); //정보등록
	public FacInfoVO getFac(FacInfoVO vo); //단건조회
	}

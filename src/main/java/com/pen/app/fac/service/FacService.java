package com.pen.app.fac.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;
@MapperScan
public interface FacService {
	
	public FacInfoVO getFac(FacInfoVO vo);
	
	public List<FacConnProcVO> getproclist();//공정코드목록
	public List<FacConnProcVO> getprocminilist(String keyword); //공정코드조회
	
	public int facRegister(FacInfoVO vo); //설비등록
	public int facUpdate(FacInfoVO vo); //설비수정
	public int facDelete(FacInfoVO vo); //설비삭제
	   
	  
	public FacInfoVO getFac(String facCode); //단건조회
	
}

package com.pen.app.fac.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pen.app.fac.vo.FacConfirmVO;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacDownTimeVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;
@MapperScan
public interface FacService {
	

	
	public List<FacConnProcVO> getproclist();//공정코드목록
	public List<FacConnProcVO> getprocminilist(String keyword); //공정명으로 공정코드조회
	
	public List<FacConnProcVO> getFacConnProcList(String facCode); //설비별 공정조회
	public int facRegister(FacInfoVO vo); //설비등록
	public int insertFacList(FacInfoListVO list); //설비+공정등록
	public int insertConfirmList(FacConfirmVO list); //점검등록
	
	
	public int facUpdate(FacInfoListVO list); //설비수정
	public int confirmUpdate(FacConfirmVO list);//점검수정
	
	public int facDelete(FacInfoVO vo); //설비삭제
	public int confirmDelete(FacConfirmVO vo); //점검삭제
	public int downTimeDelete(FacDownTimeVO vo); //비가동삭제
	  
	public FacInfoVO getFac(String facCode); //단건조회
	public List<FacInfoVO> getfacminilist(String keyword);//설비명으로 설비코드조회
	public List<FacConfirmVO> confirmdaysSearchAjax(FacConfirmVO vo); //점검기간별 조회
	
	public List<FacDownTimeVO> getDownTimeList(FacDownTimeVO vo);//설비비가동조회
	public int insertDownTimeList(FacDownTimeVO list); //비가동 등록 
	
}

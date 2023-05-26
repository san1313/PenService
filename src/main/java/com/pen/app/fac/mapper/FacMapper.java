package com.pen.app.fac.mapper;

import java.util.List;

import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;


public interface FacMapper {
   
   public List<FacInfoVO> getList(); //설비전체조회
   public List<FacConnProcVO> getproclist();//공정코드목록
   public List<FacConnProcVO> getprocminilist(String keyword); //공정코드조회
   
   
   public int insertFacList(FacInfoListVO list); //설비+공정등록
   public int facRegister(FacInfoVO vo); //설비등록
   public int facUpdate(FacInfoVO vo); //설비수정
   public int facDelete(FacInfoVO facCode); //설비삭제 
   
   public FacInfoVO getFac(String facCode); //단건조회
   
   }
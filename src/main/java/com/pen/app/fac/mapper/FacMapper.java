package com.pen.app.fac.mapper;

import java.util.List;

import com.pen.app.fac.vo.FacConfirmVO;
import com.pen.app.fac.vo.FacConnProcVO;

import com.pen.app.fac.vo.FacDownTimeVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;


public interface FacMapper {
   //설비정보관리
   //public String getfacCode(); //설비코드자동부여
   public List<FacInfoVO> getList(FacInfoVO vo); //설비전체조회
   public List<FacConnProcVO> getproclist();//공정코드목록
   public List<FacConnProcVO> getprocminilist(String keyword); //공정코드조회
   public List<FacConnProcVO> getFacConnProcList(String facCode); //설비별 공정조회 
   public int facConnProcDelete(String facCode); //설비별 공정삭제
   public int insertProcList(FacInfoListVO list); //설비별 공정수정
   public int insertFacList(FacInfoListVO list); //설비+공정등록
   public int facRegister(FacInfoVO vo); //설비등록
   public int facUpdate(FacInfoVO vo); //설비수정
   public int facDelete(FacInfoVO facCode); //설비삭제
   
   public int checkOperateState(String facCode); //작동중인 설비확인
   
   public FacInfoVO getFac(String facCode); //단건조회
   public int facOperateState(FacDownTimeVO vo); //설비상태수정
   
   //설비점검관리
   public List<FacConfirmVO> getConfirmList(FacConfirmVO vo); //점검전체조회
   public List<FacInfoVO> getfacminilist(String keyword);//설비코드조회
   public int insertConfirmList(FacConfirmVO list); //점검등록
   public int confirmUpdate(FacConfirmVO list); //점검수정
   public int confirmDelete(FacConfirmVO vo);//점검삭제
   public List<FacConfirmVO> confirmdaysSearchAjax(FacConfirmVO vo); //점검기간 검색
   
   //설비비가동관리
   public List<FacDownTimeVO> getDownTimeList(FacDownTimeVO vo); //비가동전체조회
   public int insertDownTimeList(FacDownTimeVO list); //비가동 등록 
   public int downTimeDelete(FacDownTimeVO vo); //비가동삭제
   public int downTimeUpdate(FacDownTimeVO vo); //비가동수정
   

   
   
   
   }
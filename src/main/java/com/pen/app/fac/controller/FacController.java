package com.pen.app.fac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.service.FacService;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;

/*
 * 개발자:김미진
 * 내용: 설비파트 
 * 작성일자:
 * 수정일자:
 */
@Controller
@RequestMapping("/fac")
public class FacController {
   
   @Autowired FacMapper dao;
   @Autowired FacService service;
   
   
   	@GetMapping("/infoManage")
   	public void test() {
   		
   	}
   
   
    @GetMapping("/management") //설비관리 페이지
       public void management() {
      
       }
    @GetMapping("/register") //설비정보관리 페이지 
       public void register() {
          
       }
   
    
    @GetMapping("/confirm") //점검관리 페이지
    public void confirm() {
    	
    }
   
    
      //설비전체리스트 
      @ResponseBody
      @GetMapping("/infoListAjax") 
      public List<FacInfoVO> infoListAjax(FacInfoVO vo){
	      List<FacInfoVO> list = dao.getList(vo);
	      return list;
      }
      
      //설비별 공정리스트
      @ResponseBody
      @GetMapping("/getFacConnProcList")
      public List<FacConnProcVO> getFacConnProcList(String facCode){
    	  List<FacConnProcVO> list = dao.getFacConnProcList(facCode);
    	  return list;
      }
       
      //공정전체리스트
       @ResponseBody
       @GetMapping("/proclistAjax")
       public List<FacConnProcVO> proclist(){
          List<FacConnProcVO> list = dao.getproclist();
          return list;
       }
       
       //공정명 단건검색 리스트
       @ResponseBody
       @RequestMapping("/procminilist") 
      public List<FacConnProcVO> proclistAjax(@RequestParam String result){
    	   List<FacConnProcVO> list = dao.getprocminilist(result);
    	   return list;
      }
             
     //설비등록
     @ResponseBody
     @RequestMapping("/facRegister")
   	 public int facRegister(@RequestBody FacInfoListVO list) {
    	 //등록 업데이트 삭제; mybatis에서 update insert delete로 감싸는 얘네는 결과값으로 몇행에 해당하는 숫자를 돌려보내줌<<
    	 return service.insertFacList(list);
     }
   	 
     //설비수정
     @ResponseBody 
     @RequestMapping("/facUpdate")
     public int facUpdate(@RequestBody FacInfoListVO list) {
    	 return service.facUpdate(list);
     }
     
     //설비삭제
     @ResponseBody 
     @RequestMapping("/facDelete")
     public int facDelete(FacInfoVO vo) {
    	 return service.facDelete(vo);
     }
       
}
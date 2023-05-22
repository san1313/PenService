package com.pen.app.fac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoVO;


@Controller
@RequestMapping("/fac")
public class FacController {
   
   @Autowired FacMapper dao;
   
    @GetMapping("/management") //설비관리 페이지
       public void management() {
      
       }
    @GetMapping("/register") //설비등록 페이지 
       public void register() {
          
       }
    
    @GetMapping("/confirmRegister") //점검등록 페이지 
       public void confirmRegister() {
          
       }
    
   
    
    
       @ResponseBody
      @GetMapping("/infoListAjax") //설비전체리스트
      public List<FacInfoVO> infoListAjax(){
      List<FacInfoVO> list = dao.getList();
      System.out.println(list);
      return list;
      }
       
       @ResponseBody
       @GetMapping("/proclistAjax") //공정전체리스트
       public List<FacConnProcVO> proclist(){
          List<FacConnProcVO> list = dao.getproclist();
          return list;
       }
       
       @ResponseBody
       @RequestMapping("/procminilist") //공정명단건검색 리스트
      public List<FacConnProcVO> proclistAjax(@RequestParam String result){
          String data1 = "%";
          result += "%";
          data1 +=result;
          System.out.println(result);
      List<FacConnProcVO> list = dao.getprocminilist(data1);
      System.out.println(list);
      return list;
      }
       
       
       
}
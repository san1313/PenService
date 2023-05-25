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
    @GetMapping("/register") //설비등록 페이지 
       public void register() {
          
       }
   
    
    @GetMapping("/confirm_register") //점검등록 페이지
    public void confirm_register() {
    	
    }
   
    
      //설비전체리스트 
      @ResponseBody
      @GetMapping("/infoListAjax") 
      public List<FacInfoVO> infoListAjax(){
      List<FacInfoVO> list = dao.getList();
      System.out.println(list);
      return list;
      }
      
      //설비 단건검색 리스트
      
       
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
          String data1 = "%";
          result += "%";
          data1 +=result;
          System.out.println(result);
      List<FacConnProcVO> list = dao.getprocminilist(data1);
      System.out.println(list);
      return list;
      }
         
    
     //설비등록2
      @ResponseBody
      @RequestMapping("/insertFacList")
      public FacInfoVO insertFacList(@RequestBody FacInfoListVO list) {
    	  System.err.println(list.getList());
    	  System.out.println(list.getList().get(0));
    	  dao.insertFacList(list.getList());
    	  return null;
      }
       
     //설비등록
//     @ResponseBody
//     @RequestMapping("/facRegister")
//   	 public int facRegister(FacInfoVO vo) {
//    	 //등록 업데이트 삭제; mybatis에서 update insert delete로 감싸는 얘네는 결과값으로 몇행에 해당하는 숫자를 돌려보내줌<<
//    	 System.out.println(vo);
//    	 return service.facRegister(vo);
//     }
   	 
     //설비수정
     @ResponseBody 
     @RequestMapping("/facUpdate")
     public int facUpdate(FacInfoVO vo) {
    	 System.out.println("수정하려고 받은 값 : "+vo);
    	 return service.facUpdate(vo);
     }
     
     //설비삭제
     @ResponseBody 
     @RequestMapping("/facDelete")
     public int facDelete(FacInfoVO vo) {
    	 System.out.println("삭제하려고 받은 값: "+ vo);
    	 return service.facDelete(vo);
     }
       
}
package com.pen.app.bns.controller;
   
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.bns.service.BnsService;
import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsContDetListVO;
import com.pen.app.bns.vo.BnsContVO;
import com.pen.app.bns.vo.BnsOrdDetListVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;
import com.pen.app.bns.vo.BnsReleaseListVO;
import com.pen.app.bns.vo.BnsReleaseVO;
import com.pen.app.bns.vo.BnsStoreListVO;
import com.pen.app.bns.vo.BnsStoreVO;

/*
 * 김선재
 * 영업관리
 */
   
@Controller
@RequestMapping("/bns")
public class BnsController {

	@Autowired BnsService bnsService;
   
	//주문서관리 페이지
   @GetMapping("/ordList")
   public String ordList(Model model, Authentication authentication) {
      model.addAttribute("ordList", bnsService.getOrdList());
      UserDetails user = (UserDetails) authentication.getPrincipal();
      model.addAttribute("userVO", user);
      return "bns/ordList";
   }
   
   //주문서리스트 아작스
	@ResponseBody
	@GetMapping("/ordListAjax")
	public List<BnsOrdVO> ordListAjax(){
		List<BnsOrdVO> list = bnsService.getOrdList();
		return list;
	}
	
	//주문서조건검색 아작스
	@ResponseBody
	@GetMapping("/ordListconAjax")
	public List<BnsOrdVO> ordListconAjax(BnsOrdVO vo){
		List<BnsOrdVO> list = bnsService.getOrdListCon(vo);
		return list;
	}
	
	//주문서 등록
	@RequestMapping("/insertOrdList")
	@ResponseBody
	public List<BnsOrdVO> insertOrdList(@RequestBody List<BnsOrdVO> list) {
		bnsService.insertOrdList(list);
		return list;
	}
	
	//////삭제
	//거래처 리스트
	@ResponseBody
	@GetMapping("/accList")
	public List<BnsAccVO> accList() {
		List<BnsAccVO> list = bnsService.getAccList();
		return list;
	}
	
	//거래처 키워드
	@RequestMapping("/accKeyList")
	@ResponseBody
	public List<BnsAccVO> accKeyList(@RequestParam(required = false) String result){
		List<BnsAccVO> list = bnsService.getAccKeyList(result);
		return list;
	}
	
	//제품명 리스트
	@ResponseBody
	@GetMapping("/prodList")
	public List<BnsProdVO> prodList() {
		List<BnsProdVO> list = bnsService.getProdList();
		
		return list;
	}
	//제품명 조건 검색
	@RequestMapping("/prodKeyList")
	@ResponseBody
	public List<BnsProdVO> prodKeyList(@RequestParam String result){
		List<BnsProdVO> list = bnsService.getProdKeyList(result);
		return list;
	}
	
	//계약코드 리스트
		@ResponseBody
		@GetMapping("/contCodesList")
		public List<BnsContVO> contCodeList() {
			List<BnsContVO> list = bnsService.getcontCodesList();
			
			return list;
		}
		//계약코드 조건 검색
		@RequestMapping("/contCodesKeyList")
		@ResponseBody
		public List<BnsContVO> contCodesKeyList(@RequestParam String result){
			List<BnsContVO> list = bnsService.getcontCodesKeyList(result);
			return list;
		}
		//주문코드 리스트
				@ResponseBody
				@GetMapping("/ordCodesList")
				public List<BnsOrdVO> ordCodeList() {
					List<BnsOrdVO> list = bnsService.getordCodesList();
					
					return list;
				}
				//계약코드 조건 검색
				@RequestMapping("/ordCodesKeyList")
				@ResponseBody
				public List<BnsOrdVO> ordCodesKeyList(@RequestParam String result){
					List<BnsOrdVO> list = bnsService.getordCodesKeyList(result);
					return list;
				}
	
	//주문서 수정 모달창 안의 제품리스트
	@ResponseBody
	@GetMapping("/prodListModAjax")
	public List<BnsOrdVO> prodListModAjax(String result){
		
		System.out.println(result);
		List<BnsOrdVO> list = bnsService.getProdModList(result);
		return list;
	}
	
	//주문서 수정 모달창 안의 제품 수정
	@RequestMapping("/modOrdList")
	@ResponseBody
	public BnsOrdDetListVO modOrdList(@RequestBody BnsOrdDetListVO list) {
		
		bnsService.modOrdList(list.getList());
		return list;
	}
	
	//주문수정 제품삭제
	@RequestMapping("/delOrdDetList")
	@ResponseBody
	public BnsOrdDetListVO delOrdDetList(@RequestBody BnsOrdDetListVO list) {
		bnsService.delOrdDetList(list.getList());
		return list;
	}
	
	//주문서 취소
	@RequestMapping("/delOrdList")
	@ResponseBody
	public BnsOrdDetListVO delOrdList(@RequestBody BnsOrdDetListVO list) {
		bnsService.delOrdList(list.getList());
		return list;
	}
	
	//주문코드 자동생성
	@ResponseBody
	@GetMapping("/ordCode")
	public BnsOrdVO ordCode() {
		BnsOrdVO vo = bnsService.getOrdCode();
		return vo;
	}
	
	
///계약서	
	//계약서 관리 페이지
	   @GetMapping("/contList")
	   public String contList(Model model, Authentication authentication) {
			 
	      UserDetails user = (UserDetails) authentication.getPrincipal();
	      model.addAttribute("userVO", user);
	      return "bns/contList";
	   }
	   
	 //계약서리스트 아작스
		@ResponseBody
		@GetMapping("/contListAjax")
		public List<BnsContVO> contListAjax(){
			List<BnsContVO> list = bnsService.getContList();
			return list;
		}
		
		//계약서조건검색 아작스
		@ResponseBody
		@GetMapping("/contListconAjax")
		public List<BnsContVO> contListconAjax(BnsContVO vo){
			System.out.println("아작스 통해서 들어온 데이터 : "+vo);
			List<BnsContVO> list = bnsService.getContListCon(vo);
			System.out.println("조회 이후 나온 데이터 : "+list);
			return list;
		}
		
		//계약서 등록
		@RequestMapping("/insertcontList")
		@ResponseBody
		public BnsContDetListVO insertContList(@RequestBody BnsContDetListVO list) {
			
			bnsService.insertContList(list.getList());
			return list;
		}   
		
		//계약서 수정 모달창 안의 제품리스트
		@ResponseBody
		@GetMapping("/contprodListModAjax")
		public List<BnsContVO> ContprodListModAjax(String result){
			
			System.out.println(result);
			List<BnsContVO> list = bnsService.getContProdModList(result);
			return list;
		}
		
		//계약서 수정 모달창 안의 제품 수정
		@RequestMapping("/modContList")
		@ResponseBody
		public BnsContDetListVO modContList(@RequestBody BnsContDetListVO list) {
			bnsService.modContList(list.getList());
			return list;
		}
		
		//계약상세 삭제
		@RequestMapping("/delContDetList")
		@ResponseBody
		public BnsContDetListVO delContDetList(@RequestBody BnsContDetListVO list) {
			bnsService.delContDetList(list.getList());
			return list;
		}
		
		//계약서 취소
		@RequestMapping("/delContList")
		@ResponseBody
		public BnsContDetListVO delContList(@RequestBody BnsContDetListVO list) {
			bnsService.delContList(list.getList());
			return null;
		}
		
		//계약코드 자동생성
		@ResponseBody
		@GetMapping("/contCode")
		List<BnsContVO> contCode() {
			List<BnsContVO> list = bnsService.getContCode();
			System.out.println("계약코드 최대값 : "+list);
			return list;
		}

	 
///입고관리페이지
	   @GetMapping("/storeList")
	   public String storeList(Model model, Authentication authentication) {
			/* model.addAttribute("conList", dao.getConList()); */
	      UserDetails user = (UserDetails) authentication.getPrincipal();
	      model.addAttribute("userVO", user);
	      return "bns/storeList";
	   }
	   
	   //입고전 그리드 리스트
		@ResponseBody
		@GetMapping("/beforeStoreListAjax")
		public List<BnsStoreVO> beforestoreListAjax(){
			List<BnsStoreVO> list = bnsService.getbeforeStoreList();
			
			System.out.println(list);
			return list;
		}
		
		//입고후 그리드 리스트
		@ResponseBody
		@GetMapping("/afterStoreListAjax")
		public List<BnsStoreVO> afterstoreListAjax(){
			List<BnsStoreVO> list = bnsService.getafterStoreList();
			return list;
		}
		
		//입고등록 아작스
		@RequestMapping("/insertStoreList")
		@ResponseBody
		public boolean insertStoreList(@RequestBody BnsStoreListVO list) {
			bnsService.insertStoreList(list);
			System.out.println(list);
			return true;
		}
		
		//입고취소
				@RequestMapping("/delStoreList")
				@ResponseBody
				public boolean delStoreList(@RequestBody BnsStoreListVO list) {
					bnsService.delStoreList(list);
					return true;
				}
	   
///출고관리페이지
	   @GetMapping("/releaseList")
	   public String releaseList(Model model, Authentication authentication) {
			/* model.addAttribute("conList", dao.getConList()); */
	      UserDetails user = (UserDetails) authentication.getPrincipal();
	      model.addAttribute("userVO", user);
	      return "bns/releaseList";
	   }  
	
		//출고전 계약서 그리드 아작스
		@ResponseBody
		@GetMapping("/beforeReleaseContListAjax")
		public List<BnsReleaseVO> beforeReleaseContListAjax(){
			List<BnsReleaseVO> list = bnsService.getbeforeReleaseContList();
			return list;
		}
		
		//출고전 주문서 그리드 아작스
		@ResponseBody
		@GetMapping("/beforeReleaseOrdListAjax")
		public List<BnsReleaseVO> beforeReleaseOrdListAjax(){
			List<BnsReleaseVO> list = bnsService.getbeforeReleaseOrdList();
			return list;
		}
		
		//출고전 LOT리스트 그리드 아작스
				@ResponseBody
				@GetMapping("/LotReleaseListAjax")
				public List<BnsReleaseVO> LotReleaseListAjax(String result){
					List<BnsReleaseVO> list = bnsService.getLotReleaseList(result);
					return list;
				}
		
		//출고등록 아작스
		@RequestMapping("/insertReleaseList")
		@ResponseBody
		public boolean insertReleaseList(@RequestBody BnsReleaseListVO list) {
			bnsService.insertReleaseList(list);
			System.out.println(list);
			return true;
		}

//반품관리페이지
		@GetMapping("/returnList")
		   public String returnList(Model model, Authentication authentication) {
		      UserDetails user = (UserDetails) authentication.getPrincipal();
		      model.addAttribute("userVO", user);
		      return "bns/returnList";
		   }  
		
//입고내역 조회페이지
@GetMapping("/searchStoreList")
		   public String searchStoreList(Model model, Authentication authentication) {
		      UserDetails user = (UserDetails) authentication.getPrincipal();
		      model.addAttribute("userVO", user);
		  return "bns/searchStoreList";
		   }  
@ResponseBody
@GetMapping("/searchStoreListAjax")
public List<BnsStoreVO> searchStoreListAjax(){
	List<BnsStoreVO> list = bnsService.getSearchStoreList();
	return list;
}

//출고내역 조회페이지
@GetMapping("/searchReleaseList")
		   public String searchReleaseList(Model model, Authentication authentication) {
		      UserDetails user = (UserDetails) authentication.getPrincipal();
		      model.addAttribute("userVO", user);
		  return "bns/searchReleaseList";
		   }  

//출고내역 그리드
@ResponseBody
@GetMapping("/searchReleaseListAjax")
public List<BnsReleaseVO> searchReleaseListAjax(){
	List<BnsReleaseVO> list = bnsService.getSearchReleaseList();
	return list;
}

//입고관리 페이지 LOT번호 키워드
	@RequestMapping("/LOTPrdtList")
	@ResponseBody
	public List<BnsStoreVO> LOTPrdtList(@RequestParam(required = false) String result){
		List<BnsStoreVO> list = bnsService.getLOTPrdtList(result);
		return list;
	}
	
	//입고관리 페이지 LOT번호 키워드
		@RequestMapping("/LOTPrdtAfterList")
		@ResponseBody
		public List<BnsStoreVO> LOTPrdtAfterList(@RequestParam(required = false) String result){
			List<BnsStoreVO> list = bnsService.getLOTPrdtAfterList(result);
			return list;
		}

	//입고관리 페이지 LOT조건검색 아작스
	@ResponseBody
	@RequestMapping("/storeListconAjax")
	public List<BnsStoreVO> storeListconAjax(BnsStoreVO vo){
		return bnsService.getStoreListCon(vo);
	}
	
	//입고내역조회 페이지 LOT조건검색 아작스
		@ResponseBody
		@RequestMapping("/storeSearchListconAjax")
		public List<BnsStoreVO> storeSearchListconAjax(BnsStoreVO vo){
			return bnsService.getStoreSearchListCon(vo);
		}
		
		//출고관리페이지 출고대기 페이지(계약) 아작스
		@ResponseBody
		@RequestMapping("/releaseContListconAjax")
		public List<BnsReleaseVO> releaseContListconAjax(BnsReleaseVO vo){
			return bnsService.getreleaseContListCon(vo);
		}
		//출고관리페이지출고대기 페이지(주문) 아작스
		@ResponseBody
		@RequestMapping("/releaseOrdListconAjax")
		public List<BnsReleaseVO> releaseOrdListconAjax(BnsReleaseVO vo){
			return bnsService.getreleaseOrdListCon(vo);
		}
		
		//출고조회내역페이지 아작스
		@ResponseBody
		@RequestMapping("/releaseSearchListconAjax")
		public List<BnsReleaseVO> releaseSearchListconAjax(BnsReleaseVO vo){
			return bnsService.getreleaseSearchListCon(vo);
		}
		
		//판매실적 페이지
		   @GetMapping("/profit")
		   public String profit(Model model, Authentication authentication) {
				/* model.addAttribute("profit", bnsService.getProfit()); */
		      UserDetails user = (UserDetails) authentication.getPrincipal();
		      model.addAttribute("userVO", user);
		      return "bns/profit";
		   }

}


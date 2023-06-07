package com.pen.app.mat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.AdjustVO;
import com.pen.app.mat.vo.DisposeResultVO;
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.HoldVO;
import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.MatOrdVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;
/*
 * 최규리
 * 자재관리,조회
 */

@Controller
@RequestMapping("/mat")
public class MatController {


	@Autowired MatService matservice;

	//발주페이지
	@GetMapping("/order")
	public void ordermain() {
		
	}
	 	
	//자재모달창리스트
	@ResponseBody
	@GetMapping("/matlist")
	public List<OrderVO> matlist(){
		List<OrderVO> list = matservice.getmatlist();
		return list;
	}
	
	//자재모달조회
	@RequestMapping("/matminilist")
	@ResponseBody
	public List<OrderVO> matminilist(@RequestParam String result){
		List<OrderVO> list = matservice.getmatminilist(result);
		return list;
	}
	
	//거래처모달창리스트
	@RequestMapping("/acclist")
	@ResponseBody
	public List<OrderVO> acclist(@RequestParam(required = false) String matName){
		List<OrderVO> list = matservice.getacclist(matName);
		return list;
	}
	
	//자재모달조회
	@RequestMapping("/accminilist")
	@ResponseBody
	public List<OrderVO> accminilist(@RequestParam String result){
		System.out.println(result);
		List<OrderVO> list = matservice.getaccminilist(result);
		return list;
	}
	
	//발주번호
	 @ResponseBody	  
	 @GetMapping("/matordercode") 
	 public String matordercode(){
		 String result = matservice.getmatordercode();
		 return result; 
	 }
	 
	
	//발주등록
	 @RequestMapping("/matregister")
	 @ResponseBody 
	 public OrderVO matregister(@RequestBody List<OrderVO> list){
		 System.err.println(list);
		 matservice.getmatregister(list);		 
	 	 return null; 
	 }
		 
	 //당일발주등록조회
	 @RequestMapping("/todaymatregister")
	 @ResponseBody
	 public List<OrderVO> todaymatregister(){
		 List<OrderVO> list = matservice.gettodaymatregister();
		 return list;
	 }
	 
	 //자재발주리스트모달다중검색
	 @RequestMapping("/ordlistsearchmodal")
	 @ResponseBody
	 public List<OrderVO> ordlistsearchmodal(OrderVO OrderVO) {
		 System.err.println(OrderVO);

		return matservice.getordlistsearchmodal(OrderVO);
	 }
	 
	 //발주수정
	 @RequestMapping("/ordmodify")
	 @ResponseBody 
	 public OrderVO ordmodify(@RequestBody MatOrdVO list){
		 System.err.println(list);
		 matservice.getordmodify(list);		 
	 	 return null; 
	 }
	 
	 //발주삭제
	 @RequestMapping("/deleteord")
	 @ResponseBody
	 public OrderVO deleteord(@RequestBody MatOrdVO list) {
		 System.err.println(list);
		 matservice.getdeleteord(list);		 
	 	 return null; 
	 }
	 
	 //자재발주조회페이지
	 @GetMapping("/orderlist")
	 public void matorderlist(){
		 
	 }
	 //자재발주조회
	 @RequestMapping("/orderlistajax")
	 @ResponseBody
	 public List<OrderVO> matorderlistajax(){
		 List<OrderVO> list = matservice.getorderlistajax();	
		 return list;
	 }
	 
	 //자재발주조회 다중검색
	 @RequestMapping("/orderlistsearchajax")
	 @ResponseBody
	 public List<OrderVO> orderlistsearchajax(OrderVO orderVo) {
		 System.err.println(orderVo);

		return  matservice.getorderlistsearchajax(orderVo);
	 }
	  
	 
	
	 //자재입고페이지
	 @GetMapping("/warehousing")
	 public void warehousing() {
		 
	 }
	 
	 //자재 검사내역리스트
	 @RequestMapping("/testwarehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> testwarehousinglist(){
		 List<WarehousingVO> list = matservice.getestwarehousinglist();
		 return list;
	 }
	 
	 //자재 입고등록
	 @RequestMapping("/warehousingregister")
	 @ResponseBody
	 public WarehousingVO warehousingregister(@RequestBody List<WarehousingVO> list) {
		 System.err.println(list);
		 
		 matservice.getwarehousingregister(list);
		 return null;
	 }
	 
	 //당일건 자재입고등록리스트
	 @RequestMapping("/todaywarehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> gettodaywarehousinglist(){
		 List<WarehousingVO> list = matservice.gettodaywarehousinglist();
		 return list;
	 }
	 
	 //자재입고리스트 다중검색
	 @RequestMapping("/warehousingsearchajax")
	 @ResponseBody
	 public List<WarehousingVO> warehousingsearchajax(WarehousingVO WarehousingVO) {
		 System.err.println(WarehousingVO);

		return  matservice.getwarehousingsearchajax(WarehousingVO);
	 }
	 

	 //자재 입고조회
	 @GetMapping("/warehousinglist")
	 public void warehousingmatlist() {
		 
	 } 
	 
	 //자재입고조회리스트
	 @GetMapping("/warehousingmatlistajax")
	 @ResponseBody
	 public List<WarehousingVO> warehousingmatlistajax(){
		 List<WarehousingVO> list = matservice.getwarehousingmatlistajax();
		 return list;
	 }
	
	 //자재 재고조회
	 @GetMapping("/inventory")
	 public void inventory() {
		 
	 }
	 
	 //자재 재고조회 자재코드검색
	 @RequestMapping("/inventorysearch")
	 @ResponseBody
	 public List<InventoryVO> inventorysearch(@RequestParam String result){
		 System.out.println(result);
		 List<InventoryVO> list = matservice.getinventorysearch(result);
		 return list;
	 }
	 	
	 //자재 lot 조회
	 @RequestMapping("/inventorysearchlot")
	 @ResponseBody
	 public List<InventoryVO> inventorysearchlot(@RequestParam String matCode){
		 List<InventoryVO> list = matservice.getinventorysearchlot(matCode);
		 return list;
	 }
	 
	 //재고조정관리
	 @GetMapping("/matadjust")
	 public void matadjust(){
		
	 }
	 
	 //자재조정lot리스트
	 @GetMapping("/matadjustlotlist")
	 @ResponseBody
	 public List<AdjustVO> matadjustlotlist(){
		 List<AdjustVO> list = matservice.getmatadjustlotlist();
		 return list;
	 }
	 
	 //자재조정관리 다중검색
	 @RequestMapping("/matadjustsearch")
	 @ResponseBody
	 public List<AdjustVO> matadjustsearch(AdjustVO AdjustVO){
		 System.out.println(AdjustVO);
		 return matservice.getmatadjustsearch(AdjustVO);
	 }
	 
	 //자재조정 lot 상세
	 @RequestMapping("/matadjustlot")
	 @ResponseBody
	 public List<AdjustVO> matadjustlot(@RequestParam String matLot){
		 List<AdjustVO> list = matservice.getmatadjustlot(matLot);
		 return list;
	 }
	 
	 //자재조정(입고)
	 @RequestMapping("/matadjustregister")
	 @ResponseBody
	 public AdjustVO matadjustregister(@RequestBody List<AdjustVO> list) {
		 System.err.println(list);		 
		 matservice.getmatadjustregister(list);
		 return null;
	 }
	 
	 //자재조정(출고)
	 @RequestMapping("/matadjustdliregister")
	 @ResponseBody
	 public AdjustVO matadjustdliregister(@RequestBody List<AdjustVO> list) {
		 System.err.println(list);
		 matservice.getmatadjustdliregister(list);
		 return null;
	 }
	 
	 //자재조정조회
	 @GetMapping("/matadjustlist")
	 public void matadjustlist() {
		 
	 }
	 
	 //자재조정조회
	 @GetMapping("/allmatadjustlist")
	 @ResponseBody
	 public List<AdjustVO> allmatadjustlist(){
		 List<AdjustVO> list = matservice.getallmatadjustlist();
		 return list;
	 }
	 
	 //자재조정조회 다중검색
	 @GetMapping ("/matadjustsearchlist")
	 @ResponseBody
	 public List<AdjustVO> matadjustsearchlist(AdjustVO adjustVO){
		 System.err.println(adjustVO);
		 
		 return matservice.getmatadjustsearchlist(adjustVO);
	 }
	 
	
	 //자재출고조회
	 @GetMapping("/matdlivy")
	 public void matdlivy() {
		 
	 }
	 
	 //자재출고조회
	 @GetMapping("/matdlivylist")
	 @ResponseBody
	 public List<DlivyVO> matdlivylist() {
		 List<DlivyVO> list = matservice.getmatdlivylist();
		 return list;
	 }
	 
	 //자재출고조회 다중검색
	 @GetMapping("/matdlivysearchlist")
	 @ResponseBody
	 public List<DlivyVO> matdlivysearchlist(DlivyVO dlivyVO){
		 System.err.println(dlivyVO);
		 
		 return matservice.getmatdlivysearchlist(dlivyVO);
	 }
	 
	 //폐기자재조회
	 @GetMapping("/disposeresult")
	 public void disposeresult() {
		 
	 }
	 
	 //폐기자재조회리스트
	 @GetMapping("/disposeresultlist")
	 @ResponseBody
	 public List<DisposeResultVO> disposeresultlist(){
		 List<DisposeResultVO> list = matservice.getdisposeresultlist();
		 return list;
	 }
	 
	 //폐기자재조회 다중검색
	 @GetMapping("/disposeresultsearchlist")
	 @ResponseBody
	 public List<DisposeResultVO> disposeresultsearchlist(DisposeResultVO disposeResultVO){
		 System.err.println(disposeResultVO);
		 
		 return matservice.getdisposeresultsearchlist(disposeResultVO);		 
	 }
	 
	 //폐기자재결과반영
	 @RequestMapping("/disposeresultlistresu")
	 @ResponseBody
	 public DisposeResultVO disposeresultlistresu(@RequestBody List<DisposeResultVO> list) {
		 System.err.println(list);
		 matservice.getdisposeresultlistresu(list);
		 return null;
	 }	
	 
	 //자재홀드임의해제
	 @GetMapping("/matoptionhold")
	 public void matoptionhold() {
		 
	 }
	 
	 //자재홀드임의해제
	 @RequestMapping("/matoptionholdregister")
	 @ResponseBody
	 public HoldVO matoptionholdregister(@RequestBody List<HoldVO> list) {
		 System.err.println(list);
		 
		 matservice.getmatoptionholdregister(list);
		 return null;
	 }
	 
	//자재홀드임의해제리스트
	@GetMapping("/matoptionholdlist")
	public void matoptionholdlist() {
			 
	}
	
	 //자재홀드임의해제전체리스트
	 @GetMapping("/allmatoptionholdlist")
	 @ResponseBody
	 public List<HoldVO> allmatoptionholdlist(){
		 List<HoldVO> list = matservice.getallmatoptionholdlist();
		 return list;
	 }
	 
	 //자재홀드임의해제리스트 다중검색
	 @GetMapping("/matoptionholdsearchlist")
	 @ResponseBody
	 public List<HoldVO> matoptionholdsearchlist(HoldVO holdVO){
		 System.err.println(holdVO);
		 
		 return matservice.getmatoptionholdsearchlist(holdVO);
	 }
	 
}

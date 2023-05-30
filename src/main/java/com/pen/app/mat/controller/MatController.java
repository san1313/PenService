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
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.InventoryVO;
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
	@ResponseBody
	@GetMapping("/acclist")
	public List<OrderVO> acclist(){
		List<OrderVO> list = matservice.getacclist();
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
		 //System.out.println(vo.getList().get(0));
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
	 @RequestMapping("/warehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> warehousinglist(){
		 List<WarehousingVO> list = matservice.getwarehousinglist();
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
	 
	 
	 //반제품 검사내역리스트
	 /*@RequestMapping("/semiwarehousinglist")
	 @ResponseBody
	 public List<WarehousingVO> semiwarehousinglist(){
		List<WarehousingVO> list = matmapper.getsemiwarehousinglist();
		return list;
	 }*/
	 

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
	 
}

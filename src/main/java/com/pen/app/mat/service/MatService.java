package com.pen.app.mat.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pen.app.mat.vo.MatOrdVO;
import com.pen.app.mat.vo.OrderVO;

@MapperScan
public interface MatService {
	public void orderregister(OrderVO order);
	public List<OrderVO> getorderlist();
	public List<OrderVO> getmatlist(); //모달자재목록
	public List<OrderVO> getmatminilist(String keyword);
	public List<OrderVO> getacclist(); //모달거래처목록
	public List<OrderVO> getaccminilist(String keyword);
	public void getmatregister(MatOrdVO vo); //발주등록
	
}

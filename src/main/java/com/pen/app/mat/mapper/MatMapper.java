package com.pen.app.mat.mapper;

import java.util.List;

import com.pen.app.mat.vo.OrderVO;

public interface MatMapper {
	List<OrderVO> getorderlist();
	List<OrderVO> getmatlist(); //모달자재목록
	List<OrderVO> getmatminilist(String keyword);//거래처모달검색조회
	List<OrderVO> getacclist(); //모달거래처목록
	List<OrderVO> getaccminilist(String keyword);//거래처모달검색조회
}
	
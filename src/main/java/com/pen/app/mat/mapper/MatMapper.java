package com.pen.app.mat.mapper;

import java.util.List;

import com.pen.app.mat.vo.OrderVO;

public interface MatMapper {
	List<OrderVO> getorderlist();
	List<OrderVO> getmatlist(); //모달자재목록
	List<OrderVO> getmatminilist(String keyword);//모달검색조회
}
	
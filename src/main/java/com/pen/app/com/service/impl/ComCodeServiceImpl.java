package com.pen.app.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.mapper.ItemMapper;
import com.pen.app.com.mapper.comCodeMapper;
import com.pen.app.com.service.ComCodeService;
import com.pen.app.com.service.ItemService;
import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;

@Service
public class ComCodeServiceImpl implements ComCodeService {

@Autowired comCodeMapper mapper;
	@Override
		public List<ComCodeVO> getComCodeList() {
			
			return mapper.getComCodeList();
		}
}

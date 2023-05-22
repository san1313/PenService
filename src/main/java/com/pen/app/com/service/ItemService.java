package com.pen.app.com.service;

import java.util.List;

import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;

public interface ItemService {
	public List<MatVO> getMatList();
	public List<SemiVO> getSemiList();
	public List<ProdVO> getProdList();
}

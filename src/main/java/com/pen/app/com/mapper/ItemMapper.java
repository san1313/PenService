package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;
import com.pen.app.com.vo.UserVO;

public interface ItemMapper {
	public List<MatVO> getMatList();
	public List<SemiVO> getSemiList();
	public List<ProdVO> getProdList();
}

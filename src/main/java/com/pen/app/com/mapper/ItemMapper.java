package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;
import com.pen.app.com.vo.UserVO;

public interface ItemMapper {
	//자재
	List<MatVO> getMatList();
	List<MatVO> getMatWithName(String matName);
	String getMatCode();
	int modifyMatList(List<MatVO> list);
	int insertMatList(List<MatVO> list);
	//반제품
	List<SemiVO> getSemiList();
	List<SemiVO> getSemiWithName(String semiName);
	int modifySemiList(List<SemiVO> list);
	int insertSemiList(List<SemiVO> list);
	String getSemiCode();
	//완제품
	List<ProdVO> getProdList();
	List<ProdVO> getProdWithName(String prodName);
	String getProdCode();
	int modifyProdList(List<ProdVO> list);
	int insertProdList(List<ProdVO> list);
}

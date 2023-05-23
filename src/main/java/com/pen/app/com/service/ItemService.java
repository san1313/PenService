package com.pen.app.com.service;

import java.util.List;

import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;

public interface ItemService {
	//자재
	List<MatVO> getMatList();
	List<MatVO> getMatWithName(String matName);
	String getMatCode();
	boolean modifyMatList(List<MatVO> list);
	boolean insertMatList(List<MatVO> list);
	//반제품
	List<SemiVO> getSemiList();
	List<SemiVO> getSemiWithName(String semiName);
	boolean modifySemiList(List<SemiVO> list);
	boolean insertSemiList(List<SemiVO> list);
	String getSemiCode();
	//완제품
	List<ProdVO> getProdList();
	List<ProdVO> getProdWithName(String prodName);
	String getProdCode();
	boolean modifyProdList(List<ProdVO> list);
	boolean insertProdList(List<ProdVO> list);
}

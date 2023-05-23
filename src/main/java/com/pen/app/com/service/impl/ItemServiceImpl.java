package com.pen.app.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.mapper.ItemMapper;
import com.pen.app.com.service.ItemService;
import com.pen.app.com.vo.MatVO;
import com.pen.app.com.vo.ProdVO;
import com.pen.app.com.vo.SemiVO;

@Service
public class ItemServiceImpl implements ItemService {

@Autowired ItemMapper mapper;
@Override
	public List<MatVO> getMatList() {
		
		return mapper.getMatList();
	}
@Override
public List<MatVO> getMatWithName(String matName) {
	
	return mapper.getMatWithName(matName);
}
@Override
	public String getMatCode() {
		
		return mapper.getMatCode();
	}
@Override
	public boolean modifyMatList(List<MatVO> list) {
		
		return mapper.modifyMatList(list)>0;
	}
@Override
	public boolean insertMatList(List<MatVO> list) {
		
		return mapper.insertMatList(list)>0;
	}
//---------------------------------------------------

@Override
public List<SemiVO> getSemiList() {
	
	return mapper.getSemiList();
}
@Override
	public List<SemiVO> getSemiWithName(String semiName) {
		
		return mapper.getSemiWithName(semiName);
	}
@Override
	public String getSemiCode() {
		
		return mapper.getSemiCode();
	}
@Override
	public boolean modifySemiList(List<SemiVO> list) {
		
		return mapper.modifySemiList(list)>0;
	}
@Override
	public boolean insertSemiList(List<SemiVO> list) {
		
		return mapper.insertSemiList(list)>0;
	}

//---------------------------------------------------

@Override
	public List<ProdVO> getProdList() {
		
		return mapper.getProdList();
	}
@Override
	public List<ProdVO> getProdWithName(String prodName) {
		
		return mapper.getProdWithName(prodName);
	}
@Override
	public String getProdCode() {
		
		return mapper.getProdCode();
	}
@Override
	public boolean modifyProdList(List<ProdVO> list) {
		
		return mapper.modifyProdList(list)>0;
	}
@Override
	public boolean insertProdList(List<ProdVO> list) {
		
		return mapper.insertProdList(list)>0;
	}
}

package com.pen.app.fac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.service.FacService;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;

@Service
public class FacServiceImpl implements FacService {

@Autowired FacMapper mapper;

@Override
public FacInfoVO getFac(FacInfoVO vo) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<FacConnProcVO> getproclist() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<FacConnProcVO> getprocminilist(String keyword) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public FacInfoVO getFac(String facCode) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int facRegister(FacInfoVO vo) {
	// 설비등록
	return mapper.facRegister(vo);
	
}

@Override
public int facUpdate(FacInfoVO vo) {
	// 설비수정
	return mapper.facUpdate(vo);
	
	
}

@Override
public int facDelete(FacInfoVO vo) {
	//설비삭제
	return mapper.facDelete(vo);
}







}










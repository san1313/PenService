package com.pen.app.fac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.fac.mapper.FacMapper;
import com.pen.app.fac.service.FacService;
import com.pen.app.fac.vo.FacConfirmVO;
import com.pen.app.fac.vo.FacConnProcVO;
import com.pen.app.fac.vo.FacDownTimeVO;
import com.pen.app.fac.vo.FacInfoListVO;
import com.pen.app.fac.vo.FacInfoVO;

@Service
public class FacServiceImpl implements FacService {

	@Autowired
	FacMapper mapper;

	@Override
	public List<FacConnProcVO> getproclist() {
		return mapper.getproclist();
	}

	@Override
	public List<FacConnProcVO> getprocminilist(String keyword) {
		//공정명으로 공정코드조회 
		return mapper.getprocminilist(keyword);
	}

	@Override
	public List<FacInfoVO> getfacminilist(String keyword) {
		// 설비명으로 설비코드조회
		return mapper.getfacminilist(keyword);
	}
	
	@Override
	public FacInfoVO getFac(String facCode) {
		// 단건조회
		return mapper.getFac(facCode);
	}

	@Override
	public int facRegister(FacInfoVO vo) {
		// 설비등록
		return mapper.facRegister(vo);

	}

	@Override
	public int facUpdate(FacInfoListVO list) {
		//해당설비 공정삭제
		 mapper.facConnProcDelete(list.getList().get(0).getFacCode());
		//공정수정
		 mapper.insertProcList(list);
		// 설비수정
		return mapper.facUpdate(list.getList().get(0));

	}

	@Override
	public int facDelete(FacInfoVO vo) {
		// 설비삭제
		return mapper.facDelete(vo);
	}

	@Override
	public int insertFacList(FacInfoListVO list) {
		// 설비+공정등록
		return mapper.insertFacList(list);
	}

	@Override
	public List<FacConnProcVO> getFacConnProcList(String facCode) {
		// 설비별 공정조회
		return mapper.getFacConnProcList(facCode);
	}

	@Override
	public int insertConfirmList(FacConfirmVO list) {
		// 점검등록
		return mapper.insertConfirmList(list);
	}

	@Override
	public int confirmUpdate(FacConfirmVO list) {
		// 점검수정
		return mapper.confirmUpdate(list);
	}

	@Override
	public int confirmDelete(FacConfirmVO vo) {
		// 점검삭제
		return mapper.confirmDelete(vo);
	}

	@Override
	public List<FacConfirmVO> confirmdaysSearchAjax(FacConfirmVO vo) {
		//점검기간별 조회
		return mapper.confirmdaysSearchAjax(vo);
	}

	@Override
	public List<FacDownTimeVO> getDownTimeList(FacDownTimeVO vo) {
		// 설비비가동조회
		return mapper.getDownTimeList(vo);
	}

	

}

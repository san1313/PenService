package com.pen.app.bns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.service.BnsService;
import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsEmpVO;
import com.pen.app.bns.vo.BnsOrdDetListVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;

@Service
public class BnsServiceImpl implements BnsService {

   @Autowired BnsMapper mapper;

   @Override
   public List<BnsOrdVO> getOrdList() {
      return mapper.getOrdList();
   }

   //주문서 등록
  

   @Override
   public List<BnsAccVO> getAccList() {
      return mapper.getAccList();
   }

   @Override
   public List<BnsProdVO> getProdList() {
      return mapper.getProdList();
   }

   @Override
   public List<BnsAccVO> getAccKeyList(String keyword) {
      return mapper.getAccKeyList(keyword);
   }

   @Override
   public List<BnsProdVO> getProdKeyList(String keyword) {
      return mapper.getProdKeyList(keyword);
   }



   @Override
   public List<BnsOrdVO> getOrdListCon(BnsOrdVO vo) {
      return mapper.getOrdListCon(vo);
   }

	



	@Override
		public int insertOrdList(List<BnsOrdVO> list) {
			return mapper.insertOrdList(list);
		}

	

   
}
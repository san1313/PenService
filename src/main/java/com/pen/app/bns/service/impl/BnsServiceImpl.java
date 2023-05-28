package com.pen.app.bns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.bns.mapper.BnsMapper;
import com.pen.app.bns.service.BnsService;
import com.pen.app.bns.vo.BnsAccVO;
import com.pen.app.bns.vo.BnsContVO;
import com.pen.app.bns.vo.BnsOrdVO;
import com.pen.app.bns.vo.BnsProdVO;
import com.pen.app.bns.vo.BnsStoreListVO;
import com.pen.app.bns.vo.BnsStoreVO;

@Service
public class BnsServiceImpl implements BnsService {

   @Autowired BnsMapper mapper;

   //--------------주문서
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

	//주문서 수정 모달창 내의 제품 리스트
	@Override
	public List<BnsOrdVO> getProdModList(String keyword) {
		return mapper.getProdModList(keyword);
	}

	//주문서 수정
	@Override
		public int modOrdList(List<BnsOrdVO> list) {
			return mapper.modOrdList(list);
		}
	
	//주문상세 삭제
	@Override
		public void delOrdDetList(List<BnsOrdVO> list) {
		
		}
	
	//주문서 취소
	@Override
		public void delOrdList(List<BnsOrdVO> list) {
			
		}
		
	
	// ---------------------계약서
		@Override
			public List<BnsContVO> getContList() {
			return mapper.getContList();
			}

		@Override
		public List<BnsContVO> getContListCon(BnsContVO vo) {
			return mapper.getContListCon(vo);
		}

		@Override
		public int insertContList(List<BnsContVO> list) {
			return mapper.insertContList(list);
		}

		@Override
		public int modContList(List<BnsContVO> list) {
			return mapper.modContList(list);
		}

		@Override
		public void delContDetList(List<BnsContVO> list) {
		}

		@Override
		public List<BnsContVO> getContProdModList(String keyword) {
			return mapper.getContProdModList(keyword);
		}

		@Override
			public void delContList(List<BnsContVO> list) {
				
			}

		//입고
		
		//입고 전 그리드
		@Override
		public List<BnsStoreVO> getbeforeStoreList() {
			return mapper.getbeforeStoreList();
		}
		
		//입고 후 그리드
		@Override
			public List<BnsStoreVO> getafterStoreList() {
				return mapper.getafterStoreList();
			}
		
		@Override
			public void insertStoreList(BnsStoreListVO list) {
				for(int i=0; i<list.getList().size(); i++) {
					
					mapper.insertStore(list.getList().get(i));
				}
			}

		@Override
		public void delStoreList(BnsStoreListVO list) {
			for(int i=0; i<list.getList().size(); i++) {
				
				mapper.delStoreList(list.getList().get(i));
			}
		}

		
}
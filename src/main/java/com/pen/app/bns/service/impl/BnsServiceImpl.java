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
import com.pen.app.bns.vo.BnsReleaseListVO;
import com.pen.app.bns.vo.BnsReleaseVO;
import com.pen.app.bns.vo.BnsStoreListVO;
import com.pen.app.bns.vo.BnsStoreVO;

@Service
public class BnsServiceImpl implements BnsService {

   @Autowired BnsMapper mapper;

   //--------------주문서
   //주문서 페이지
   @Override
   public List<BnsOrdVO> getOrdList() {
      return mapper.getOrdList();
   }
   //주문서코드자동생성
   @Override
	public BnsOrdVO getOrdCode() {
		return mapper.getOrdCode();
	}
   //거래처리스트
   @Override
   public List<BnsAccVO> getAccList() {
      return mapper.getAccList();
   }
   //제품리스트
   @Override
   public List<BnsProdVO> getProdList() {
      return mapper.getProdList();
   }
   //거래처 검색
   @Override
   public List<BnsAccVO> getAccKeyList(String keyword) {
      return mapper.getAccKeyList(keyword);
   }
   //제품 검색
   @Override
   public List<BnsProdVO> getProdKeyList(String keyword) {
      return mapper.getProdKeyList(keyword);
   }
   //주문서 조건검색
   @Override
   public List<BnsOrdVO> getOrdListCon(BnsOrdVO vo) {
      return mapper.getOrdListCon(vo);
   }
   //주문서 등록
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
		mapper.delOrdDetList(list);
		}
	//주문서 취소
	@Override
		public void delOrdList(List<BnsOrdVO> list) {
		mapper.delOrdList(list);
		}
	// ---------------------계약서
	@Override
	//계약코드 자동생성
		public List<BnsContVO> getContCode() {
			return mapper.getContCode();
		}
	//계약서 관리페이지 
		@Override
		public List<BnsContVO> getContList() {
		return mapper.getContList();
		}
		//계약서 조건 검색
		@Override
		public List<BnsContVO> getContListCon(BnsContVO vo) {
			return mapper.getContListCon(vo);
		}
		//계약서 등록
		@Override
		public int insertContList(List<BnsContVO> list) {
			return mapper.insertContList(list);
		}
		//계약서 수정
		@Override
		public int modContList(List<BnsContVO> list) {
			return mapper.modContList(list);
		}
		//계약서 모달창 내 제품 수정
		@Override
		public void delContDetList(List<BnsContVO> list) {
			mapper.delContDetList(list);
		}
		//계약서 모달창 내 제품모달창
		@Override
		public List<BnsContVO> getContProdModList(String keyword) {
			return mapper.getContProdModList(keyword);
		}
		//계약서 취소
		@Override
		public void delContList(List<BnsContVO> list) {
			mapper.delContList(list);
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
		//입고등록
		@Override
			public void insertStoreList(BnsStoreListVO list) {
				for(int i=0; i<list.getList().size(); i++) {
					
					mapper.insertStore(list.getList().get(i));
				}
			}
		//입고취소
		@Override
		public void delStoreList(BnsStoreListVO list) {
			for(int i=0; i<list.getList().size(); i++) {
				
				mapper.delStoreList(list.getList().get(i));
			}
		}

		
//출고
		
		//출고전 계약상황리스트
		@Override
			public List<BnsReleaseVO> getbeforeReleaseContList() {
				return mapper.getbeforeReleaseContList();
			}
		//출고전 주문상황리스트
		@Override
			public List<BnsReleaseVO> getbeforeReleaseOrdList() {
				return mapper.getbeforeReleaseOrdList();
			}
		//출고대기 LOT리스트
		@Override
			public List<BnsReleaseVO> getLotReleaseList(String keyword) {
				return mapper.getLotReleaseList(keyword);
			}
		//출고등록
		@Override
			public void insertReleaseList(BnsReleaseListVO list) {
			for(int i=0; i<list.getList().size(); i++) {
				
				mapper.insertRelease(list.getList().get(i));
			}
			}
		
		//출고내역 페이지
		@Override
			public List<BnsReleaseVO> getSearchReleaseList() {
				return mapper.getSearchReleaseList();
			}

		
}
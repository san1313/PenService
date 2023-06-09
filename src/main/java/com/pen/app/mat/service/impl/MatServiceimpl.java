package com.pen.app.mat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mat.mapper.MatMapper;
import com.pen.app.mat.service.MatService;
import com.pen.app.mat.vo.AdjustVO;
import com.pen.app.mat.vo.DisposeResultVO;
import com.pen.app.mat.vo.DlivyVO;
import com.pen.app.mat.vo.HoldVO;
import com.pen.app.mat.vo.InventoryVO;
import com.pen.app.mat.vo.MatOrdVO;
import com.pen.app.mat.vo.OrderVO;
import com.pen.app.mat.vo.WarehousingVO;

@Service
public class MatServiceimpl implements MatService {

	@Autowired
	MatMapper matmapper;

	@Override
	public void orderregister(OrderVO order) {

	}

	@Override
	public List<OrderVO> getmatlist(String accName) {
		// 모달자재목록
		return matmapper.getmatlist(accName);
	}

	@Override
	public List<OrderVO> getmatminilist(String keyword) {
		// 모달자재검색
		return matmapper.getmatminilist(keyword);
	}

	@Override
	public List<OrderVO> getacclist(String matName) {
		// 모달거래처목록
		return matmapper.getacclist(matName);
	}

	@Override
	public List<OrderVO> getaccminilist(String keyword) {
		// 모달거래처검색
		return matmapper.getaccminilist(keyword);
	}

	@Override
	public String getmatordercode() {
		// 발주번호
		return matmapper.getmatordercode();
	}

	@Override
	public void getmatregister(List<OrderVO> list) {
		// 발주등록
		matmapper.getmatregister(list);
	}

	@Override
	public List<OrderVO> gettodaymatregister() {
		// 당일발주등록리스트
		return matmapper.gettodaymatregister();
	}
	
	@Override
	public List<OrderVO> getorderlistmodal() {
		// 수정발주리스트모달
		return matmapper.getorderlistmodal();
	}
	
	@Override
	public List<OrderVO> getordlistsearchmodal(OrderVO vo) {
		// 발주등록리스트모달다중검색
		return matmapper.getordlistsearchmodal(vo);
	}
	
	@Override
	public void getordmodify(MatOrdVO list) {
		// 발주수정
		
		for(int i = 0; i<list.getList().size(); i++) {
			
			matmapper.getordmodify(list.getList().get(i));
		}
		
	}
	
	@Override
	public void getdeleteord(MatOrdVO list) {
		// 발주삭제
		for(int i = 0; i<list.getList().size(); i++) {
			
			matmapper.getdeleteord(list.getList().get(i));
		}
	}

	@Override
	public List<OrderVO> getorderlistajax() {
		// 발주등록조회페이지
		return matmapper.getorderlistajax();
	}

	@Override
	public List<OrderVO> getorderlistsearchajax(OrderVO vo) {
		// 발주조회다중검색
		return matmapper.getorderlistsearchajax(vo);
	}

	@Override
	public List<WarehousingVO> getestwarehousinglist() {
		// 자재입고 검사내역리스트
		return matmapper.getestwarehousinglist();
	}

	//여러건의 통신 발생 시 통신 장애 발생의 경우 이전+이후 통신들의 무효처리
	@Override
	@Transactional
	public String getwarehousingregister(List<WarehousingVO> list) {
		//자재입고량 총합을 받아서 입력하기 위해 사용
		int sum = 0;
		//crud의 경우 리턴값은 디폴트로 숫자임으로 리턴되는 결과값을 받아오기 위해 사용
		int j =0;
		String result = "";
		// 입고량을 재고량으로 지정
		for (WarehousingVO in : list) {
			sum += in.getMatWrhqy();
		}
		list.get(0).setMatQnt(sum);

		// 자재입고등록. 총합격량을 입고량으로 지정
		for (int i = 0; i < list.size(); i++) {
			int pass = list.get(i).getTestTnumPass();
			list.get(i).setMatWrhqy(pass);
		}
		for (WarehousingVO in : list) {
			j+=matmapper.getwarehousingregister(in);
			//로트번호 조회해서 셋팅
			in.setMatLot(matmapper.getMatLotWarehousing()); 
			matmapper.getmativntryregister(in);
		}
		if(j>0) {
			result = "입고성공";
		}
		return result; 
	}

	@Override
	public List<WarehousingVO> gettodaywarehousinglist() {
		// 자재입고리스트 당일건
		return matmapper.gettodaywarehousinglist();
	}
	
	@Override
	public List<WarehousingVO> getwarehousingsearchajax(WarehousingVO vo) {
		// 자재입고 다중검색 리스트
		return matmapper.getwarehousingsearchajax(vo);
	}

	@Override
	public List<WarehousingVO> getwarehousingmatlistajax() {
		// 자재입고조회
		return matmapper.getwarehousingmatlistajax();
	}


	@Override
	public List<InventoryVO> getinventorysearch(String keyword) {
		// 자재재고조회 자재코드 검색
		return matmapper.getinventorysearch(keyword);
	}

	@Override
	public List<InventoryVO> getinventorysearchlot(String matCode) {
		// 자재재고조회 lot
		return matmapper.getinventorysearchlot(matCode);
	}

	@Override
	public List<DlivyVO> getmatdlivylist() {
		// 자재출고리스트
		return matmapper.getmatdlivylist();
	}

	@Override
	public List<DlivyVO> getmatdlivysearchlist(DlivyVO vo) {
		// 자재출고리스트 다중검색
		return matmapper.getmatdlivysearchlist(vo);
	}

	@Override
	public List<AdjustVO> getmatadjustlotlist() {
		// 자재조정lot 리스트
		return matmapper.getmatadjustlotlist();
	}
	@Override
	public List<AdjustVO> getmatadjustsearch(AdjustVO vo) {
		// 자재조정 자재코드 검색
		return matmapper.getmatadjustsearch(vo);
	}

	@Override
	public List<AdjustVO> getmatadjustlot(String matLot) {
		// 자재조정lot상세
		return matmapper.getmatadjustlot(matLot);
	}

	@Override
	public void getmatadjustregister(List<AdjustVO> list) {
		// 조정등록(입고)
		for (AdjustVO vo : list) {
			matmapper.getmatadjustregister(vo);
		}
		
	}

	@Override
	public void getmatadjustdliregister(List<AdjustVO> list) {
		// 조정등록(출고)
		for (AdjustVO vo : list) {
			matmapper.getmatadjustdliregister(vo);
		}
		
	}

	@Override
	public List<AdjustVO> getallmatadjustlist() {
		// 자재조정조회리스트
		return matmapper.getallmatadjustlist();
	}

	@Override
	public List<AdjustVO> getmatadjustsearchlist(AdjustVO vo) {
		// 자재조정리스트 다중검색
		return matmapper.getmatadjustsearchlist(vo);
	}

	@Override
	public List<DisposeResultVO> getdisposeresultlist() {
		// 폐기자재조회리스트
		return matmapper.getdisposeresultlist();
	}

	@Override
	public List<DisposeResultVO> getdisposeresultsearchlist(DisposeResultVO vo) {
		// 폐기자재조회다중검색
		return matmapper.getdisposeresultsearchlist(vo);
	}
	

	@Override
	public void getdisposeresultlistresu(List<DisposeResultVO> list) {
		// 결과반영
		for (DisposeResultVO vo: list) {
			matmapper.getdisposeresultlistresu(vo);
		}
	}

	@Override
	public void getmatoptionholdregister(List<HoldVO> list) {
		// 임의해제 등록
		for (HoldVO vo : list) {
			matmapper.getmatoptionholdregister(vo);
			
		}
			
	}

	@Override
	public List<HoldVO> getallmatoptionholdlist() {
		// 임의해제리스트
		return matmapper.getallmatoptionholdlist();
	}

	@Override
	public List<HoldVO> getmatoptionholdsearchlist(HoldVO vo) {
		//임의해제 다중검색
		return matmapper.getmatoptionholdsearchlist(vo);
	}

	

	

	





}

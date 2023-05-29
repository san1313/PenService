package com.pen.app.mak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mak.mapper.MakMapper;
import com.pen.app.mak.service.MakService;
import com.pen.app.mak.vo.PlanListVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakServiceImpl implements MakService {

@Autowired MakMapper mapper;


@Override
@Transactional
public List<PlanVO> getPlanList() {
	List<PlanVO> list = mapper.getPlanList();
	for(int i=0;i<list.size();i++) {
		System.out.println(list.size());
		System.out.println("조회된 list : "+list);
		String contDetCode = list.get(i).getContDetCode();
		System.out.println("조회된 코드 : "+contDetCode);
		int count = mapper.getContCount(contDetCode);
		System.out.println("각 계약건수 : "+count);
		if(count>1) {
			list.get(i).setContDetQuan(mapper.getLeftQuan(contDetCode));
			System.out.println("잔류수량 삽입 : "+list.get(i));
		}else if(count<=0) {
			System.out.println("조회조건 이상");
		}
	}
	return list;
}

@Override
public List<PlanVO> getCont() {
	List<PlanVO> list = mapper.getCont();
	return list;
}

@Override
public List<PlanVO> getConnect(String detc) {
	List<PlanVO> list = mapper.getConnect(detc);
	return list;
}

@Override
public List<PlanVO> getPlanning(String detc) {
	List<PlanVO> vo = mapper.getPlanning(detc);
	return vo;
}

@Override
public List<PlanVO> getContr(ArrayList<String> detCoList) {
	List<PlanVO> list = mapper.getContr(detCoList);
	return list;
}

@Override
@Transactional
public int insertPlan(PlanListVO vo) {
	int result = mapper.insertPlan(vo.getPlanList().get(0));
	for(int i=0; i<vo.getPlanList().size();i++) {
	result += mapper.insertDetailPlan(vo.getPlanList().get(i));
	result += mapper.setPlanCont(vo.getPlanList().get(i));
	};
	return result;
}

@Override
@Transactional
public String delPlan(PlanVO vo) {
	String result = "";
	mapper.delConPlan(vo.getConnectCode());
	int j=mapper.delDPlan(vo.getPdCode());
	if(j>0) {
		result="생산계획상세서 "+j+"건 삭제 되었습니다.";
	};
	int count=mapper.getPdCount(vo.getPlanCode()); 
	if(count==0) {		
		if(mapper.delPlan(vo.getPlanCode())>0) {
			result = "생산계획상세서 "+j+"건,\n생산계획서 1건 삭제 되었습니다.";
		};
	};
	return result;
}

@Override
public int modPlan(PlanVO vo) {
	int result = mapper.modPlan(vo);
	return result;
}

@Override
@Transactional
public List<PlanVO> selectPlan(PlanVO vo) {
	List<PlanVO> list = mapper.getPlanningList(vo);
	for(int i=0;i<list.size();i++) {
		System.out.println(list.size());
		System.out.println("조회된 list : "+list);
		String contDetCode = list.get(i).getContDetCode();
		System.out.println("조회된 코드 : "+contDetCode);
		int count = mapper.getContCount(contDetCode);
		System.out.println("각 계약건수 : "+count);
		if(count>1) {
			list.get(i).setContDetQuan(mapper.getLeftQuan(contDetCode));
			System.out.println("잔류수량 삽입 : "+list.get(i));
		}else if(count<=0) {
			System.out.println("조회조건 이상");
		}
	}
	return list;
}

@Override
@Transactional
public List<PlanVO> getOrdList() {
	
		List<PlanVO> list = mapper.getOrdList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.size());
			System.out.println("조회된 list : "+list);
			String contDetCode = list.get(i).getOrdDetCode();
			System.out.println("조회된 코드 : "+contDetCode);
			int count = mapper.getOrdCount(contDetCode);
			System.out.println("각 계약건수 : "+count);
			if(count>1) {
				list.get(i).setContDetQuan(mapper.getLeaveQuan(contDetCode));
				System.out.println("잔류수량 삽입 : "+list.get(i));
			}else if(count<=0) {
				System.out.println("조회조건 이상");
			}
		}
		return list;
}

@Override
@Transactional
public int insertOrd(PlanListVO vo) {
	//생산 계획서 등록
	int result = mapper.insertOrd(vo.getPlanList().get(0));
	for(int i=0; i<vo.getPlanList().size();i++) {
		//생산계획 상세 등록
		result += mapper.insertDetailPlan(vo.getPlanList().get(i));
		//생산계획과 참고 테이블 등록
		result += mapper.setPlanOrd(vo.getPlanList().get(i));
		//주문상세에 작업상태에 대한 업데이트
		result += mapper.updateOrd(vo.getPlanList().get(i).getOrdDetCode());
	};
	return result;
}

@Override
@Transactional
public String delOrd(PlanVO vo) {
	String result = "";
	mapper.delConPlan(vo.getConnectCode());
	int j=mapper.delDPlan(vo.getPdCode());
	if(j>0) {
		result="생산계획상세서 "+j+"건 삭제 되었습니다.";
	};
	int count=mapper.getPdCount(vo.getPlanCode()); 
	if(count==0) {		
		if(mapper.delPlan(vo.getPlanCode())>0) {
			result = "생산계획상세서 "+j+"건,\n생산계획서 1건 삭제 되었습니다.";
		};
	};
	if(mapper.getOrdCount(vo.getOrdDetCode())==0) {
		mapper.updateOrder(vo.getOrdDetCode());
	};
	return result;
}


@Override
@Transactional
public List<PlanVO> selectOrd(PlanVO vo) {
	List<PlanVO> list = mapper.getOrderingList(vo);
	for(int i=0;i<list.size();i++) {
		System.out.println(list.size());
		System.out.println("조회된 list : "+list);
		String contDetCode = list.get(i).getOrdDetCode();
		System.out.println("조회된 코드 : "+contDetCode);
		int count = mapper.getOrdCount(contDetCode);
		System.out.println("각 계약건수 : "+count);
		if(count>1) {
			list.get(i).setContDetQuan(mapper.getLeaveQuan(contDetCode));
			System.out.println("잔류수량 삽입 : "+list.get(i));
		}else if(count<=0) {
			System.out.println("조회조건 이상");
		}
	}
	return list;
}

@Override
public List<PlanVO> getOrder(ArrayList<String> detCoList) {
	List<PlanVO> list = mapper.getOrder(detCoList);
	return list;
}

@Override
@Transactional
public List<PlanVO> selectOrdList(PlanVO vo) {
	List<PlanVO> list = mapper.getOrderingList(vo);
	for(int i=0;i<list.size();i++) {
		System.out.println(list.size());
		System.out.println("조회된 list : "+list);
		String contDetCode = list.get(i).getOrdDetCode();
		System.out.println("조회된 코드 : "+contDetCode);
		int count = mapper.getOrdCount(contDetCode);
		System.out.println("각 계약건수 : "+count);
		if(count>1) {
			list.get(i).setContDetQuan(mapper.getLeaveQuan(contDetCode));
			System.out.println("잔류수량 삽입 : "+list.get(i));
		}else if(count<=0) {
			System.out.println("조회조건 이상");
		}
	}
	return list;
}


}

package com.pen.app.mak.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pen.app.mak.mapper.MakIndMapper;
import com.pen.app.mak.service.MakIndService;
import com.pen.app.mak.vo.IndicaListVO;
import com.pen.app.mak.vo.MakVO;
import com.pen.app.mak.vo.PlanVO;

@Service
public class MakIndServiceImpl implements MakIndService{
	@Autowired MakIndMapper mapper;
	
	//
	@Override
	@Transactional
	public List<PlanVO> planning() {
		List<MakVO> remain = mapper.getOrdReQnt();
		List<MakVO> conRe = mapper.getConReQnt();
		
		//주문서기반
		List<PlanVO> list = mapper.ordPlanning(remain);
		//계약서기반
		list.addAll(mapper.contPlanning(conRe));
		for (MakVO vo : remain) {
			List<PlanVO> result = mapper.ordPlanned(vo);
			for (PlanVO plan : result) {
				if(plan.getReQnt()!=0) {
					list.add(plan);
				}
			};
		}
		for (MakVO vo : conRe) {
			List<PlanVO> result = mapper.contPlanned(vo);
			for (PlanVO plan : result) {
				if(plan.getReQnt()!=0) {
					list.add(plan);
				}
			};
		}		
		return list;
	}

	@Override
	public List<MakVO> indList() {
		List<MakVO> remain = mapper.getIndReQnt();
		List<MakVO> result = new ArrayList<>();
		for (MakVO vo : remain) {
			List<MakVO> Make = mapper.indList(vo.getPdCode());
			for (MakVO vo2 : Make) {
				vo2.setReQnt(vo.getReQnt());
			};
			result.addAll(Make);
			
		}
		
		return result;
	}

	//필요자재 조회
	@Override
	public List<MakVO> planFlow(String prodCode) {
		List<MakVO> result =mapper.planFlow(prodCode);
		for (MakVO vo : result) {
			for (MakVO innervo : result) {
				//다음 산출물 여부 확인
				if(vo.getParentCode()!=null) {
					//부모 제품의 자재소모율 가져오기 위한 코드
				if(vo.getParentCode().equals(innervo.getBomProdCode())) {
					//부모 제품의 자재소모율을 자식 제품의 자재소모율에 곱셈
					if(innervo.getBomMatUsage()>0) {
					vo.setBomMatUsage(vo.getBomMatUsage()*innervo.getBomMatUsage());
					}
				}
				}
			}
		}
		return result;
	}


	//공정조회
	@Override
	public List<MakVO> getFlowList(IndicaListVO list) {
		List<MakVO> condi = list.getList();
		return mapper.getFlowList(condi);
	}

	@Override
	public List<MakVO> getOperateCheck(IndicaListVO list) {
		List<MakVO> condi = list.getList();
		return mapper.getOperateCheck(condi);
	}

	/* 지시서 등록, 생산공정 등록, hold등록, bom등록, 자재재고 업데이트 */
	@Override
	@Transactional
	public String insertIndica(IndicaListVO list) {
		String result="";
		int j = 999;
		for(int i=0;i<list.getList().size();i++) {
			if(list.getList().get(i).getAmount()>0) {
				if(j>i) {
				j=i;
				}
			}
		}
		mapper.insertIndica(list.getList().get(j));
		int k=0;
		Map<Object,Integer> step = new HashMap<>();
		for (MakVO vo : list.getList()) {
		if(vo.getMakFlowStep()>0) {
				k+=mapper.insertFlow(vo);
				int seq = mapper.getFlowSeq();
				step.put(vo.getProcCode(),seq);
				step.put(seq, vo.getMakFlowStep());
			}else if(vo.getAmount()>0) {
				vo.setMakFlowCode(step.get(vo.getProcCode()));
				vo.setMakStep(step.get(vo.getMakFlowCode()));
				
				for (MakVO innervo : list.getList()) {
					if(innervo.getAmount()>0) {
						if(innervo.getBomProdCode()!=null||vo.getResultCode()!=null) {
						if(vo.getResultCode().equals(innervo.getBomProdCode())) {
							if(innervo.getBomMatUsage()>0) {
								System.err.println(vo.getBomMatUsage());
								System.err.println(innervo.getBomMatUsage());
							vo.setBomMatUsage(Math.round(vo.getBomMatUsage()/innervo.getBomMatUsage()));
							}
							}
						}
					}
				};
				
				k+=mapper.insertBOM(vo);
			};
		};
		List<MakVO> bomList = mapper.getCurrBom();
		List<MakVO> matQnt = new ArrayList<>();
		for(MakVO vo : bomList) {
			matQnt=mapper.getMatQnt(vo.getProdCode());
			if(matQnt.get(0).getMatQnt()<vo.getAmount()) {
			for(MakVO vo2 : matQnt) {
				if(vo.getAmount()>vo2.getMatQnt()) {
				vo.setAmount(vo.getAmount()-vo2.getMatQnt());
				vo2.setCnt(vo2.getMatQnt());
				k+=mapper.insertHold(vo2);
				k+=mapper.updateMat(vo2);
				}else if(vo.getAmount()<vo2.getMatQnt()) {
					vo2.setCnt(vo.getAmount());
					k+=mapper.insertHold(vo2);
					k+=mapper.updateMat(vo2);
				}
				
				}
			}else {
				matQnt.get(0).setCnt(vo.getAmount());
				k+=mapper.insertHold(matQnt.get(0));
				k+=mapper.updateMat(matQnt.get(0));
			}
		}
		if(k>0) {
			result = "등록성공";
		}
		return result;
	}

	@Override
	public List<MakVO> getIndicatedBom(String indicaCode) {
		List<MakVO> list = mapper.getIndicatedBom(indicaCode);
		for (MakVO vo : list) {
			for(MakVO innervo : list) {
				if(vo.getParentCode().equals(innervo.getBomProdCode())) {
					vo.setBomMatUsage(vo.getBomMatUsage()*innervo.getBomMatUsage());
				}
			}
			
		}
				
		return list;
	}

	/* 지시서 수정,hold수정,자재재고수정,bom 수정,공정 수정 */
	@Override
	@Transactional
	public String updateIndica(IndicaListVO list) {
		int a = 0;
		String result = "";
		Map<Object,Integer> map = new HashMap<>();
		a+=mapper.updateIndica(list.getList().get(0));
		for (MakVO vo : list.getList()) {
			a+=mapper.updateMakBom(vo);
			/* 차이나는 값 합산 */
			if(map.containsKey(vo.getBomProdCode())) {
				map.put(vo.getBomProdCode(),(map.get(vo.getBomProdCode())) +vo.getReQnt());
			}else {
				map.put(vo.getBomProdCode(), vo.getReQnt());
			}
		};
		List<MakVO> remain = mapper.getIndMakHold(list.getList().get(0).getIndicaCode());
		for(MakVO vo : remain) {
			vo.setCnt(map.get(vo.getMatCode()));
			a+=mapper.updateIndMakHold(vo);
			a+=mapper.updateIndMakMat(vo);
		}
		if(a>0) {
			result="수정성공";
		}
		return result;
	}

	/* 지시서삭제, bom삭제,공정삭제,자재재고수정,hold삭제 */
	@Override
	@Transactional
	public String delIndica(IndicaListVO list) {
		String result="";
		int a = mapper.delIndica(list.getList().get(0));
		List<MakVO> bomList = mapper.getIndicatedBom(list.getList().get(0).getIndicaCode());
		for (MakVO vo : bomList) {
			a+=mapper.delIndFlow(vo.getMakFlowCode());
			a+=mapper.delIndBom(vo.getMakBomCode());
		}
		List<MakVO> holdList = mapper.getIndMakHold(list.getList().get(0).getIndicaCode());
		for (MakVO vo : holdList) {
			a+=mapper.updateIndMakMat(vo);
		}
		a+= mapper.delIndHold(list.getList().get(0).getIndicaCode());
		if(a>0) {
			result="삭제성공";
		}else {
			result="실패";
		}
		return result;
	}

	@Override
	public List<MakVO> dirIndList() {
		// TODO Auto-generated method stub
		return mapper.dirIndList();
	}
	
	/* 작업상태 변경<<공정실적 있는 경우&없는 경우 */
	@Override
	public List<MakVO> oerfProcList(String indicaCode) {
		// TODO Auto-generated method stub
		List<MakVO> list = mapper.oerfProcList(indicaCode);
		for (MakVO vo : list) {
			int i = mapper.getProcProdCount(vo);
			if(i>0) {
				int j = mapper.getProcReCnt(vo);
				if(j>0) {
					vo.setIndicaState("작업중");
				}else {
					vo.setIndicaState("작업완료");
				}
			}else {
				vo.setIndicaState("미작업");
			}
		}
		return list;
	}

	@Override
	@Transactional
	public List<MakVO> getProcList(MakVO vo) {
		List<MakVO> list = mapper.getAllProcMat(vo);
		for (MakVO re : list) {
			vo.setProdCode(re.getResultCode());
			Integer i =mapper.getResultUsage(vo);
			if(i!=null) {
			re.setOrdrQnt(re.getOrdrQnt()*i);
			};
		};
		
		
		list.addAll(mapper.getProcFac(vo.getProcCode()));
		return list;
	}

	/* 공정실적 등록,지시서 수정 */
	@Override
	@Transactional
	public List<MakVO> insertProcProd(MakVO vo) {
		if(vo.getProdCode().substring(0,4).equals("SEMI")) {
		vo.setProdNm((mapper.selectSemi(vo.getProdCode())).getSemiName());
		}else if(vo.getProdCode().substring(0,4).equals("PROD")){
			vo.setProdNm((mapper.selectProd(vo.getProdCode())).getProdName());
		}
		if(mapper.insertProcProd(vo)>0) {
			if(mapper.updateProcInd(vo.getIndicaCode())>0) {
				return mapper.perfIndList();
				
			};
		};
		return null;
	}

	/* 공정실적 수정, 자재출고 등록, hold 수정  + a [홀드 등록, 완제품 등록]*/
	@Override
	@Transactional
	public String updateProcProd(IndicaListVO list) {
		int i =0;
		String prcsCode = mapper.getProcProd(list.getList().get(0));
		list.getList().get(0).setPrcsCode(prcsCode);
		//홀드에 생산품 넣기
		if(list.getList().get(0).getProdCode().substring(0,4).equals("SEMI")) {
			i+=mapper.insertProcSemiHold(list.getList().get(0));
		};
		//홀드테이블 해당 자재 조회 및 list에 손보기
		List<MakVO> remain = mapper.getIndMakHold(list.getList().get(0).getIndicaCode());
		for (MakVO vo : list.getList()) {
			
			for (MakVO innerVo : remain) {
				if(innerVo.getMatCode().equals(vo.getMatCode())) {
					if(innerVo.getCnt()>=vo.getCnt()) {
					vo.setMatLot(innerVo.getMatLot());
					vo.setRscCode(innerVo.getRscCode());
					i+=mapper.updateIndMakHold(vo);
					i+=mapper.insertMatDlivy(vo);
					}else {
						i+=mapper.updateIndMakHold(innerVo);
						vo.setCnt(vo.getCnt()-innerVo.getCnt());
						innerVo.setEmpNum(vo.getEmpNum());
						innerVo.setMatName(vo.getMatName());
						i+=mapper.insertMatDlivy(innerVo);
					}
					
				}
			}
			
		};
		for (MakVO vo : list.getList()) {
			Integer j = mapper.getResultUsage(vo);
			if(j!=null) {
				vo.setProdCnt(vo.getProdCnt()/j);
			}
		}
		//홀드랑 출고내역 업데이트
		mapper.updateProcProd(list.getList().get(0));
		
		
		if(list.getList().get(0).getProdCode().substring(0,4).equals("PROD")) {
			//완제품에 생산품 넣기
			i+=mapper.insertProcPrdt(list.getList().get(0));
			i+=mapper.updateProcIndica(list.getList().get(0));
			
			
		};
		String result="";
		if(i>0) {
			result="성공";
		}
		return result;
	}

	@Override
	public List<MakVO> getProcProdInfo(MakVO vo) {
		
		return mapper.getProcProdInfo(vo);
	}



}

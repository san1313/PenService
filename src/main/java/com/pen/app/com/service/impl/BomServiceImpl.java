package com.pen.app.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.mapper.BomMapper;
import com.pen.app.com.service.BomService;
import com.pen.app.com.vo.BomVO;
import com.pen.app.com.vo.ItemVO;

@Service
public class BomServiceImpl implements BomService {

	@Autowired
	BomMapper mapper;
	
	@Override
	public List<BomVO> getBomList(String itemCode) {
		
		return mapper.getBomList(itemCode);
	}
	
	@Override
	public List<Map<String, String>> getBomProcList(String itemCode) {
		
		return mapper.getBomProcList(itemCode);
	}
	
	@Override
	public List<ItemVO> getBomMatList() {
		
		return mapper.getBomMatList();
	}
	
	@Override
	public List<ItemVO> getBomMatWithName(String itemName) {
		
		return mapper.getBomMatWithName(itemName);
	}
	
	@Override
	public ToastUiResponseDTO modifyBomList(Map<String, List<BomVO>> modifiedRows) {
		String result = "Success";
		List<BomVO> updatedRows = modifiedRows.get("updatedRows");
		List<BomVO> createdRows = modifiedRows.get("createdRows");
		List<BomVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyBomList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertBomList(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteBomList(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}
}

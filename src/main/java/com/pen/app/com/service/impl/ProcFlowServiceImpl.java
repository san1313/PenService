package com.pen.app.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.mapper.ProcFlowMapper;
import com.pen.app.com.service.ProcFlowService;
import com.pen.app.com.vo.ProcFlowVO;

@Service
public class ProcFlowServiceImpl implements ProcFlowService {

	@Autowired
	ProcFlowMapper mapper;

	@Override
	public List<Map<String, String>> getFlowItemList() {

		return mapper.getFlowItemList();
	}

	@Override
	public List<Map<String, String>> getFlowItemListWithName(String itemName) {

		return mapper.getFlowItemListWithName(itemName);
	}

	@Override
	public List<ProcFlowVO> getFlowList(String itemCode) {

		return mapper.getFlowList(itemCode);
	}

	@Override
	public ToastUiResponseDTO modifyFlowList(Map<String, List<ProcFlowVO>> modifiedRows) {
		String result = "Success";
		List<ProcFlowVO> updatedRows = modifiedRows.get("updatedRows");
		List<ProcFlowVO> createdRows = modifiedRows.get("createdRows");
		List<ProcFlowVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyFlowList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertFlowList(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteFlowList(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}
}

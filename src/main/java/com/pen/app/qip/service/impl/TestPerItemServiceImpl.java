package com.pen.app.qip.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.qip.mapper.TestPerItemMapper;
import com.pen.app.qip.service.TestPerItemService;
import com.pen.app.qip.vo.TestItemVO;
import com.pen.app.qip.vo.TestPerItemVO;

@Service
public class TestPerItemServiceImpl implements TestPerItemService{
	@Autowired
	TestPerItemMapper mapper;

	@Override
	public List<TestItemVO> getTestItemList() {
		
		return mapper.getTestItemList();
	}

	@Override
	public List<TestItemVO> getTestItemWithName(String itemName) {
		
		return mapper.getTestItemWithName(itemName);
	}
	
	@Override
	public List<TestPerItemVO> getTPIList(String itemCode) {
		
		return mapper.getTPIList(itemCode);
	}

	@Override
	public ToastUiResponseDTO modifyTCode(Map<String, List<TestPerItemVO>> modifiedRows) {
		String result = "Success";
		List<TestPerItemVO> updatedRows = modifiedRows.get("updatedRows");
		List<TestPerItemVO> createdRows = modifiedRows.get("createdRows");
		List<TestPerItemVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyTPI(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertTPI(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteTPI(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}
	
	
}

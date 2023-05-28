package com.pen.app.qip.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.vo.ProcessVO;
import com.pen.app.qip.mapper.TestCodeMapper;
import com.pen.app.qip.service.TestCodeService;
import com.pen.app.qip.vo.TestCodeVO;

@Service
public class TestCodeServiceImpl implements TestCodeService{
	@Autowired
	TestCodeMapper mapper;
	
	@Override
	public List<TestCodeVO> getTCodeList() {
		
		return mapper.getTCodeList();
	}
	
	@Override
	public List<TestCodeVO> getTCodeWithName(String testName) {
		
		return mapper.getTCodeWithName(testName);
	}
	
	@Override
	public String getTestCode() {
		
		return mapper.getTestCode();
	}
	
	@Override
	public ToastUiResponseDTO modifyTCode(Map<String, List<TestCodeVO>> modifiedRows) {
		String result = "Success";
		List<TestCodeVO> updatedRows = modifiedRows.get("updatedRows");
		List<TestCodeVO> createdRows = modifiedRows.get("createdRows");
		List<TestCodeVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyTCode(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertTCode(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteTCode(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}
}

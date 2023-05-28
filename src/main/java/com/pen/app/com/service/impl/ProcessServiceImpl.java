package com.pen.app.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.mapper.ProcessMapper;
import com.pen.app.com.service.ProcessService;
import com.pen.app.com.vo.ProcessVO;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	ProcessMapper mapper;

	@Override
	public List<String> getProcTypeList() {

		return mapper.getProcTypeList();
	}

	@Override
	public List<ProcessVO> getProcList() {

		return mapper.getProcList();
	}

	@Override
	public List<ProcessVO> getProcWithType(String procType) {

		return mapper.getProcWithType(procType);
	}

	@Override
	public String getProcCode() {

		return mapper.getProcCode();
	}

	@Override
	public ToastUiResponseDTO modifyProcList(Map<String, List<ProcessVO>> modifiedRows) {
		String result = "Success";
		List<ProcessVO> updatedRows = modifiedRows.get("updatedRows");
		List<ProcessVO> createdRows = modifiedRows.get("createdRows");
		List<ProcessVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyProcList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertProcList(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteProcList(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
	}

}

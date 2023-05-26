package com.pen.app.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pen.app.com.dto.ToastUiResponseDTO;
import com.pen.app.com.mapper.comCodeMapper;
import com.pen.app.com.service.ComCodeService;
import com.pen.app.com.vo.ComCodeVO;
import com.pen.app.com.vo.iCodeVO;

@Service
public class ComCodeServiceImpl implements ComCodeService {

@Autowired comCodeMapper mapper;
	@Override
		public List<ComCodeVO> getComCodeList() {
			
			return mapper.getComCodeList();
		}
	@Override
		public List<ComCodeVO> getComCodeWithName(String codeName) {
		
			return mapper.getComCodeWithName(codeName);
		}
	@Override
		public List<ComCodeVO> getInnerCodeList(String comCode) {
			
			return mapper.getInnerCodeList(comCode);
		}
	@Override
		public ToastUiResponseDTO modifyICodeList(Map<String, List<iCodeVO>> modifiedRows) {
		String result = "Success";
		List<iCodeVO> updatedRows = modifiedRows.get("updatedRows");
		List<iCodeVO> createdRows = modifiedRows.get("createdRows");
		List<iCodeVO> deletedRows = modifiedRows.get("deletedRows");

		// 변경사항 중에서 update 된 건을 update 기능으로
		if (updatedRows.size() != 0) {
			mapper.modifyICodeList(updatedRows);
		}

		// 변경사항 중에서 create 된 건을 insert 기능으로
		if (createdRows.size() != 0) {
			if (mapper.insertICodeList(createdRows) == 0) { // 결과가 0건이면
				result = "Fail";
			}

		}

		// 변경사항 중에서 delete 된 건을 delete 기능으로
		if (deletedRows.size() != 0) {
			if (mapper.deleteICodeList(deletedRows) == 0) { // 결과가 0이면
				result = "Fail";
			}
		}
		return new ToastUiResponseDTO(result);
		}
}

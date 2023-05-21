package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.UserVO;

public interface UserMapper {
	//로그인 정보
	UserVO getUser(UserVO vo);
	
	//본인 정보 수정
	int modifyUser(UserVO vo);
	
	//사원 리스트 출력
	List<UserVO> getUserList();
	
	//사원 정보수정
	int modifyUserList(List<UserVO> list);
	
	//이름으로 사원 조회
	List<UserVO> getUserWithName(String empName);
	
	//모든 권한 리스트 조회
	List<AuthVO> getAuthList();
	
	//유저 비밀번호 변경
	int resetPassword(String empNum, String empPw);
	
	//다음 EMP CODE 조회
	String getEmpCode();
	
	//사원추가
	int insertUserList(List<UserVO> list);
	
	//사원삭제
	int deleteUserList(List<UserVO> list);
}

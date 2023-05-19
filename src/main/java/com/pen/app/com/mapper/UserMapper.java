package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.UserVO;

public interface UserMapper {
	UserVO getUser(UserVO vo);
	int modifyUser(UserVO vo);
	List<UserVO> getUserList();
	int modifyUserList(List<UserVO> list);
	List<UserVO> getUserWithName(String empName);
	List<AuthVO> getAuthList();
	int resetPassword(String empNum, String empPw);
	String getEmpCode();
}

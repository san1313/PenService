package com.pen.app.com.service;

import java.util.List;

import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.UserVO;

public interface UserService {
	public UserVO getUser(UserVO vo);
	public boolean modifyUser(UserVO vo);
	public List<UserVO> getUserList();
	public boolean modifyUserList(List<UserVO> list);
	public List<UserVO> getUserWithName(String empName);
	public List<AuthVO> getAuthList();
	public boolean resetPassword(String empNum, String empPw);
	public String getEmpCode();
}

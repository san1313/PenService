package com.pen.app.com.service;

import java.util.List;

import com.pen.app.com.vo.UserVO;

public interface UserService {
	public UserVO getUser(UserVO vo);
	public boolean modifyUser(UserVO vo);
	public List<UserVO> getUserList();
	public boolean modifyUserList(List<UserVO> list);
}

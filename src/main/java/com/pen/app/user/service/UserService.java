package com.pen.app.user.service;

import java.util.List;

import com.pen.app.user.UserVO;

public interface UserService {
	public UserVO getUser(UserVO vo);
	public boolean modifyUser(UserVO vo);
	public List<UserVO> getUserList();
	public boolean modifyUserList(List<UserVO> list);
}

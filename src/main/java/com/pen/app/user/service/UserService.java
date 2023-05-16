package com.pen.app.user.service;

import com.pen.app.user.UserVO;

public interface UserService {
	public UserVO getUser(UserVO vo);
	public boolean modifyUser(UserVO vo);
}

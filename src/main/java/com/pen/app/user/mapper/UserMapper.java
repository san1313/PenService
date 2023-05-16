package com.pen.app.user.mapper;

import com.pen.app.user.UserVO;

public interface UserMapper {
	UserVO getUser(UserVO vo);
	int modifyUser(UserVO vo);
}

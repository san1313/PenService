package com.pen.app.user.mapper;

import java.util.List;

import com.pen.app.user.UserVO;

public interface UserMapper {
	UserVO getUser(UserVO vo);
	int modifyUser(UserVO vo);
	List<UserVO> getUserList();
	int modifyUserList(List<UserVO> list);
}

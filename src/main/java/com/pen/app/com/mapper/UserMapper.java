package com.pen.app.com.mapper;

import java.util.List;

import com.pen.app.com.vo.UserVO;

public interface UserMapper {
	UserVO getUser(UserVO vo);
	int modifyUser(UserVO vo);
	List<UserVO> getUserList();
	int modifyUserList(List<UserVO> list);
}

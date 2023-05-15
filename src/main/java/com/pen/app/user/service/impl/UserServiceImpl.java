package com.pen.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pen.app.user.UserVO;
import com.pen.app.user.mapper.UserMapper;
import com.pen.app.user.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

@Autowired UserMapper mapper;

@Override
public UserVO getUser(UserVO vo) {

	return mapper.getUser(vo);
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// 단건조회
	UserVO userVo = new UserVO();
	userVo.setEmpId(username);
	UserVO vo = mapper.getUser(userVo);
	// ID 없으면 error
	if (vo == null) {
		throw new UsernameNotFoundException("no id");
	}
	// vo return
	return vo;
}
}

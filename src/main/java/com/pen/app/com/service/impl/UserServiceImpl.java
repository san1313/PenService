package com.pen.app.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pen.app.com.mapper.UserMapper;
import com.pen.app.com.service.UserService;
import com.pen.app.com.vo.AuthVO;
import com.pen.app.com.vo.UserVO;

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

@Override
public boolean modifyUser(UserVO vo) {
	
	return mapper.modifyUser(vo)==1;
}

@Override
public List<UserVO> getUserList() {
	
	return mapper.getUserList();
}

@Override
public boolean modifyUserList(List<UserVO> list) {
	
	return mapper.modifyUserList(list)>0;
}

@Override
public List<UserVO> getUserWithName(String empName) {
	
	return mapper.getUserWithName(empName);
}

@Override
public List<AuthVO> getAuthList() {
	
	return mapper.getAuthList();
}

@Override
public boolean resetPassword(String empNum, String empPw) {
	
	return mapper.resetPassword(empNum, empPw)==1;
}

@Override
public String getEmpCode() {
	
	return mapper.getEmpCode();
}
@Override
	public boolean insertUserList(List<UserVO> list) {
	
		return mapper.insertUserList(list)>0;
	}
@Override
	public boolean deleteUserList(List<UserVO> list) {
	
		return mapper.deleteUserList(list)>0;
	}
}

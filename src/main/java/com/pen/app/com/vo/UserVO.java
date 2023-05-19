package com.pen.app.com.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pen.app.com.security.CustomAuthorityDeserializer;

import lombok.Data;

@Data
public class UserVO implements UserDetails{
	String empNum;
	String empName;
	String empId;
	String empPw;
	String empTel;
	String hireDate;
	String authCode;
	String authName;
	
	@JsonDeserialize(using = CustomAuthorityDeserializer.class)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(this.authName));
		return auth;
	}
	@Override
	public String getUsername() {

		return empId;
	}
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	@Override
	public boolean isEnabled() {

		return true;
	}
	public String getHireDate() {
		return hireDate.substring(0, 10);
	}
	@Override
	public String getPassword() {
		
		return empPw;
	}
}

package com.god.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.god.dao.base.GodUserMapper;
import com.god.domain.base.GodUser;
import com.god.service.base.IGodUserService;


@Service
public class GodUserServiceImpl implements IGodUserService{

	@Autowired
	private GodUserMapper userMapper;
	
	@Override
	public List<GodUser> searchUserList() {
		return userMapper.selectByExample(null);
	}
}

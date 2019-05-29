package com.god.web.zeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.god.domain.base.GodUser;
import com.god.service.base.IGodUserService;

@RestController
public class GodUserController {
	
	@Autowired
	private IGodUserService userService;
	
	@RequestMapping(value="/user/list", method=RequestMethod.POST)
	public List<GodUser> searchUserList(){
	
		List<GodUser> list = userService.searchUserList();
		return list;
	}

}

package com.geekshow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekshow.dao.UserDaoImpl;


@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public void addUser(){
		this.userDaoImpl.saveUser();
	}
}

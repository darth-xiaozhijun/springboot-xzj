package com.geekshow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geekshow.mapper.UsersMapper;
import com.geekshow.pojo.Users;
import com.geekshow.service.UsersService;

import java.util.List;


@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users users) {
		this.usersMapper.insertUser(users);
	}

	@Override
	public List<Users> findUserAll() {
		return this.usersMapper.selectUsersAll();
	}
}

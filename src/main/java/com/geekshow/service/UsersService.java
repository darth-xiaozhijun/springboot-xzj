package com.geekshow.service;

import com.geekshow.pojo.Users;

import java.util.List;

public interface UsersService {
	
	void addUser(Users users);

	List<Users> findUserAll();
}

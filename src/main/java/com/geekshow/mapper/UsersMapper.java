package com.geekshow.mapper;

import com.geekshow.pojo.Users;

import java.util.List;

public interface UsersMapper {
	
	void insertUser(Users users);

	List<Users> selectUsersAll();
}

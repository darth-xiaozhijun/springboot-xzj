package com.geekshow.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.geekshow.pojo.Peoples;

/**
 * Repository接口的方法名称命名查询
 *
 *
 */
public interface PeoplesRepositoryByName extends Repository<Peoples, Integer> {

	//方法的名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母大写)
	List<Peoples> findByName(String name);
	
	List<Peoples> findByNameAndAge(String name,Integer age);
	
	List<Peoples> findByNameLike(String name);
}

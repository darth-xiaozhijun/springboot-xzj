package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
import com.geekshow.dao.PeopleRepository;
import com.geekshow.pojo.People;
import com.geekshow.pojo.Roles;
import com.geekshow.pojo.Users;

/**
 * 一对多关联关系测试
 * @author xiaozhijun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class One2ManyTest {

	
	@Autowired
	private PeopleRepository peopleRepository;
	
	
	/**
	 * 一对多关联关系的添加
	 */
	@Test
	public void testSave(){
		//创建角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		//创建用户
		People people = new People();
		people.setPeopleage(30);
		people.setPeoplename("小王");
		//建立关系
		roles.getPeoples().add(people);
		people.setRoles(roles);
		//保存数据
		this.peopleRepository.save(people);
	}
	
	/**
	 * 一对多关联关系的查询
	 */
	@Test
	public void testFind(){
		People people = this.peopleRepository.findOne(1);
		System.out.println(people);
		Roles roles = people.getRoles();
		System.out.println(roles);
	}
}

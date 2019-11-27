package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
import com.geekshow.pojo.Peoples;
import com.geekshow.service.PeoplesService;

/**
 * PeoplesService测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class PeoplesServiceTest {

	@Autowired
	private PeoplesService peoplesService;
	
	@Test
	public void testFindPeoplesById(){
		//第一次查询
		System.out.println(this.peoplesService.findPeoplesById(1));
		
		//第二次查询
		System.out.println(this.peoplesService.findPeoplesById(1));
	}
	
	@Test
	public void testFindUserByPage(){
		Pageable pageable = new PageRequest(0, 2);
		//第一次查询
		System.out.println(this.peoplesService.findPeoplesByPage(pageable).getTotalElements());
		
		//第二次查询
		System.out.println(this.peoplesService.findPeoplesByPage(pageable).getTotalElements());
		
		//第三次查询
		pageable = new PageRequest(1, 2);
		System.out.println(this.peoplesService.findPeoplesByPage(pageable).getTotalElements());
	}
	
	@Test
	public void testFindAll(){
		//第一次查询
		System.out.println(this.peoplesService.findPeoplesAll().size());
		
		
		Peoples peoples = new Peoples();
		peoples.setAddress("南京");
		peoples.setAge(43);
		peoples.setName("朱七");
		this.peoplesService.savePeoples(peoples);
		
		//第二次查询
		System.out.println(this.peoplesService.findPeoplesAll().size());
	}
}

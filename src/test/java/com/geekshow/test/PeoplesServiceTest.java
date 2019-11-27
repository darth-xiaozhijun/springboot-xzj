package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
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
}

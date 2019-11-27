package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
import com.geekshow.dao.PeoplesRepository;
import com.geekshow.pojo.Card;
import com.geekshow.pojo.Peoples;

/**
 * 一对一关联关系测试
 * @author xiaozhijun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class One2OneTest {

	@Autowired
	private PeoplesRepository peoplesRepository;
	
	/**
	 * 添加用户同时添加角色
	 */
	@Test
	public void testSave(){
		//创建身份证
		Card card = new Card();
		card.setCardno("362422199509156666");
		card.setCardaddr("江西吉安");
		
		//创建用户
		Peoples peoples = new Peoples();
		peoples.setName("欧阳修");
		peoples.setAge(24);
		
		//建立关系
		peoples.setCard(card);
		card.setPeoples(peoples);
		
		//保存数据
		this.peoplesRepository.save(peoples);
	}
	
	/**
	 * 一对多关联关系的查询
	 */
	@Test
	public void testFind(){
		Peoples peoples = this.peoplesRepository.findOne(5);
		System.out.println(peoples);
		Card card = peoples.getCard();
		System.out.println(card);
	}
}

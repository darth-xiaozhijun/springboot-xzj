package com.geekshow.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
import com.geekshow.dao.PeoplesRepository;
import com.geekshow.dao.PeoplesRepositoryByName;
import com.geekshow.pojo.Peoples;
import com.geekshow.pojo.Peoples;

/**
 * 测试类
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class PeoplesRepositoryTest {

	@Autowired
	private PeoplesRepository peoplesRepository;
	
	@Autowired
	private PeoplesRepositoryByName peoplesRepositoryByName;
	
	@Test
	public void testSave(){
		
		Peoples peoples = new Peoples();
		peoples.setName("爱新觉罗玄烨");
		peoples.setAge(21);
		peoples.setAddress("北京紫禁城");
		peoplesRepository.save(peoples);
	}
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByName(){
		List<Peoples> list = this.peoplesRepositoryByName.findByName("文天祥");
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByNameAndAge(){
		List<Peoples> list = this.peoplesRepositoryByName.findByNameAndAge("毛泽东", 22);
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByNameLike(){
		List<Peoples> list = this.peoplesRepositoryByName.findByNameLike("爱新%");
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
}

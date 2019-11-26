package com.geekshow.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
import com.geekshow.dao.PeoplesRepository;
import com.geekshow.dao.PeoplesRepositoryByName;
import com.geekshow.dao.PeoplesRepositoryCrudRepository;
import com.geekshow.dao.PeoplesRepositoryPagingAndSorting;
import com.geekshow.dao.PeoplesRepositoryQueryAnnotation;
import com.geekshow.pojo.Peoples;
import com.geekshow.pojo.Users;

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
	
	@Autowired
	private PeoplesRepositoryQueryAnnotation peoplesRepositoryQueryAnnotation;
	
	@Autowired
	private PeoplesRepositoryCrudRepository peoplesRepositoryCrudRepository;
	
	@Autowired
	private PeoplesRepositoryPagingAndSorting peoplesRepositoryPagingAndSorting;
	
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
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseHQL() {
		List<Peoples> list = this.peoplesRepositoryQueryAnnotation.queryByNameUseHQL("文天祥");
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}

	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseSQL() {
		List<Peoples> list = this.peoplesRepositoryQueryAnnotation.queryByNameUseSQL("文天祥");
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}

	/**
	 * Repository--@Query测试
	 */
	@Test
	@Transactional //@Transactional与@Test 一起使用时 事务是自动回滚的。
	@Rollback(false) //取消自动回滚
	public void testUpdatePeoplesNameById() {
		this.peoplesRepositoryQueryAnnotation.updatePeoplesNameByIdUseHQL("欧阳修", 1);
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositorySave() {
		Peoples peoples = new Peoples();
		peoples.setAddress("天津");
		peoples.setAge(12);
		peoples.setName("哪吒");
		this.peoplesRepositoryCrudRepository.save(peoples);
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryUpdate() {
		Peoples peoples = new Peoples();
		peoples.setId(4);
		peoples.setAddress("呼伦贝尔");
		peoples.setAge(40);
		peoples.setName("成吉思汗");
		this.peoplesRepositoryCrudRepository.save(peoples);
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryFindOne() {
		Peoples peoples = this.peoplesRepositoryCrudRepository.findOne(4);
		System.out.println(peoples);
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryFindAll() {
		List<Peoples> list  =  (List<Peoples>)this.peoplesRepositoryCrudRepository.findAll();
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryDeleteById() {
		this.peoplesRepositoryCrudRepository.delete(4);
		
	}
	
	/**
	 * PagingAndSortingRepository   排序测试
	 */
	@Test
	public void testPagingAndSortingRepositorySort() {
		//Order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		//Sort对象封装了排序规则
		Sort sort = new Sort(order);
		List<Peoples> list = (List<Peoples>)this.peoplesRepositoryPagingAndSorting.findAll(sort);
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
	
	/**
	 * PagingAndSortingRepository   分页测试
	 */
	@Test
	public void testPagingAndSortingRepositoryPaging() {
		//Pageable:封装了分页的参数，当前页，每页显示的条数。注意：他的当前页是从0开始。
		//PageRequest(page,size) page:当前页。size:每页显示的条数
		Pageable pageable = new PageRequest(1, 2);
	    Page<Peoples> page = this.peoplesRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数"+page.getTotalPages());
		List<Peoples> list = page.getContent();
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
	
	/**
	 * PagingAndSortingRepository   排序+分页
	 */
	@Test
	public void testPagingAndSortingRepositorySortAndPaging() {
		
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		
		Pageable pageable = new PageRequest(0, 2, sort);
				
		Page<Peoples> page = this.peoplesRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数"+page.getTotalPages());
		List<Peoples> list = page.getContent();
		for (Peoples peoples : list) {
			System.out.println(peoples);
		}
	}
}

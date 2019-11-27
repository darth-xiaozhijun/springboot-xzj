package com.geekshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geekshow.Application;
import com.geekshow.pojo.Peoples;
import com.geekshow.pojo.Users;

/**
 * Spring Data Redis测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("redis", "极客萧公众号");
	}
	
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String)this.redisTemplate.opsForValue().get("redis");
		System.out.println(value);
	}
	
	/**
	 * 添加Users对象
	 */
	@Test
	public void testSetPeoples(){
		
		Peoples peoples = new Peoples();
		peoples.setAge(20);
		peoples.setName("张三丰");
		peoples.setId(1);
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("peoples", peoples);
	}
	
	/**
	 * 取Users对象
	 */
	@Test
	public void testGetPeoples(){
		
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Peoples peoples = (Peoples)this.redisTemplate.opsForValue().get("peoples");
		System.out.println(peoples);
	}
	
	/**
	 * 基于JSON格式存Users对象
	 */
	@Test
	public void testSetPeoplesUseJSON(){
		
		Peoples peoples = new Peoples();
		peoples.setAge(20);
		peoples.setName("爱新觉罗玄烨");
		peoples.setId(1);
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Peoples.class));
		this.redisTemplate.opsForValue().set("peoples_json", peoples);
	}
	
	/**
	 * 基于JSON格式取Users对象
	 */
	@Test
	public void testGetPeoplesJSON(){
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Peoples.class));
		Peoples peoples = (Peoples)this.redisTemplate.opsForValue().get("peoples_json");
		System.out.println(peoples);
	}
}

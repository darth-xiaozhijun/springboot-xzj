package com.geekshow.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geekshow.pojo.User;
import com.geekshow.pojo.Users;

/**
 * SpringBoot整合jsp
 * SpringBoot 表单数据校验
 *
 */
@Controller
public class UserController {
	/*
	 * 处理请求，产生数据
	 */
	@RequestMapping("/showUser")
	public String showUser(Model model){
		List<Users> list = new ArrayList<>();
		list.add(new Users(1,"张三",20));
		list.add(new Users(2,"李四",22));
		list.add(new Users(3,"王五",24));
		
		//需要一个Model对象
		model.addAttribute("list", list);
		//跳转视图
		return "userList";
	}
	
	@RequestMapping("/addUser")
	public String showPage(){
		return "add";
	}
	
	/**
	 * 完成用户添加
	 *@Valid 开启对Users对象的数据校验
	 *BindingResult:封装了校验的结果
	 */
	@RequestMapping("/save")
	public String saveUser(@Valid User user,BindingResult result){
		if(result.hasErrors()){
			return "add";
		}
		System.out.println(user);
		return "ok";
	}
}

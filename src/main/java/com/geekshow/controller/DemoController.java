package com.geekshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf入门案例
 *
 *
 */
@Controller
public class DemoController {
	@RequestMapping("/show")
	public String showInfo(Model model){
		model.addAttribute("msg", "Thymeleaf 第一个案例");
		return "index";
	}

	@RequestMapping("/show2")
	public String showInfo2(Model model){
		model.addAttribute("sex", "女");
		model.addAttribute("id","1");
		return "index2";
	}
}

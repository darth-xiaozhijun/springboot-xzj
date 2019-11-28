package com.geekshow.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

	@Value("${msg}")
	private String msg;

	@RequestMapping("/value")
	public String showMsg(){
		return this.msg;
	}
	
}

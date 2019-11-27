package com.geekshow.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.geekshow.service.QuartzService;

@Service
public class QuartzServiceImpl implements QuartzService {

	@Override
	public void testQuartz() {

		System.out.println("testQuartz......" + new Date());
	}

}

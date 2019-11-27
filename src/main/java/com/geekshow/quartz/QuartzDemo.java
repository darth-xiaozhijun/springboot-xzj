package com.geekshow.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.geekshow.service.QuartzService;
/**
 * Job类
 *
 *
 */
public class QuartzDemo implements Job {
	
	@Autowired
	private QuartzService quartzService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		System.out.println("Execute...."+new Date());
		quartzService.testQuartz();
	}

}

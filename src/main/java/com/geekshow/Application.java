package com.geekshow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot 启动类
 * SpringBoot整合Servlet方式一
 * SpringBoot整合Filter方式一
 * SpringBoot整合Listener方式一
 * @author Administrator
 *
 */
@SpringBootApplication
@ServletComponentScan //在springBoot启动时会扫描@WebServlet，并将该类实例化
@MapperScan("com.geekshow.mapper") //@MapperScan 用户扫描MyBatis的Mapper接口
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

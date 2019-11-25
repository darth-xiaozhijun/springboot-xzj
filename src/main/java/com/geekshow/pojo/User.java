package com.geekshow.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotBlank(message="用户名不能为空") //非空校验
	@Length(min=2,max=6,message="最小长度为2位，最大长度为6位")
	private String name;
	
	@NotEmpty
	private String password;
	
	@Min(value = 1)
	@Max(value = 150)
	private Integer age;
	
	@Email
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + ", email=" + email + "]";
	}

}

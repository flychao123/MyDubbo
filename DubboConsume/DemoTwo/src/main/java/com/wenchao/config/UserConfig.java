package com.wenchao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class UserConfig {
	@Value("#{myConfig['user.name']}")
	private String name;
	@Value("#{myConfig['user.password']}")
	private String password;
	@Value("#{myConfig['user.age']}")
	private Integer age;
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

	
}

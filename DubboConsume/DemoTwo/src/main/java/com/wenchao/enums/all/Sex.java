package com.wenchao.enums.all;
/*
 * 枚举可以增加语义
 */
public enum Sex {
	man(1,"表示男"),
	woMen(2,"表示女"),
	oldMan(3,"表示老年人");
	private Integer code;
	private String description;
	private Sex(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

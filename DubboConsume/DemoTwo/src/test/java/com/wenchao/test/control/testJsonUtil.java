package com.wenchao.test.control;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.json.JSON;
import com.wenchao.bean.MyUser;
import com.wenchao.util.JsonUtil;

public class testJsonUtil {
	private static Logger logger=LoggerFactory.getLogger(testJsonUtil.class);
	@Test
	public void testJson(){
		
		MyUser myUser=new MyUser();
		myUser.setAge(22);
		myUser.setName("文超");
		myUser.setId(1L);
		myUser.setPassword("123456");
		System.out.println(myUser.toString());
		String str=myUser.toString();
	try {
		MyUser me=JsonUtil.toOject(str, myUser.getClass());
		System.out.println(me.getName());
		
		System.out.println(JsonUtil.toJsonWriteNull(myUser));
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
		
	}
	@Override
	public String toString() {
		return "{\"\"}";
	}
}

package com.wenchao.test.control;

import org.junit.Test;

import com.wenchao.bean.MyUser;
import com.wenchao.util.XstreamUtil;

public class testXstringAlias {
	@Test
	public void testxml(){
		MyUser myUser=new MyUser();
		myUser.setAge(22);
		myUser.setName("文超");
		myUser.setId(1L);
		myUser.setPassword("123456");
		String str=XstreamUtil.toXml(myUser);
		System.out.println(str);
		MyUser user=XstreamUtil.toBean(str, MyUser.class);
		System.out.println(user.getName());
		
	}
}

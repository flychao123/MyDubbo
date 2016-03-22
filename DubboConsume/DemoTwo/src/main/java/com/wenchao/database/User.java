package com.wenchao.database;

import com.wenchao.bean.MyUser;

public interface User {
	int add(MyUser myUser);
	
	MyUser query(String name);

	int delete(Long id);

}

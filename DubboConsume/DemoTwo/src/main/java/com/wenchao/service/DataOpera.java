package com.wenchao.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenchao.bean.MyUser;
import com.wenchao.database.User;
import com.wenchao.redis.UserRedis;
@Service
public class DataOpera {
	Logger logger=LoggerFactory.getLogger(DataOpera.class);
	@Autowired
	private User user;
	@Inject
	private UserRedis userRedis;
	
	public int addUser(MyUser myUser){
		int res=user.add(myUser);
		//插入缓存，注意先插入sql,在插入缓存
		userRedis.addRedis(myUser);
		logger.info("缓存插入成功,参数{}",myUser);
		return res;
	}
	public MyUser queryUser(String name){
		MyUser myUser=null;
		myUser=userRedis.queryRedis(name);
		if(myUser==null){
			myUser=user.query(name);
		}
		return myUser;
	}
	public int delete(Long id) {
		return user.delete(id);
	}
}

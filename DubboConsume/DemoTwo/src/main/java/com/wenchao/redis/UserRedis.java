package com.wenchao.redis;

import java.io.IOException;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.netty.util.internal.ReusableIterator;
import org.jboss.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import com.alibaba.druid.util.StringUtils;
import com.wenchao.bean.MyUser;
@Service
public class UserRedis {
	Logger logger=LoggerFactory.getLogger(UserRedis.class);
	@Inject
	private StringRedisTemplate stringRedisTemplate;
	
	@Inject
	private RedisTemplate redisTemplate;
	
	
	public MyUser queryRedis(String name){

		try {
			ObjectMapper objectMapper=new ObjectMapper();
			String myUserStr=stringRedisTemplate.opsForValue().get(name);
			MyUser myUser;
			if(StringUtils.isEmpty(myUserStr)){
				logger.info("查询缓存失败！传参数为{}",name);
				return null;
			}
			myUser = objectMapper.readValue(myUserStr, MyUser.class);
			return myUser;
		} catch (JsonParseException e) {
			e.printStackTrace();
			logger.info("查询缓存失败{}",e);
			return null;
		} catch (JsonMappingException e) {
			e.printStackTrace();	
			logger.info("查询缓存失败{}",e);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("查询缓存失败{}",e);
			return null;
		}
		
	}
	public void addRedis(MyUser user) {
		/*
		ValueOperations<String, MyUser> valueops =redisTemplate.opsForValue();
		valueops.set(user.getName(), user);
		*/
		ObjectMapper objectMapper=new ObjectMapper();
		String userString;
		try {
			userString = objectMapper.writeValueAsString(user);
			stringRedisTemplate.opsForValue().set(user.getName(), userString);
		} catch (JsonGenerationException e) {
			logger.info("插入缓存失败{}",e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

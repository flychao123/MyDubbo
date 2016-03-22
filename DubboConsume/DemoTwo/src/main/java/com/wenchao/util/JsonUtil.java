package com.wenchao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class JsonUtil {
	 private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	    private static final Gson gson = new Gson();
	 public static <T> T toOject(String jsonStr,Class<T> classType) throws Exception{
	        try {
	            return (T)gson.fromJson(jsonStr, classType);
//	        	return (T)JSON.parse(jsonStr, classType);
	        } catch (Exception e) {
	            logger.error("json 2 java obj exception:",e);
	            throw new Exception("json convert to java object exception");
	        }
	    } 
	 
	 public static String toJsonWriteNull(Object obj){
	      return gson.toJson(obj);
	     }
}

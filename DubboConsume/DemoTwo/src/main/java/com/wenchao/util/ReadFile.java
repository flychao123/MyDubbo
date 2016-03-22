package com.wenchao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFile {
    private static final Logger logger = LoggerFactory.getLogger(ReadFile.class);
	 public static String readTxtFile(String filePath){
		 InputStream fileInputStream = ReadFile.class.getClassLoader().getResourceAsStream(filePath);
	        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
	        String oneLineContent = null;
	        StringBuilder fileContent = new StringBuilder();
	        try {
	            while ( (oneLineContent = br.readLine()) != null) {
	                fileContent.append(oneLineContent);
	            }
	        } catch (IOException e) {
	            logger.error("读取文件内容错误");
	            e.printStackTrace();
	        }
	        return fileContent.toString();
	 }
	
}

package com.wenchao.test.control;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.wenchao.util.HttpRequest;
import com.wenchao.util.ReadFile;
@Component
public class testHelloWorld {
	String addUrl="http://localhost:8081/DemoTwo/test/res.do";
	String queryUrl="http://localhost:8081/DemoTwo/test/query.do";
	
	@Test
	public void  testShow() {
		String file=ReadFile.readTxtFile("testData/test.txt");
		System.out.println(file);
		String reString=HttpRequest.sendPost(addUrl, file);
		System.out.println(reString);
	}
	@Test
	public void testQuery(){
		
	}
}

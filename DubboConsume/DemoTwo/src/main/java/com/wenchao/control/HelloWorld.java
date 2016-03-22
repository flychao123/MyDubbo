package com.wenchao.control;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.wenchao.bean.MyUser;
import com.wenchao.config.UserConfig;
import com.wenchao.consume.api.IConsume;
import com.wenchao.database.User;
import com.wenchao.enums.all.Sex;
import com.wenchao.service.DataOpera;

import wenchao.one.service.MyService;

@Controller
@RequestMapping("test")
public class HelloWorld implements IConsume {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MyService myService;
	
	@Inject
	private DataOpera dataOpera;
	
	@Inject
	private UserConfig userConfig;

	@RequestMapping("me")
	public String printWelcome(ModelMap model) {
		System.out.println("fsfsd");
		String res = use();
		System.out.println(res);
		
		System.out.println(userConfig.getName()+userConfig.getPassword()+userConfig.getAge());
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "one";
	}

	public String use() {
		return myService.cry();
	}

	@RequestMapping("/show")
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("fsdf");
		List<String> res = new ArrayList<String>();
		res.add(myService.say("chao"));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("res", res);
		modelAndView.setViewName("two");
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		MyUser myUser = new MyUser();
		myUser.setName(name);
		myUser.setPassword(password);
		myUser.setAge(Integer.valueOf(age));
		try {
			List<MyUser> res = Lists.newArrayList();
			int r = dataOpera.addUser(myUser);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("one");
			return modelAndView;
		} catch (Exception e) {
			System.out.println("插入失败！" + e);
			logger.info("插入失败,传进来的参数为：{}", myUser);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}

	@RequestMapping("/query")
	public ModelAndView query(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		//枚举的示例
		System.out.println(Sex.man.getDescription());
		System.out.println(Sex.man.getCode());
		try {
			List<MyUser> res = Lists.newArrayList();
			MyUser u = dataOpera.queryUser(name);
			res.add(u);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("res", res);
			modelAndView.setViewName("four");
			return modelAndView;
		} catch (Exception e) {
			System.out.println("查询失败！" + e);
			logger.info("查询失败,传进来的参数为：{}", name);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("error");
			return modelAndView;
		}

	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String userid = request.getParameter("id");
			int res = dataOpera.delete(Long.valueOf(userid));
			ModelAndView modelAndView = new ModelAndView();
			if (res > 0) {
				logger.info("删除成功！");
				modelAndView.setViewName("one");
			} else {
				logger.error("删除失败！");
				modelAndView.setViewName("error");
			}
			modelAndView.addObject("res", String.valueOf(res));
			return modelAndView;
		} catch (Exception e) {
			System.out.println("删除失败！" + e);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}
	
	@RequestMapping("res")
	@ResponseBody
	public String res(HttpServletRequest request, HttpServletResponse response) {
		String a = myService.cry(); // 返回json字符串
		return a;
	}

	@RequestMapping("html")
	public String html(HttpServletRequest request, HttpServletResponse response) {
		return "three";
	}
	
}

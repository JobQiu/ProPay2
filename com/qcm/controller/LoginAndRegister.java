package com.qcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.entity.Admin;
import com.qcm.entity.Counter;

@Controller
public class LoginAndRegister {
	@RequestMapping(value="/login")
	public String login(HttpServletRequest req,@ModelAttribute Admin admin){
		//获取单选的值
		String power = req.getParameter("power");
		System.out.println(power);
		if("counter".equals(power)){
			System.out.println(admin.getAdminName()+"==="+admin.getAdminPassword());
			if("123".equals(admin.getAdminName())&&"123".equals(admin.getAdminPassword())){
				return "lalala";
			}else{
				req.getSession().setAttribute("info", "用户名或密码错误!");
				return "index";
			}
		}else{
			System.out.println(admin.getAdminName()+"==="+admin.getAdminPassword());
			if("123".equals(admin.getAdminName())&&"123".equals(admin.getAdminPassword())){
				
				return "hello";
			}else{
				req.getSession().setAttribute("info", "用户名或密码错误!");
				return "index";
			}
		}
	}
	@RequestMapping(value="/login")
	public String register(@ModelAttribute Counter counter){
		
		return "";
	}
}

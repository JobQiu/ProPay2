package com.qcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.entity.Admin;
import com.qcm.entity.Counter;

@Controller
public class Login {
	@RequestMapping(value="/login")
	public String adminLogin(HttpServletRequest req,@ModelAttribute Admin admin,@ModelAttribute Counter counter){
		admin.setAdminName(req.getParameter("username"));
		counter.setUserName(req.getParameter("username"));
		admin.setAdminPassword(req.getParameter("password"));
		counter.setUserPassword(req.getParameter("password"));
		String power = req.getParameter("power");
		System.out.println(power);
		if("counter".equals(power)){
			System.out.println(counter.getUserName()+"==="+counter.getUserPassword());
			if("123".equals(counter.getUserName())&&"123".equals(counter.getUserPassword())){
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
}

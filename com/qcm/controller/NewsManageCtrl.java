package com.qcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsManageCtrl {

	@RequestMapping("/showNews")
	public String showNews(){
		
		return "administer";
	}
	
}

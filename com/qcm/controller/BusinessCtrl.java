package com.qcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.dao.impl.BusinessDaoImpl;
import com.qcm.entity.Business;
@Configuration//表示这是一个配置信息
@ComponentScan("com/qcm/dao/impl")
@Controller
@RequestMapping("/business")
public class BusinessCtrl {
	
	private BusinessDaoImpl bsnsDao;
	
	@RequestMapping("/save")
	public String save(Business	bsns){
		bsnsDao.addTrade(bsns);
		return "savings";
	}
	@RequestMapping("/withdraw")
	public String withdraw(Business bsns){
		bsnsDao.addTrade(bsns);
		return "withdrawing";
	}
	@RequestMapping("/transfer")
	public String transfer(Business bsns){
		bsnsDao.addTrade(bsns);
		return "transfer";
	}
	
	
	@Autowired
	public void setBsnsDao(BusinessDaoImpl bsnsDao) {
		this.bsnsDao = bsnsDao;
	}
	public BusinessDaoImpl getBsnsDao() {
		return bsnsDao;
	}
}

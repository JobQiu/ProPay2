package com.qcm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.qcm.dao.IBusinessDao;
import com.qcm.entity.Business;
import com.qcm.entity.Counter;
@Component
public class BusinessDaoImpl implements IBusinessDao{
	
	public void addTrade(Business bsns) {
		ApplicationContext app = new FileSystemXmlApplicationContext("src/springmvc-servlet.xml");
		SessionFactory sessionFactory = app.getBean("sessionFactory", SessionFactory.class);
		
		//2.开启session
		Session session = sessionFactory.openSession();
		//3.打开事务
		Transaction transaction = session.beginTransaction();
		//4.保存数据
		session.save(bsns);
		//5.事务提交
		transaction.commit();
		//6.关闭session
		session.close();
		//7.关闭工厂
		session.close();
	}

	public void withdraw(Counter counter) {
		
	}

	public void transfer(Counter counter) {
		
	}

}

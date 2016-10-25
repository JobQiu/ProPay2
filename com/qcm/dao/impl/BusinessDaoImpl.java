package com.qcm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.constant.Constant;
import com.qcm.dao.IBusinessDao;
import com.qcm.entity.Business;
import com.qcm.entity.Counter;

public class BusinessDaoImpl implements IBusinessDao {

	// 这里请改成 classpath:springmvc-servlet.xm
	private ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
			Constant.XML_LOCATION);
	// private ApplicationContext applicationContext = new
	// FileSystemXmlApplicationContext("classpath:springmvc-servlet.xml");
	private SessionFactory sessionFactory = applicationContext.getBean(
			"sessionFactory", SessionFactory.class);

	/**
	 * 查看一个用户的所有账单
	 * */
	public List<Business> businessList(Counter counter) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Business> businesses = session
				.createQuery("select distinct b from Business b where user_counter = '"
						+ counter.getUserCounter()
						+ "' or other_counter = '"
						+ counter.getUserCounter() + "'").list();
		for (Business business : businesses) {
			System.out.println(business.getMoney());
		}
		
		transaction.commit();
		session.close();
		return businesses;
	}

	public static void main(String[] args) {
		BusinessDaoImpl businessDaoImpl = new BusinessDaoImpl();
		Counter counter = new Counter();
		counter.setUserCounter(20161025);
		businessDaoImpl.businessList(counter);

	}



}

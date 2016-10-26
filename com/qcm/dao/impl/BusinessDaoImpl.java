package com.qcm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.qcm.constant.Constant;
import com.qcm.dao.IBusinessDao;
import com.qcm.entity.Business;
import com.qcm.entity.Counter;

@Component
public class BusinessDaoImpl implements IBusinessDao {
	// 这里请改成 classpath:springmvc-servlet.xm
	private ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
			Constant.XML_LOCATION);
	// private ApplicationContext applicationContext = new
	// FileSystemXmlApplicationContext("classpath:springmvc-servlet.xml");
	private SessionFactory sessionFactory = applicationContext.getBean(
			"sessionFactory", SessionFactory.class);

	public void addTrade(Business bsns) {
		// 2.开启session
		Session session = sessionFactory.openSession();
		// 3.打开事务
		Transaction transaction = session.beginTransaction();
		// 4.保存数据
		session.save(bsns);
		// 5.事务提交
		transaction.commit();
		// 6.关闭session
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Business> businessList(Counter counter) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Business> businesses = session.createQuery(
				"select distinct b from Business b where user_counter = '"
						+ counter.getUserCounter() + "' or other_counter = '"
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
		businessDaoImpl.businessList(counter, 0, 2);

	}

	@SuppressWarnings("unchecked")
	public List<Business> businessList(Counter counter, int start, int number) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Business> businesses = session
				.createQuery(
						"select distinct b from Business b where user_counter = '"
								+ counter.getUserCounter()
								+ "' or other_counter = '"
								+ counter.getUserCounter() + "'")
				.setFirstResult(start).setMaxResults(number).list();
		for (Business business : businesses) {
			System.out.println(business.getMoney());
		}

		transaction.commit();
		session.close();
		return businesses;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}

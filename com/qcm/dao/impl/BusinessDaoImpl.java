package com.qcm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.qcm.dao.IBusinessDao;
import com.qcm.entity.Business;

public class BusinessDaoImpl implements IBusinessDao{
	public void save(Business bsns) {
		//1.获取session工厂
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
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

}

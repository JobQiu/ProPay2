package com.qcm.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.entity.Counter;
import com.qcm.entity.News;
public class Test {

	public static void main(String[] args) {
		String userName="2";
		System.out.println("123s");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"classpath:springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				"sessionFactory", SessionFactory.class);
		Session session = sessionFactory.openSession();
		String hql="from Counter as ct where ct.userName=?";
		Query query=session.createQuery(hql);
		query.setString(0, userName);
		List<Counter> list=query.list();
		
		for(Counter u:list){
			System.out.println(u.getAddress());
		}
		session.close();
		System.out.println("1qwer23");

	}
}


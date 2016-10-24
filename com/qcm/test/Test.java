package com.qcm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.entity.User;

public class Test {

	public static void main(String[] args) {
		System.out.println("123s");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/main/java/springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				"sessionFactory", SessionFactory.class);
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, 1);
		System.out.println(user.getName());
	}
}

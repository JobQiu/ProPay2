package com.qcm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.entity.News;

public class Test {

	public static void main(String[] args) {
		System.out.println("123s");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/main/java/springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				"sessionFactory", SessionFactory.class);
		Session session = sessionFactory.openSession();
		News news = new News();
		news.setText("!23");
		news.setAbstract_("123");
		news.setTitle("123");
		System.out.println(session.save(news));
		session.close();
		System.out.println("123");

	}
}

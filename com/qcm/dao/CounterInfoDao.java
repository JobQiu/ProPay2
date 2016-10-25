package com.qcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.dao.impl.CounterInfoImpl;
import com.qcm.entity.Counter;

public class CounterInfoDao implements CounterInfoImpl {

	public boolean info(String  userName) {
		//测试shi'yon
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				"sessionFactory", SessionFactory.class);
		try{
			Session session = sessionFactory.openSession();
			String hql="from Counter as ct where ct.userName=?";
			Query query=session.createQuery(hql);
			query.setString(0, userName);
			List<Counter> list=query.list();
			
			for(Counter u:list){
				System.out.println(u);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}finally{
		
			sessionFactory.close();
			
		}
		
		return true;
	}

	public boolean update(Counter counter) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				"sessionFactory", SessionFactory.class);
		Session session = sessionFactory.openSession();
		try{
			session.update(counter);
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}finally{
		
			sessionFactory.close();
			
		}
		
		return true;
		
	}
	//修改密码
	public boolean updatePwd(String userName, String passWord,String newpassWord) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				"sessionFactory", SessionFactory.class);
		Session session = sessionFactory.openSession();
		try{
			String hql="from Counter as ct where ct.userName=?";
			Query query=session.createQuery(hql);
			query.setString(0, userName);
			List<Counter> list=query.list();
			for(Counter u:list){
				System.out.println(u);
				if(passWord.trim().equals(u.getUserPassword())){
					u.setUserPassword(newpassWord);
					session.update(u);
				}
			    }	
				}catch (Exception e) {
					// TODO: handle exception
					return false;
				}finally{
				
					sessionFactory.close();
					
				}
				
				return true;
	}	
}

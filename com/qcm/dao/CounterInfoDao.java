package com.qcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.constant.Constant;
import com.qcm.dao.impl.CounterInfoImpl;
import com.qcm.entity.Counter;

public class CounterInfoDao implements CounterInfoImpl {
	// 这里请改成 classpath:springmvc-servlet.xm
	private ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
			Constant.XML_LOCATION);
	// private ApplicationContext applicationContext = new
	// FileSystemXmlApplicationContext("classpath:springmvc-servlet.xml");
	private SessionFactory sessionFactory = applicationContext.getBean(
			"sessionFactory", SessionFactory.class);
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean info(String  userName) {
		// TODO Auto-generated method stub
	
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
	//修改用户信息
	public boolean update(Counter counter) {
		// TODO Auto-generated method stub
		try{
			
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(counter);
			transaction.commit();
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
		
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			String hql="from Counter as ct where ct.userName=?";
			Query query=session.createQuery(hql);
			//0代表？
			query.setString(0, userName);
			List<Counter> list=query.list();
			for(Counter u:list){
				System.out.println(u.getUserPassword());
				if(passWord.trim().equals(u.getUserPassword())){
					u.setUserPassword(newpassWord);
					session.update(u);
					transaction.commit();
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

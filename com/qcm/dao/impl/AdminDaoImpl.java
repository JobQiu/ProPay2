package com.qcm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.constant.Constant;
import com.qcm.dao.IAdminDao;
import com.qcm.entity.Admin;

/**
 * @see 注意第16行的xml路径
 * */
public class AdminDaoImpl implements IAdminDao {


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

	@Override
	public boolean checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// 1. 获得管理员的用户名
		@SuppressWarnings("unchecked")
		List<Admin> admins = session.createQuery(
				"select distinct a from Admin a where admin_name='"
						+ admin.getAdminName() + "' and admin_password='"
						+ admin.getAdminPassword() + "'").list();
		int count = admins.size();

		transaction.commit();
		session.close();
		if (count >= 1)
			return true;
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Admin admin = new Admin();
		admin.setAdminName("qcm");
		admin.setAdminPassword("123");
		IAdminDao iAdminDao = new AdminDaoImpl();
		// 检查用户名密码是否正确
		System.out.println(iAdminDao.checkAdmin(admin));

	}

}

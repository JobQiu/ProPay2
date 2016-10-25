package com.qcm.dao;

import java.util.List;

import com.qcm.entity.Admin;
import com.qcm.entity.Counter;

public interface IAdminDao {

	/**
	 * 检查管理员登录，密码是否正确
	 * @author 裘丛民
	 * */
	public boolean checkAdmin(Admin admin);

	/**
	 * 搜索特定状态的用户， 从start开始的number个用户
	 * 
	 * @author 裘丛民
	 * */
	public List<Counter> counterList(int start, int number, int state);
}

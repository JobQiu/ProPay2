package com.qcm.dao;

import com.qcm.entity.Admin;

public interface IAdminDao {

	/**
	 * 检查管理员登录，密码是否正确
	 * @author 裘丛民
	 * */
	public boolean checkAdmin(Admin admin);

}

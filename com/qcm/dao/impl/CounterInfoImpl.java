package com.qcm.dao.impl;

import com.qcm.entity.Counter;

public interface CounterInfoImpl {
	public boolean info(String  userName);
	public boolean update(Counter counter);
	public boolean updatePwd(String userName,String passWord,String newpassWord);

}

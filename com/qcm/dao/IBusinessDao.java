package com.qcm.dao;

import com.qcm.entity.Business;
import com.qcm.entity.Counter;

public interface IBusinessDao {
	void addTrade(Business bsns);
	void withdraw(Counter counter);
	void transfer(Counter counter);
}

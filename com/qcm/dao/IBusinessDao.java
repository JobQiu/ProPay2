package com.qcm.dao;

import com.qcm.entity.Business;

public interface IBusinessDao {
	void save(Business bsns);
	void withdraw(Business bsns);
	void transfer(Business bsns);
}

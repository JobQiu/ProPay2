package com.qcm.dao;

import java.util.List;

import com.qcm.entity.Business;
import com.qcm.entity.Counter;

public interface IBusinessDao {

	/**
	 * @author 裘丛民
	 * @see 查看一个用户的所有交易记录
	 * */
	public List<Business> businessList(Counter counter);
}

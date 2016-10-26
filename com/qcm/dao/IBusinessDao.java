package com.qcm.dao;


import java.util.List;

import com.qcm.entity.Business;
import com.qcm.entity.Counter;

public interface IBusinessDao {

	/**
	 * 查看一个用户的所有交易记录
	 * @author 裘丛民
	 */
	public List<Business> businessList(Counter counter);

	/**
	 * 查看一个用户，从start开始的number条记录[start,start+number-1]
	 * 
	 * @author 裘丛民
	 * */
	public List<Business> businessList(Counter counter, int start, int number);
	
	/**添加交易记录
	 * @author 贾国宁
	 *
	 */
	void addTrade(Business bsns);
}


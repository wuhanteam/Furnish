package com.softeem.dao;

import java.util.List;

import com.softeem.bean.CustomerInfoBean;

public interface ICustomerInfoDao {
	
	/**
	 * 添加用户
	 * @param cusInfo
	 * @return
	 */
	int addCustomInfo(CustomerInfoBean cusInfo);
	
	/**
	 * 批量或单一删除客户
	 * @param cusIDs
	 * @return
	 */
	int delCustomerInfo(String[] cusIDs);
	
	/**
	 * 修改用户
	 * @param cusName
	 * @return
	 */
	int updateCustomerInfo(CustomerInfoBean cusInfo);
	
	/**
	 * 根据ID查询
	 * @param cusID
	 * @return
	 */
	CustomerInfoBean queryCustomerByID(String cusID);
	
	/**
	 * 根据用户名查询
	 * @param cusName
	 * @return
	 */
	CustomerInfoBean queryCustomerByName(String cusName);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<CustomerInfoBean> queryAllCustomer();

}

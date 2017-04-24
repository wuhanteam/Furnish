package com.softeem.dao;

import com.softeem.bean.CustomerInfoBean;
import com.softeem.bean.UserInfoBean;

public interface ILoginDao {

	/**
	 * 根据用户名称查询用户信息
	 * @param username
	 * @return
	 */
	public UserInfoBean queryUserInfo(String userName);
	
	/**
	 * 根据名称查询客户信息
	 * @param uname
	 * @return
	 */
	public CustomerInfoBean queryCustomInfo(String uname);
}

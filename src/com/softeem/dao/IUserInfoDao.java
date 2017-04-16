package com.softeem.dao;

import java.util.List;

import com.softeem.bean.UserInfoBean;
import com.softeem.utils.VOResult;

public interface IUserInfoDao {
	/**
	 * 查询全部
	 * @return
	 */
	List<UserInfoBean> queryUserInfoList();
	
	/**
	 * 
	 */
	UserInfoBean queryUserInfoByID(String userID);
	
	/**
	 * 添加管理员信息
	 * @param userInfo
	 * @return
	 */
	int insertUserInfo(UserInfoBean userInfo);
	
	/**
	 * 批量或单一删除用户信息
	 * @param userIDs
	 * @return
	 */
	int delUserInfoByID(String[] userIDs);
	
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	UserInfoBean queryUserInfo(String userName);
	
	/**
	 * 查询总条目数
	 * @return
	 */
	int queryUserInfoCount();
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return
	 */
	int updateUserInfo(UserInfoBean userInfo);
	
	/**
	 * 更新登录时间
	 * @param userInfo
	 * @return
	 */
	int updateLoginInfo(String username,String ipAddress);

	UserInfoBean findUser(String username, String pswd);


}

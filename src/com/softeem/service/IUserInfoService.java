package com.softeem.service;

import java.util.List;

import com.softeem.bean.UserInfoBean;
import com.softeem.utils.VOResult;

public interface IUserInfoService {

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<UserInfoBean> queryUserInfoList();

	/**
	 * 
	 */
	UserInfoBean queryUserInfoByID(String userID);

	/**
	 * 添加管理员信息
	 * 
	 * @param userInfo
	 * @return
	 */
	int insertUserInfo(UserInfoBean userInfo);

	/**
	 * 批量或单一删除用户信息
	 * 
	 * @param userIDs
	 * @return
	 */
	int delUserInfoByID(String[] userIDs);

	/**
	 * 根据用户工号查询
	 * 
	 * @param userCode
	 * @return
	 */
	UserInfoBean queryUserInfo(String userCode);

	/**
	 * 修改用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	int updateUserInfo(UserInfoBean userInfo);

	/**
	 * 更新登录时间
	 * 
	 * @param user
	 * @return
	 */
	int updateLoginInfo(String userCode, String ipAddress);

	VOResult queryUserInfoList(String sql, int beginPage, int pageSize);

	int findByUserCodeEmail(String userCode, String email);

	int updateFindPasswd(String userCode, String key, String now);

}

package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.bean.UserInfoBean;
import com.softeem.dao.ILoginDao;
import com.softeem.utils.DataSoureUtils;

@Repository(value="loginDaoImpl")
public class LoginDaoImpl implements ILoginDao{
	private Logger logger = Logger.getLogger(LoginDaoImpl.class);
	
	@Resource(name="dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	
	@Override
	public UserInfoBean queryUserInfo(String userName) {
		
		String queryUserInfo = "select t.adminname,t.adminpwd,t.params1 from t_userinfo t where t.adminname = ?";
		
		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement userPs = null;
		ResultSet userInfoResult = null;
		
		UserInfoBean userInfo = new UserInfoBean();
		try {
			// 查询
			userPs = connection.prepareStatement(queryUserInfo);
			userPs.setString(1, userName);
			userInfoResult = userPs.executeQuery();
			
			while(userInfoResult.next()){
				
				userInfo.setUserName(userInfoResult.getString("adminname"));
				userInfo.setUserPwd(userInfoResult.getString("adminpwd"));
				userInfo.setParams1(userInfoResult.getString("params1"));
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}finally {
			dataSoureUtils.close(userInfoResult);
			dataSoureUtils.close(userPs);
			dataSoureUtils.close(connection);
		}
		
		return userInfo;
	}

	
}

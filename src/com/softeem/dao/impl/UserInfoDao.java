package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.softeem.bean.UserInfoBean;
import com.softeem.dao.IUserInfoDao;
import com.softeem.utils.DataSoureUtils;
import com.softeem.utils.DateTimeUtil;
import com.softeem.utils.IDGenerator;

@Repository("userInfoDao")
public class UserInfoDao  implements IUserInfoDao {
	private Logger logger = Logger.getLogger(UserInfoDao.class);

	@Resource(name = "dataSoureUtils")
	private DataSoureUtils dataSoureUtils;
	

	@Override
	public List<UserInfoBean> queryUserInfoList() {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select * from t_userinfo order by CREATETIME";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserInfoBean> userInfoList = new ArrayList<UserInfoBean>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			// 查询
			while (resultSet.next()) {
				UserInfoBean userInfo = new UserInfoBean();
				userInfo.setUserID(resultSet.getString("userid"));
				userInfo.setUserCode(resultSet.getString("USERCODE"));
				userInfo.setUserPwd(resultSet.getString("adminpwd"));
				userInfo.setParams1(resultSet.getString("params1"));
				userInfo.setStatus(resultSet.getString("status"));
				userInfo.setLastLoginTime(resultSet.getString("LAST_LOGIN_TIME"));
				userInfo.setSalt(resultSet.getString("SALT"));
				userInfo.setIpaddress(resultSet.getString("IPADDRESS"));
				userInfo.setCreateTime(resultSet.getString("CREATETIME"));
				userInfo.setUserName(resultSet.getString("USERNAME"));
				userInfo.setValidateCode(resultSet.getString("VALIDATECODE"));
				userInfo.setOuteDate(resultSet.getString("OUTEDATE"));
				userInfo.setEmail(resultSet.getString("EMAIL"));
				userInfo.setMobile(resultSet.getString("MOBILE"));
				userInfo.setSpare01(resultSet.getString("SPARE01"));
				userInfo.setSpare02(resultSet.getString("SPARE02"));
				userInfo.setSpare03(resultSet.getString("SPARE03"));
				userInfoList.add(userInfo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();

		} finally {
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return userInfoList;
	}

	@Override
	public UserInfoBean queryUserInfoByID(String userID) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select ADMINPWD,CREATETIME,EMAIL,IPADDRESS,LAST_LOGIN_TIME,MOBILE,OUTEDATE,PARAMS1,"
				+ "SALT,SPARE01,SPARE02,SPARE03,STATUS,USERCODE,USERID,USERNAME,VALIDATECODE from t_userinfo where userid=? ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserInfoBean userInfo = new UserInfoBean();

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			resultSet = statement.executeQuery();

			// 查询
			while (resultSet.next()) {
				userInfo.setUserID(resultSet.getString("USERID"));
				userInfo.setUserCode(resultSet.getString("USERCODE"));
				userInfo.setUserPwd(resultSet.getString("ADMINPWD"));
				userInfo.setParams1(resultSet.getString("params1"));
				userInfo.setLastLoginTime(resultSet.getString("LAST_LOGIN_TIME"));
				userInfo.setSalt(resultSet.getString("SALT"));
				userInfo.setStatus(resultSet.getString("status"));
				userInfo.setIpaddress(resultSet.getString("IPADDRESS"));
				userInfo.setCreateTime(resultSet.getString("CREATETIME"));
				userInfo.setUserName(resultSet.getString("USERNAME"));
				userInfo.setValidateCode(resultSet.getString("VALIDATECODE"));
				userInfo.setOuteDate(resultSet.getString("OUTEDATE"));
				userInfo.setEmail(resultSet.getString("EMAIL"));
				userInfo.setMobile(resultSet.getString("MOBILE"));
				userInfo.setSpare01(resultSet.getString("SPARE01"));
				userInfo.setSpare02(resultSet.getString("SPARE02"));
				userInfo.setSpare03(resultSet.getString("SPARE03"));

			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return userInfo;
	}

	@Override
	public int insertUserInfo(UserInfoBean userInfo) {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "insert into t_userinfo (userid,USERCODE,USERNAME,MOBILE,EMAIL,adminpwd,params1,salt,status) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		// ResultSet resultSet = null;
		int result = -1;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, IDGenerator.generate9());
			statement.setString(2, userInfo.getUserCode());
			statement.setString(3, userInfo.getUserName());
			statement.setString(4, userInfo.getMobile());
			statement.setString(5, userInfo.getEmail());
			statement.setString(6, userInfo.getUserPwd());
			statement.setString(7, userInfo.getParams1());
			statement.setString(8, userInfo.getSalt());
			statement.setString(9, userInfo.getStatus());
			// 添加入库
			result = statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		} finally {
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return result;
	}

	@Override
	public int delUserInfoByID(String[] userIDs) {
		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		// 删除sql
		String sql = "delete from t_userinfo where userid =?";
		PreparedStatement statement = null;
		int result = -1;

		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < userIDs.length; i++) {
				statement.setString(1, userIDs[i]);
				statement.addBatch();
			}
			statement.executeBatch();
			connection.commit();
			result = 0;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		} finally {
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return result;
	}

	@Override
	public UserInfoBean queryUserInfo(String userCode) {

		String queryUserInfo = "select ADMINPWD,CREATETIME,EMAIL,IPADDRESS,LAST_LOGIN_TIME,MOBILE,OUTEDATE,PARAMS1,SALT,SPARE01,SPARE02,SPARE03,STATUS,USERCODE,USERID,USERNAME,VALIDATECODE from t_userinfo  where USERCODE = ?";

		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement userPs = null;
		ResultSet resultSet = null;

		UserInfoBean userInfo = null;
		try {
			// 查询
			userPs = connection.prepareStatement(queryUserInfo);
			userPs.setString(1, userCode);
			resultSet = userPs.executeQuery();

			while (resultSet.next()) {
				userInfo = new UserInfoBean();
				userInfo.setUserID(resultSet.getString("userid"));
				userInfo.setUserCode(resultSet.getString("USERCODE"));
				userInfo.setUserPwd(resultSet.getString("adminpwd"));
				userInfo.setParams1(resultSet.getString("params1"));
				userInfo.setLastLoginTime(resultSet.getString("LAST_LOGIN_TIME"));
				userInfo.setSalt(resultSet.getString("SALT"));
				userInfo.setStatus(resultSet.getString("STATUS"));
				userInfo.setIpaddress(resultSet.getString("IPADDRESS"));
				userInfo.setCreateTime(resultSet.getString("CREATETIME"));
				userInfo.setUserName(resultSet.getString("USERNAME"));
				userInfo.setValidateCode(resultSet.getString("VALIDATECODE"));
				userInfo.setOuteDate(resultSet.getString("OUTEDATE"));
				userInfo.setEmail(resultSet.getString("EMAIL"));
				userInfo.setMobile(resultSet.getString("MOBILE"));
				userInfo.setSpare01(resultSet.getString("SPARE01"));
				userInfo.setSpare02(resultSet.getString("SPARE02"));
				userInfo.setSpare03(resultSet.getString("SPARE03"));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(userPs);
			dataSoureUtils.close(connection);
		}

		return userInfo;
	}

	@Override
	public int queryUserInfoCount() {

		return 0;
	}

	@Override
	public int updateUserInfo(UserInfoBean userInfo) {
		String sql = "update t_userinfo set USERNAME= ?,STATUS=?,ADMINPWD=?,"
				+ "SALT=?,PARAMS1=?,MOBILE=?,EMAIL=? where USERID=? ";
		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement statement = null;
		int result = -1;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, userInfo.getUserName());
			statement.setString(2, userInfo.getStatus());
			statement.setString(3, userInfo.getUserPwd());
			statement.setString(4, userInfo.getSalt());
			statement.setString(5, userInfo.getParams1());
			statement.setString(6, userInfo.getMobile());
			statement.setString(7, userInfo.getEmail());
			statement.setString(8, userInfo.getUserID());
			statement.executeUpdate();
			result = 0;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		} finally {
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return result;
	}

	@Override
	public int updateLoginInfo(String userCode, String ipAddress) {
		String sql = "update t_userinfo set last_login_time=?,ipaddress=?  where USERCODE =? ";
		Connection connection = dataSoureUtils.getConnection();
		PreparedStatement statement = null;
		int result = -1;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, DateTimeUtil.getNow());
			statement.setString(2, ipAddress);
			statement.setString(3, userCode);
			statement.executeUpdate();
			result = 0;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return result;
		} finally {
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}
		return result;

	}

	@Override
	public UserInfoBean findUser(String username, String pswd) {

		// 获取数据库连接
		Connection connection = dataSoureUtils.getConnection();
		String sql = "select ADMINPWD,CREATETIME,EMAIL,IPADDRESS,LAST_LOGIN_TIME,MOBILE,OUTEDATE,PARAMS1,SALT,SPARE01,SPARE02,SPARE03,STATUS,USERCODE,USERID,USERNAME,VALIDATECODE where USERCODE=? and adminpwd=? ";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserInfoBean userInfo = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, pswd);
			resultSet = statement.executeQuery();

			// 查询
			while (resultSet.next()) {
				userInfo = new UserInfoBean();
				userInfo.setUserID(resultSet.getString("userid"));
				userInfo.setUserName(resultSet.getString("adminname"));
				userInfo.setUserPwd(resultSet.getString("adminpwd"));
				userInfo.setParams1(resultSet.getString("params1"));
				userInfo.setStatus(resultSet.getString("status"));
				userInfo.setLastLoginTime(resultSet.getString("last_login_time"));

			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			dataSoureUtils.close(resultSet);
			dataSoureUtils.close(statement);
			dataSoureUtils.close(connection);
		}

		return userInfo;
	}

}

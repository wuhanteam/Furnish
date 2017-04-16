package com.softeem.service.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.softeem.bean.UserInfoBean;
import com.softeem.dao.IJdbcDAO;
import com.softeem.dao.IUserInfoDao;
import com.softeem.service.IUserInfoService;
import com.softeem.utils.Constants;
import com.softeem.utils.ServiceResult;
import com.softeem.utils.VOResult;

@Service("userInfoServiceImpl")
public class UserInfoServiceImpl implements IUserInfoService {
	private Logger logger = Logger.getLogger(UserInfoServiceImpl.class);
	@Resource(name = "userInfoDao")
	private IUserInfoDao dao;
	@Resource(name = "iJdbcDAO")
	private IJdbcDAO jdbcDAO;

	@Override
	public List<UserInfoBean> queryUserInfoList() {
		return dao.queryUserInfoList();
	}

	@Override
	public VOResult queryUserInfoList(String sql, int beginPage, int pageSize) {
		return jdbcDAO.query(sql, new ResultSetExtractor() {
			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				while (rs.next()) {
					Map map = new HashMap<String, Object>();;
					for (int i = 1; i <= columns; i++) {
						
						map.put(md.getColumnName(i), rs.getObject(i));
					}
					list.add(map);
				}
				return list;
			}
		}, beginPage, pageSize);
	}

	@Override
	public UserInfoBean queryUserInfoByID(String userID) {
		return dao.queryUserInfoByID(userID);
	}

	@Override
	public int insertUserInfo(UserInfoBean userInfo) {
		return dao.insertUserInfo(userInfo);
	}

	@Override
	public int delUserInfoByID(String[] userIDs) {

		return dao.delUserInfoByID(userIDs);
	}

	@Override
	public UserInfoBean queryUserInfo(String userCode) {

		return dao.queryUserInfo(userCode);
	}

	@Override
	public int updateUserInfo(UserInfoBean userInfo) {

		return dao.updateUserInfo(userInfo);
	}

	@Override
	public int updateLoginInfo(String userCode, String ipAddress) {

		return dao.updateLoginInfo(userCode, ipAddress);

	}

	@Override
	public int findByUserCodeEmail(final String userCode, final String email) {
		String sql = "select t.userid from     t_userinfo t where t.usercode = ? and t.email=?";
		return jdbcDAO.getCount(sql, new String[]{userCode,email});
		
	}

	@Override
	public int updateFindPasswd(String userCode, String key, String now) {
		String sql = "update t_userinfo t set t.validatecode=?,t.outedate=? where t.usercode = ?";
		return jdbcDAO.executeUpdate(sql, new String[]{key,now,userCode});
		
	}

}
